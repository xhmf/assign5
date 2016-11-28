/**
  * Created by lyee on 11/27/16.
  */
package com.example.assign5

trait program_stack {
  val program_bool = scala.collection.mutable.HashMap.empty[String, Boolean]
  val function_bool = scala.collection.mutable.HashMap.empty[String, Boolean]

  val program_int = scala.collection.mutable.HashMap.empty[String, Int]
  val function_int = scala.collection.mutable.HashMap.empty[String, Int]
}

class Evaluate extends program_stack {
  def recur(node: Node) {
    node.identification match {
      /*All nodes with exactly one child which will NOT continue the AST any further
        Aditionally, I just changed the structure of "setvalue" so that it will be completely flat.
        This means that plus, minus, etc. should all be absorbed by setvalue and this statement should
        never get hit for any of these cases, besides the last 4.
        */

      case "equals" => {
        equalsto(node)
        return node
      }
      case "greaterthan" => {
        greaterthan(node)
        return node
      }

      case "return" => {
        returnto(node)
        return node
      }
      case "setinitialvalue" => {
        setinitialvalue(node)
        return node
      }
      case "if" => {
        ifcase(node)
        return node
      }
      //"While" will have three nodes - conditional, statement, rest of tree
      case "while" => {
        whilecase(node)
        return node
      }
      /*Declare method can have 2-4 params in the following order:
          method name
          [optional] arguments
          [optional] inner AST
          remaineder of the AST

          ALSO for now I'm treating methods with a return statement the same as I'd treat a
          void method. The return statement will be at the bottom of the function's AST.
          If we want to push the return statement up to the function level,
          I can easily change that later.
       */

      // nonvoidmethod can't be used like declaremethod
      case "declaremethod" => {
        declaremethod(node)
        return node
      }
      // callmethod will have 3 children, the method name, "arguments", and the rest of the AST
      // "arguments" will have n number of children representing the corresponding n arguments of the tree
      case "callmethod" => {
        callmethod(node)
        return node
      }
      //assignvariablefrommethodcall will have three args - variable name, func call, rest of AST
      //I think this function is unnecessary. We'll see if we can remove this in the future.
      case "assignvariablefrommethodcall" => {
        assignvariablefrommethodcall(node)
        return node
      }
      //Three nodes - var name, int value (caught by setinitialvalue), rest of ast
      case "declareint" => {
        declareint(node)
        return node
      }
      //Should only have one AST but this one's the most important!!!!
      case "beginmain" => {
        beginmain(node)
        return node
      }
      //Two nodes! What to print and the AST
      case "print" => {
        printto(node)
        return node
      }
      /*This one only has three children. Name of variable to assign,
        the assignment equation (caught by setvalue), and the rest of the tree
       */
      case "assignvariable" => {
        assignvariable(node)
        return node
      }
      /*This is the fun one! It has n children but we don't know how many it has until we
        hit the breakCode, aka endassignvariable
       */
      case "setvalue" => {
        val result = setvalue(node)
        return result
      }
      case "endmain" => {
        println()
      }
      //Uhoh!! Should never reach here!!
      case _ => {
        //All leaf nodes should be caught by one of the other methods :PPPP
        throw new Exception("Spotted unexpected token:: " + node.identification)
      }
    }
  }

  def equalsto(node: Node): Unit = {

  }

  def greaterthan(node: Node): Unit = {

  }

  def returnto(node: Node): Unit = {

  }

  def setinitialvalue(node: Node): Unit = {

  }

  def ifcase(node: Node): Unit = {

  }

  def whilecase(node: Node): Unit = {

  }

  def declaremethod(node: Node): Unit = {

  }

  def callmethod(node: Node): Unit = {

  }

  def assignvariablefrommethodcall(node: Node): Unit = {

  }

  def declareint(node: Node): Unit = {

  }

  def beginmain(node: Node): Unit = {
    recur(node.nodeChildren(0))
  }

  def printto(node: Node): Unit = {
    println(node.nodeChildren(0).identification)
    recur(node.nodeChildren(1))
  }

  def assignvariable(node: Node): Unit = {
    val name = node.nodeChildren(0).identification
    val num = setvalue(node.nodeChildren(1))
    if (program_int contains name) {
      program_int(name) = num // Might be an error because reassigning a variable.
    } else {
      program_int += (name -> num)
    }
  }

  def setvalue(node: Node): Int = {
    if (node.nodeChildren.size == 0) {
      return 0
    }
    var op = ""
    var num = node.nodeChildren(0).identification.toInt
    for (symbol <- node.nodeChildren.drop(1)) {
      try {
        var cur = symbol.identification.toInt
        op match {
          case "+" => num += cur
          case "-" => num -= cur
          case "*" => num *= cur
          //          Division not working for some reason
          //          case "/" => num = (Int) (num/cur)
          case _ => return num
        }
      } catch {
        case e: Exception => {
          op = symbol.identification
        }
      }
    }
    num
  }
}

object evaluate_object extends Evaluate