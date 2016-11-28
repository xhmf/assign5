/**
  * Created by lyee on 11/27/16.
  */
package com.example.assign5

class Evaluate {
  def recur(node:Node){
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
      //callmethod has 2 nodes - method name, [non-optional] method param
      //(rest of the tree is included in whatever calls this function)
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
        setvalue(node)
         return node
      }
      //Uhoh!! Should never reach here!!
      case _ => {
        //All leaf nodes should be caught by one of the other methods :PPPP
        throw new Exception("Could not parse :: "+node.identification)
      }
    }
  }

  def equalsto(node:Node): Unit = {

  }
  def greaterthan(node:Node): Unit = {

  }
  def returnto(node:Node): Unit = {

  }
  def setinitialvalue(node:Node): Unit = {

  }
  def ifcase(node:Node): Unit = {

  }
  def whilecase(node:Node): Unit = {

  }
  def declareint(node:Node): Unit = {

  }
  def declaremethod(node:Node): Unit = {

  }
  def callmethod(node:Node): Unit = {

  }
  def assignvariablefrommethodcall(node:Node): Unit = {

  }
  def declareint(node:Node): Unit = {

  }
  def beginmain(node:Node): Unit = {

  }
  def printto(node:Node): Unit = {

  }
  def assignvariable(node:Node): Unit = {

  }
  def setvalue(node:Node): Unit = {

  }
}
