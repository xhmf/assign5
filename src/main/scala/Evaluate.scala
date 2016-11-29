/**
  * Created by lyee on 11/27/16.
  */
package com.example.assign5
import scala.collection.mutable.ArrayBuffer

trait program_stack {
  // holds the variable scope
  val program_bool = scala.collection.mutable.HashMap.empty[String, Boolean]
  
  //holds the function scope
  val program_int = scala.collection.mutable.HashMap.empty[String, Int]

  // holds the function object
  val function_evaluate = scala.collection.mutable.HashMap.empty[String, FuncInfo]
}
abstract class FuncInfo{
  var name:String
  var body:Node
  val function_bool = scala.collection.mutable.HashMap.empty[String, Boolean]
  val function_int = scala.collection.mutable.HashMap.empty[String, Int]
  var variables:ArrayBuffer[String]
  var nonvoid:Boolean

}

class Evaluate extends program_stack {
  def isDigit(char: Char):Boolean = {
    return (char + "").forall(_.isDigit) || (char == '.')
  }

  def recur(node: Node, funcObject: FuncInfo) {
    node.identification match {
      /*All nodes with exactly one child which will NOT continue the AST any further
        Aditionally, I just changed the structure of "setvalue" so that it will be completely flat.
        This means that plus, minus, etc. should all be absorbed by setvalue and this statement should
        never get hit for any of these cases, besides the last 4.
        */

      case "equals" => {
        equalsto(node, funcObject)
        return node
      }
      case "greaterthan" => {
        greaterthan(node, funcObject)
        return node
      }

      case "return" => {
        returnto(node, funcObject)
        return node
      }
      case "setinitialvalue" => {
        setinitialvalue(node, funcObject)
        return node
      }
      case "if" => {
        ifcase(node, funcObject)
        return node
      }
      //"While" will have three nodes - conditional, statement, rest of tree
      case "while" => {
        whilecase(node, funcObject)
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
        declaremethod(node, funcObject)
        return node
      }
      // callmethod will have 3 children, the method name, "arguments", and the rest of the AST
      // "arguments" will have n number of children representing the corresponding n arguments of the tree
      case "callmethod" => {
        callmethod(node, funcObject)
        return node
      }
      //assignvariablefrommethodcall will have three args - variable name, func call, rest of AST
      //I think this function is unnecessary. We'll see if we can remove this in the future.
      case "assignvariablefrommethodcall" => {
        assignvariablefrommethodcall(node, funcObject)
        return node
      }
      //Three nodes - var name, int value (caught by setinitialvalue), rest of ast
      case "declareint" => {
        declareint(node, funcObject)
        return node
      }
      //Should only have one AST but this one's the most important!!!!
      case "beginmain" => {
        beginmain(node, funcObject)
        return node
      }
      //Two nodes! What to print and the AST
      case "print" => {
        printto(node, funcObject)
        return node
      }
      /*This one only has three children. Name of variable to assign,
        the assignment equation (caught by setvalue), and the rest of the tree
       */
      case "assignvariable" => {
        assignvariable(node, funcObject)
        return node
      }
      /*This is the fun one! It has n children but we don't know how many it has until we
        hit the breakCode, aka endassignvariable
       */
      case "setvalue" => {
        val result = setvalue(node, funcObject)
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

  def equalsto(node: Node, funcObject: FuncInfo): Unit = {

  }

  def greaterthan(node: Node, funcObject: FuncInfo): Unit = {

  }

  def returnto(node: Node, funcObject: FuncInfo): Unit = {

  }

  def setinitialvalue(node: Node, funcObject: FuncInfo): Unit = {

  }

  def ifcase(node: Node, funcObject: FuncInfo): Unit = {

  }

  def whilecase(node: Node, funcObject: FuncInfo): Unit = {

  }
  //ASSUMING methodname, variable node, voidnode, function node, rest of tree
  def declaremethod(node: Node, funcObject: FuncInfo): Unit = {
    // the function body is keyed on the name of the function
    // for every variable, we add it's name to the list of function variables
    val func_object = new FuncInfo {
      override var name: String = node.nodeChildren(0).identification
      override var body: Node = node.nodeChildren(3)
      override var variables: ArrayBuffer[String] = new ArrayBuffer[String]
      override var nonvoid: Boolean = false
    }

    if(node.nodeChildren(2).identification.equals("nonvoidmethod")){
      func_object.nonvoid = true
    }

    for(var_name <- node.nodeChildren(1).nodeChildren) {
      func_object.variables += var_name.identification
    }
    function_evaluate(node.nodeChildren(0).identification) = func_object

    // now we evaluate the rest of the tree
    recur(node.nodeChildren(4), funcObject)
  }
  //ASSUMING: method name, method variable node, rest of tree
  // We need to have either a separate recur that can return someting or change recur to return
  def callmethod(node: Node, funcObject: FuncInfo): Unit = {
    val currfuncObject = function_evaluate(node.nodeChildren(0).identification)
    var arguments = node.nodeChildren(1)
    for(var_index <- 0 to currfuncObject.variables.length){
      var argument = arguments.nodeChildren(var_index).identification

      //In the case of vars, set the argument value to the value of the variable
      //check each variable scope for the variable

      //Check function bools
      if(funcObject.function_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = funcObject.function_bool(argument)
      }
      //Check function ints
      else if(funcObject.function_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = funcObject.function_int(argument)
      }
      //Check program bools
      else if(program_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = program_bool(argument)
      }
      //Check program ints
      else if(program_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = program_int(argument)
      }
      //case for ints
      else if(isInt(argument)){
        currfuncObject.function_int(currfuncObject.variables(var_index)) = argument.toInt
      }
      //case for booleans
      else if(isBoolean(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = argument.toBoolean
      }
    }
    // recur also needs a parameter that lest you know wether or not you're inside a function
    recur(currfuncObject.body, currfuncObject)
    recur(node.nodeChildren(2), funcObject)
  }

  def assignvariablefrommethodcall(node: Node, funcObject: FuncInfo): Unit = {

  }

  def declareint(node: Node, funcObject: FuncInfo): Unit = {

  }

  def beginmain(node: Node, funcObject: FuncInfo): Unit = {
    recur(node.nodeChildren(0), funcObject)
  }

  def printto(node: Node, funcObject: FuncInfo): Unit = {
    var variable = node.nodeChildren(0).identification
    if(funcObject.function_bool.contains(variable)) {
      println(funcObject.function_bool(variable))
    }
    //Check function ints
    else if(funcObject.function_int.contains(variable)) {
      println(funcObject.function_int(variable))
    }
    //Check program bools
    else if(program_bool.contains(variable)) {
      println(program_bool(variable))
    }
    //Check program ints
    else if(program_int.contains(variable)) {
      println(program_int(variable))
    }
    //case for ints and booleans and strings
    else {
      println(node.nodeChildren(0).identification)
    }
    recur(node.nodeChildren(1), funcObject)
  }

  def assignvariable(node: Node, funcObject: FuncInfo): Unit = {
    val name = node.nodeChildren(0).identification
    //Check to see if this operation is performed on an int or a bool
    if(isInt(node.nodeChildren(1).nodeChildren(0).identification)) {
      val result = setvalueInt(node.nodeChildren(1), funcObject)
      setIntHelper(name, result, funcObject)
    }
    else {
      val result = setvalueBool(node.nodeChildren(1), funcObject)
      setBooleanHelper(name, result, funcObject)
    }
  }

  def setvalueInt(node: Node, funcObject: FuncInfo): Int = {
    if (node.nodeChildren.size == 0) {
      throw new Exception("YOU TRIED TO SET A VALUE TO NOTHING")
    }
    var op = ""
    var num:Int = node.nodeChildren(0).identification.toInt
    for (symbol <- node.nodeChildren.drop(1)) {
      if(isInt(symbol.identification)) {
        var cur = symbol.identification.toInt
        op match {
          case "plus" => num += cur
          case "minus" => num -= cur
          case "multiply" => num *= cur
          case "divide" => num /= cur
          case _ => return num
        }
      }
      else {
        op = symbol.identification
      }
    }
    return num
  }

  def setvalueBool(node: Node, funcObject: FuncInfo): Boolean = {
    if (node.nodeChildren.size == 0) {
      throw new Exception("that should be in all caps lyee")
    }
    var op = ""
    var bool:Boolean = node.nodeChildren(0).identification.toBoolean
    for (symbol <- node.nodeChildren.drop(1)) {
      if(isBoolean(symbol.identification)) {
        var cur = symbol.identification.toBoolean
        op match {
          case "and" => bool = bool && cur
          case "or" => bool = bool || cur
          case _ => return bool
        }
      }
      else {
        op = symbol.identification
      }
    }
    return bool
  }

  def isBoolean(string: String): Boolean = {
    return  string.equals("true") || string.equals("false")
  }
  def isInt(string: String): Boolean = {
    return  string.charAt(0).isDigit || string.charAt(0) =='-'
  }

  def setIntHelper(variable:String, num:Int, funcObject: FuncInfo): Unit = {
    //If we are inside a function and the function contains the variable we are referencing
    if(funcObject.function_int contains variable) {
      funcObject.function_int(variable) = num
    }
    //If the global scope contains the variable we are referencing
    else if(program_int contains variable) {
      program_int(variable) = num // Might be an error because reassigning a variable.
    }
    //If we are inside a function scope and the function contains the variable
    else if(!funcObject.name.equals("")) {
      funcObject.function_int += (variable -> num)
    }
    //This means that no variable has been created previously and we are in the global scope
    else {
      program_int += (variable -> num)
    }
  }
  def setBooleanHelper(variable:String, bool:Boolean, funcObject: FuncInfo): Unit = {
    //If we are inside a function and the function contains the variable we are referencing
    if(funcObject.function_bool contains variable) {
      funcObject.function_bool(variable) = bool
    }
    //If the global scope contains the variable we are referencing
    else if(program_bool contains variable) {
      program_bool(variable) = bool // Might be an error because reassigning a variable.
    }
    //If we are inside a function scope and the function contains the variable
    else if(!funcObject.name.equals("")) {
      funcObject.function_bool += (variable -> bool)
    }
    //This means that no variable has been created previously and we are in the global scope
    else {
      program_bool += (variable -> bool)
    }
  }
}

object evaluate_object extends Evaluate