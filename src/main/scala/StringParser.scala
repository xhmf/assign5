/**
  * Created by lyee on 11/20/16.
  */

package com.example.assign5

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

trait has_args{
  // This stores a map of method names to the number of arguments
  // yes, arnoldC does in fact support multple arguments
  val argument_function = scala.collection.mutable.HashMap.empty[String,Int]
}

class StringParser extends has_args{
  var givenList:ListBuffer[String] = new ListBuffer[String]
  def parseStringIntoAST(string: String): Node = {
    givenList = StringListInstance.getSequence(string)
    for (i <- givenList) {
      println(i)
    }
    recur("endmain")
  }

  private def createNode(name:String) : Node = {
    return new Node {
      override var nodeChildren: ArrayBuffer[Node] = new ArrayBuffer[Node]
      override var identification: String = name
    }
  }

  private def recur(breakCode:String): Node = {
    //If it's equal to the checkop, continue with the code
    var checkOp:String = givenList(0)
    //needs a special case for if vs if/else
    if(checkOp.equals(breakCode) || (checkOp.equals("else") && breakCode.equals("endif"))) {
      //Don't remove the breakCode, specifically for the if statement
      return createNode(checkOp)
    }
    //surround with try catch!!
    var currOp:String = givenList.remove(0)
    var node = createNode(currOp)
    node.identification match {
      /*All nodes with exactly one child which will NOT continue the AST any further
        Aditionally, I just changed the structure of "setvalue" so that it will be completely flat.
        This means that plus, minus, etc. should all be absorbed by setvalue and this statement should
        never get hit for any of these cases, besides the last 4.
        */
      case "plus"
           | "minus"
           | "multiply"
           | "divide"
           | "mod"
           | "equals"
           | "greaterthan"
           | "or"
           | "and"
           | "methodargs"
           | "return"
        //this was causing all sorts of problems
        //   | "callmethod"
           | "setinitialvalue" => {
        node.nodeChildren += createNode(givenList.remove(0))
        return node
      }
      //"if" will have 3 nodes - conditional, statement, rest of tree
      //"if else" will have 4 ndoes - conditional, statement, else statement, rest of tree
      case "if" => {
        //Add the conditional variable
        node.nodeChildren += createNode(givenList.remove(0))
        //Insert body here
        node.nodeChildren += recur("endif")
        //If there's an else, it will be at the top of the stack


        currOp = givenList.remove(0)
        println("curOp: " + currOp)
        if(currOp.equals("else")) {
          node.nodeChildren += recur("endif")
          givenList.remove(0)
          println("ADDED CHILD")
        }
        node.nodeChildren += recur(breakCode)
        return node
      }
      //"While" will have three nodes - conditional, statement, rest of tree
      case "while" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("endwhile")
        givenList.remove(0)
        node.nodeChildren += recur(breakCode)
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
        //Add method name

        val methodname = givenList.remove(0)
        node.nodeChildren += createNode(methodname)
        val argsNode = createNode("args")
        node.nodeChildren += argsNode
        //If arguments is at the top of the stack
        argument_function(methodname) = 0
        //There's the possibity of multiple arguments, but each is preceeded by methodargs
        while(givenList(0).equals("methodargs")) {
          //println(methodname + " Has Args")
          //remove methodargs because we don't need that on the stack
          givenList.remove(0)
          argsNode.nodeChildren += createNode(givenList.remove(0))
          argument_function(methodname) = argument_function(methodname) + 1
        }


        // println("MARkED:" + argument_function.keys)

        // if this is a nonvoid method, we'll note that before the function body
        if(givenList(0).equals("nonvoidmethod")){
          node.nodeChildren += createNode(givenList.remove(0))
        }
        else{
          node.nodeChildren += createNode("voidmethod")
        }
        //If body is at the top of the stack
        if(!givenList(0).equals("endmethod")) {
          node.nodeChildren += recur("endmethod")
        }
        else {
          node.nodeChildren+= createNode("empty body")
        }
        //Now no matter what, endmethod will be at the top of the stack
        givenList.remove(0)

        //now store the rest of the tree as the last child node
        node.nodeChildren += recur(breakCode)
        return node
      }
      /* ASSUMES THAT EVERYTHING HAS A PARAMETER FOR NOW
        Calling a method is messy. We don't know if there will be a parameter during the call or not,
        and I can't think of a way of checking for one intuitively. One solution I have is that since
        we're forcing methods to be initialized before they're called, we can store two sets as we're
        parsing our code (so before we evaluate it) - one set with the methods that have a single
        parameter (so we can parse out the parameter from the list) and one set with methods that don't
        have the parameter (so we move on with our lives). This way, by the time we call the method in
        our parse function (where we're at right now) we can check the resulting string against the two
        sets and determine whether or not the function has an argument. I might do this implementation
        later, but for now the naive solution assumes that everything will have a parameter.
        */
      //callmethod has 3 nodes - method name, arguments, rest of the tree
        //arguments contains 0 or more arguments as children
      case "callmethod" => {
        val methodname = givenList(0)
        node.nodeChildren += createNode(givenList.remove(0))
        var method_arg_number = argument_function(methodname)
        val argsNode = createNode("args")
        node.nodeChildren += argsNode
        while(method_arg_number > 0){
          argsNode.nodeChildren += createNode(givenList.remove(0))
          method_arg_number -= 1
        }
        node.nodeChildren+= recur(breakCode)
        return node
      }
      //assignvariablefrommethodcall will have three args - variable name, func call, rest of AST
      //I think this function is unnecessary. We'll see if we can remove this in the future.
      case "assignvariablefrommethodcall" => {
        node.nodeChildren += createNode(givenList.remove(0))
        //The next case will be callmethod
        node.nodeChildren += createNode(givenList.remove(0))

        val methodname = givenList(0)
        node.nodeChildren(1).nodeChildren += createNode(givenList.remove(0))
        var method_arg_number = argument_function(methodname)
        val argsNode = createNode("args")
        node.nodeChildren(1).nodeChildren += argsNode
        while(method_arg_number > 0){
          argsNode.nodeChildren += createNode(givenList.remove(0))
          method_arg_number -= 1
        }
        node.nodeChildren += recur(breakCode)
        return node
      }
      //Three nodes - var name, int value (caught by setinitialvalue), rest of ast
      case "declareint" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("irrelevant; should hit the setinitialvalue case")
        node.nodeChildren += recur(breakCode)
        return node
      }
      //Should only have one AST but this one's the most important!!!!
      case "beginmain" => {
        node.nodeChildren += recur("endmain")
        return node
      }
      //Two nodes! What to print and the AST
      case "print" => {
        //println("Should reach")
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur(breakCode)
        return node
      }
      /*This one only has three children. Name of variable to assign,
        the assignment equation (caught by setvalue), and the rest of the tree
       */
      case "assignvariable" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("endassignvariable")
        givenList.remove(0)
        node.nodeChildren += recur(breakCode)
        return node
      }
      /*This is the fun one! It has n children but we don't know how many it has until we
        hit the breakCode, aka endassignvariable
       */
      case "setvalue" => {
        //println("Given list before setvalue does its shit")
        //First node is the first variable that we start with
        node.nodeChildren += createNode(givenList.remove(0))
        //This part is essentially a "fold" operation
        currOp = givenList(0)

        //runs until the value of this operation reaches endassignvariable
        while(!currOp.equals("endassignvariable")) {
          //catches any operation, which will then proceed to have one node after it
          node.nodeChildren += createNode(currOp)
          //Don't remove endassignvariable here for consistency. Remove it in assignvariable, which calls this.
          if(!givenList(0).equals("endassignvariable")) {
            givenList.remove(0)
          }
          currOp = givenList(0)
        }
        //Don't need to store the rest of the AST since the tree will
        return node
      }
      //Uhoh!! Should never reach here!!
      case _ => {
        //All leaf nodes should be caught by one of the other methods :PPPP
        throw new Exception("Could not parse :: "+currOp)
      }
    }
  }
}
