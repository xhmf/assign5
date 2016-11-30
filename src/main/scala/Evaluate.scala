/**
  * Created by lyee on 11/27/16.
  */
package com.example.assign5

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.runtime.Nothing$
import scala.util.control.NonFatal

trait program_stack {
  // holds the variable scope
  val program_bool = scala.collection.mutable.HashMap.empty[String, Boolean]

  //holds the function scope
  val program_int = scala.collection.mutable.HashMap.empty[String, Int]

  // holds the function object
  val function_evaluate = scala.collection.mutable.HashMap.empty[String, FuncInfo]
}

abstract class FuncInfo {
  var name: String
  var body: Node
  val function_bool = scala.collection.mutable.HashMap.empty[String, Boolean]
  val function_int = scala.collection.mutable.HashMap.empty[String, Int]
  var variables: ArrayBuffer[String]
  var nonvoid: Boolean

}

class Evaluate extends program_stack {
  def isDigit(char: Char): Boolean = {
    return (char + "").forall(_.isDigit) || (char == '.')
  }

  def recur(node: Node, funcObject: FuncInfo): String = {
    node.identification match {
      /*All nodes with exactly one child which will NOT continue the AST any further
        Aditionally, I just changed the structure of "setvalue" so that it will be completely flat.
        This means that plus, minus, etc. should all be absorbed by setvalue and this statement should
        never get hit for any of these cases, besides the last 4.
        */
      case "return" => {
        return returnto(node, funcObject)
      }
      case "if" => {
        ifcase(node, funcObject)
      }
      //"While" will have three nodes - conditional, statement, rest of tree
      case "while" => {
        whilecase(node, funcObject)
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
      }
      // callmethod will have 3 children, the method name, "arguments", and the rest of the AST
      // "arguments" will have n number of children representing the corresponding n arguments of the tree
      case "callmethod" => {
        callmethod(node, funcObject)
      }
      //assignvariablefrommethodcall will have three args - variable name, func call, rest of AST
      //I think this function is unnecessary. We'll see if we can remove this in the future.
      case "assignvariablefrommethodcall" => {
        assignvariablefrommethodcall(node, funcObject)
      }
      //Three nodes - var name, int value (caught by setinitialvalue), rest of ast
      case "declareint" => {
        declareint(node, funcObject)
      }
      //Should only have one AST but this one's the most important!!!!
      case "beginmain" => {
        beginmain(node, funcObject)
      }
      //Two nodes! What to print and the AST
      case "print" => {
        printto(node, funcObject)
      }
      /*This one only has three children. Name of variable to assign,
        the assignment equation (caught by setvalue), and the rest of the tree
       */
      case "assignvariable" => {
        assignvariable(node, funcObject)
      }
      case "endmain" => {

      }
      case "endif" => {

      }
      case "else" => {

      }
      case "endwhile" => {

      }
      case "endmethod" =>{

      }
      //Uhoh!! Should never reach here!!
      case _ => {
        //All leaf nodes should be caught by one of the other methods :PPPP
        throw new Exception("Spotted unexpected token:: " + node.identification)
      }
    }
    return ""
  }

  def returnto(node: Node, funcObject: FuncInfo): String = {
    var variable = node.nodeChildren(0).identification
    if (funcObject.function_bool.contains(variable)) {
      return funcObject.function_bool(variable).toString
    }
    //Check function ints
    else if (funcObject.function_int.contains(variable)) {
      return funcObject.function_int(variable).toString
    }
    //Check program bools
    else if (program_bool.contains(variable)) {
      return program_bool(variable).toString
    }
    //Check program ints
    else if (program_int.contains(variable)) {
      return program_int(variable).toString
    }
    //case for ints and booleans and strings
    else {
      return variable
    }
  }

  //The conditional as the nodeChildren(0) will only have one of the following values:
  //"true", "false", or a variable
  //Also check number of children since there might be an else case here
  def ifcase(node: Node, funcObject: FuncInfo): Unit = {
    val cond = node.nodeChildren(0).identification
    val numNodes = node.nodeChildren.size
    getBoolFromVar(cond, funcObject) match {
      case Some(bool) => if (bool) {
        recur(node.nodeChildren(1), funcObject)
      } else if (numNodes == 4) {
        recur(node.nodeChildren(2), funcObject)
      }
      case None => println("ERROR") // probably throw error
    }
    recur(node.nodeChildren(numNodes-1), funcObject)
  }

  //The conditional as the nodeChildren(0) will only have one of the following values:
  //"true", "false", or a variable
  def whilecase(node: Node, funcObject: FuncInfo): Unit = {
    val condString = node.nodeChildren(0).identification
    var cond = true
    while (cond) {
      getBoolFromVar(condString, funcObject) match {
        case Some(bool) => if (bool) {
          recur(node.nodeChildren(1), funcObject)
        } else {
          cond = false
        } // Only continue if condition is true
        case _ => cond = false
      }
    }
    recur(node.nodeChildren(2), funcObject)
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

    if (node.nodeChildren(2).identification.equals("nonvoidmethod")) {
      func_object.nonvoid = true
    }

    for (var_name <- node.nodeChildren(1).nodeChildren) {
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
    //for (var_index <- 0 to currfuncObject.variables.length) {
    var var_index:Int = 0
    while(var_index < currfuncObject.variables.length){
      var argument = arguments.nodeChildren(var_index).identification
      //In the case of vars, set the argument value to the value of the variable
      //check each variable scope for the variable

      //Check function bools
      if (funcObject.function_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = funcObject.function_bool(argument)
      }
      //Check function ints
      else if (funcObject.function_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = funcObject.function_int(argument)
      }
      //Check program bools
      else if (program_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = program_bool(argument)
      }
      //Check program ints
      else if (program_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = program_int(argument)
      }
      //case for ints
      else if (isInt(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = argument.toInt
      }
      //case for booleans
      else if (isBoolean(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = argument.toBoolean
      }
      var_index = var_index + 1
    }
    // recur also needs a parameter that lest you know whether or not you're inside a function
    recur(currfuncObject.body, currfuncObject)
    recur(node.nodeChildren(2), funcObject)

  }

  def assignvariablefrommethodcall(node: Node, funcObject: FuncInfo): Unit = {
    var variableToAssign = node.nodeChildren(0).identification
    val currfuncObject = function_evaluate(node.nodeChildren(1).identification)
    val arguments = node.nodeChildren(2)
    for (var_index <- 0 to currfuncObject.variables.length) {
      val argument = arguments.nodeChildren(var_index).identification

      //In the case of vars, set the argument value to the value of the variable
      //check each variable scope for the variable

      //Check function bools
      if (funcObject.function_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = funcObject.function_bool(argument)
      }
      //Check function ints
      else if (funcObject.function_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = funcObject.function_int(argument)
      }
      //Check program bools
      else if (program_bool.contains(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = program_bool(argument)
      }
      //Check program ints
      else if (program_int.contains(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = program_int(argument)
      }
      //case for ints
      else if (isInt(argument)) {
        currfuncObject.function_int(currfuncObject.variables(var_index)) = argument.toInt
      }
      //case for booleans
      else if (isBoolean(argument)) {
        currfuncObject.function_bool(currfuncObject.variables(var_index)) = argument.toBoolean
      }
    }
    // recur also needs a parameter that lest you know whether or not you're inside a function
    val returnResult = recur(currfuncObject.body, currfuncObject)

    //Check to see if the variable which we're assigning exists
    if (funcObject.function_bool.contains(variableToAssign)) {

    }
    //TODO: Debug this if functions break?
    if (isInt(returnResult)) {
      setIntHelper(variableToAssign, returnResult.toInt, funcObject)
    }
    else {
      setBooleanHelper(variableToAssign, returnResult.toBoolean, funcObject)
    }
    recur(node.nodeChildren(2), funcObject)
  }

  def declareint(node: Node, funcObject: FuncInfo): Unit = {
    if (isInt(node.nodeChildren(1).nodeChildren(0).identification))
      setIntHelper(node.nodeChildren(0).identification, node.nodeChildren(1).nodeChildren(0).identification.toInt, funcObject)
    else
      setBooleanHelper(node.nodeChildren(0).identification, node.nodeChildren(1).nodeChildren(0).identification.toBoolean, funcObject)
    recur(node.nodeChildren(2), funcObject)
  }

  def beginmain(node: Node, funcObject: FuncInfo): Unit = {
    recur(node.nodeChildren(0), funcObject)
  }

  def printto(node: Node, funcObject: FuncInfo): Unit = {
    var variable = node.nodeChildren(0).identification
    var maybeIntNone = getIntFromVar(variable, funcObject)
    var maybeBoolNone = getBoolFromVar(variable, funcObject)
    if (maybeIntNone.nonEmpty) {
      println(getIntFromVar(variable, funcObject).get)
    }
    else if (maybeBoolNone.nonEmpty) {
      println(getBoolFromVar(variable, funcObject).get)
    }
    else {
      println(variable)
    }
    recur(node.nodeChildren(1), funcObject)
  }

  def assignvariable(node: Node, funcObject: FuncInfo): Unit = {
    val name = node.nodeChildren(0).identification
    //Check to see if this operation is performed on an int or a bool
    var willReturnInt: Boolean = true
    for (child <- node.nodeChildren(1).nodeChildren) {
      //For every node inside of the setvalue function, if we run into a case which is either:
      //Not an int, not an op, or does not exist as a variable
      //we automatically know that the result of setvalue will be a boolean.
      if (!(isInt(child.identification)
        || isOp(child.identification)
        || funcObject.function_int.contains(child.identification)
        || program_int.contains(child.identification))) {
        willReturnInt = false
      }
    }
    if (willReturnInt) {
      val result = setvalueInt(node.nodeChildren(1), funcObject)
      setIntHelper(name, result, funcObject)
    }
    else {
      val result = setvalueBool(node.nodeChildren(1), funcObject)
      setBooleanHelper(name, result, funcObject)
    }
    recur(node.nodeChildren(2), funcObject)
  }

  def setvalueInt(node: Node, funcObject: FuncInfo): Int = {
    if (node.nodeChildren.size == 0) {
      throw new Exception("YOU TRIED TO SET A VALUE TO NOTHING")
    }
    var operationsArray: ListBuffer[String] = new ListBuffer[String]
    operationsArray += ("multiply divide")
    operationsArray += ("plus minus")
    //var expression = (node.nodeChildren).clone()
    var expression:ArrayBuffer[String] = new ArrayBuffer[String]
    for(child <- node.nodeChildren){
      expression+= child.identification
    }
    while (expression.length > 1) {
      var pos: Int = 0
      var curOpSet: Set[String] = operationsArray.remove(0).split(" ").toSet
      while (pos < expression.length) {
        var indexElement = expression(pos)
        if (curOpSet contains indexElement) {
          var a = getIntFromVar(expression(pos - 1), funcObject).get
          var b = getIntFromVar(expression(pos + 1), funcObject).get
          indexElement match {
            case "plus" => {
              expression(pos) = a + b + ""
            }
            case "minus" => {
              expression(pos) = a - b + ""
            }
            case "multiply" => {
              expression(pos) = a * b + ""
            }
            case "divide" => {
              expression(pos) = a / b + ""
            }
            case _ => throw new Exception("invalid operation")
          }
          expression.remove(pos + 1)
          expression.remove(pos - 1)
          pos -= 1
        }
        pos += 1
      }
    }
    // is this the problem?
    return getIntFromVar(expression(0), funcObject).get
  }

  def setvalueBool(node: Node, funcObject: FuncInfo): Boolean = {
    if (node.nodeChildren.size == 0) {
      throw new Exception("YOU TRIED TO SET A VALUE TO NOTHING")
    }
    var operationsArray: ListBuffer[String] = new ListBuffer[String]
    operationsArray += ("multiply divide")
    operationsArray += ("plus minus")
    operationsArray += ("greaterthan")
    //Check for number equality
    operationsArray += ("equals")
    operationsArray += ("and")
    operationsArray += ("or")
    //Check for boolean equality
    operationsArray += ("equals")
    //The first time we want to check for number equality. We'll set this to false after checking equals the first time
    var numericalEqualsFlag: Boolean = true

    var expression:ArrayBuffer[String] = new ArrayBuffer[String]
    for(child <- node.nodeChildren) {
      expression += child.identification
    }
    while (expression.length > 1) {
      var pos: Int = 0
      var curOpSet: Set[String] = operationsArray.remove(0).split(" ").toSet
      while (pos < expression.length) {
        var indexElement = expression(pos)
        if (curOpSet contains indexElement) {
          indexElement match {
            case "plus" => {
              var a = getIntFromVar(expression(pos - 1), funcObject).get
              var b = getIntFromVar(expression(pos + 1), funcObject).get
              expression(pos) = a + b + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "minus" => {
              var a = getIntFromVar(expression(pos - 1), funcObject).get
              var b = getIntFromVar(expression(pos + 1), funcObject).get
              expression(pos) = a - b + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "multiply" => {
              var a = getIntFromVar(expression(pos - 1), funcObject).get
              var b = getIntFromVar(expression(pos + 1), funcObject).get
              expression(pos) = a * b + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "divide" => {
              var a = getIntFromVar(expression(pos - 1), funcObject).get
              var b = getIntFromVar(expression(pos + 1), funcObject).get
              expression(pos) = a / b + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "greaterthan" => {
              var a = getIntFromVar(expression(pos - 1), funcObject).get
              var b = getIntFromVar(expression(pos + 1), funcObject).get
              expression(pos) = (a > b) + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "equals" => {
              //We have numbers on both sides
              if (numericalEqualsFlag) {
                var a = getIntFromVar(expression(pos - 1), funcObject)
                var b = getIntFromVar(expression(pos + 1), funcObject)
                if (!a.nonEmpty && !b.nonEmpty) {
                  expression(pos) = (a.get == b.get) + ""
                  expression.remove(pos + 1)
                  expression.remove(pos - 1)
                  pos -= 1
                }
              }
              else {
                var a = getBoolFromVar(expression(pos - 1), funcObject)
                var b = getBoolFromVar(expression(pos + 1), funcObject)
                if (!a.nonEmpty && !b.nonEmpty) {
                  expression(pos) = (a.get == b.get) + ""
                  expression.remove(pos + 1)
                  expression.remove(pos - 1)
                  pos -= 1
                }
              }
            }
            case "and" => {
              var a = getBoolFromVar(expression(pos - 1), funcObject).get
              var b = getBoolFromVar(expression(pos + 1), funcObject).get
              expression(pos) = (a && b) + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case "or" => {
              var a = getBoolFromVar(expression(pos - 1), funcObject).get
              var b = getBoolFromVar(expression(pos + 1), funcObject).get
              expression(pos) = (a || b) + ""
              expression.remove(pos + 1)
              expression.remove(pos - 1)
              pos -= 1
            }
            case _ => throw new Exception("invalid operation")
          }
          //After we hit equality check the first time, set the flag to false
          if (curOpSet.contains("equals")) {
            numericalEqualsFlag = false
          }
        }
        pos += 1
      }
    }
    return getBoolFromVar(expression(0), funcObject).get
  }

  def getIntFromVar(variable: String, funcObject: FuncInfo): Option[Int] = {
    try {
      //Check function ints
      if (funcObject.function_int.contains(variable)) {
        return Option(funcObject.function_int(variable))
      }
      //Check program ints
      else if (program_int.contains(variable)) {
        return Option(program_int(variable))
      }
      //case for ints and booleans and strings
      else {
        return Option(variable.toInt)
      }
    }
    catch {
      case NonFatal(t) => return None
    }
    return None
  }

  def getBoolFromVar(variable: String, funcObject: FuncInfo): Option[Boolean] = {
    try {
      //Check function ints
      if (funcObject.function_bool.contains(variable)) {
        return Option(funcObject.function_bool(variable))
      }
      //Check program ints
      else if (program_bool.contains(variable)) {
        return Option(program_bool(variable))
      }
      //case for ints and booleans and strings
      else {
        return Option(variable.toBoolean)
      }
    }
    catch {
      case NonFatal(t) => return None
    }
    return None
  }

  def isBoolean(string: String): Boolean = {
    return string.equals("true") || string.equals("false")
  }

  def isInt(string: String): Boolean = {
    return string.charAt(0).isDigit || string.charAt(0) == '-'
  }

  def isOp(string: String): Boolean = {
    return string.equals("plus") || string.equals("minus") || string.equals("multiply") || string.equals("divide")
  }

  def setIntHelper(variable: String, num: Int, funcObject: FuncInfo): Unit = {
    //If we are inside a function and the function contains the variable we are referencing
    if (funcObject.function_int contains variable) {
      funcObject.function_int(variable) = num
    }
    //If the global scope contains the variable we are referencing
    else if (program_int contains variable) {
      program_int(variable) = num // Might be an error because reassigning a variable.
    }
    //If we are inside a function scope and the function contains the variable
    else if (!funcObject.name.equals("")) {
      funcObject.function_int += (variable -> num)
    }
    //This means that no variable has been created previously and we are in the global scope
    else {
      program_int += (variable -> num)
    }
  }

  def setBooleanHelper(variable: String, bool: Boolean, funcObject: FuncInfo): Unit = {
    //If we are inside a function and the function contains the variable we are referencing
    if (funcObject.function_bool contains variable) {
      funcObject.function_bool(variable) = bool
    }
    //If the global scope contains the variable we are referencing
    else if (program_bool contains variable) {
      program_bool(variable) = bool // Might be an error because reassigning a variable.
    }
    //If we are inside a function scope and the function contains the variable
    else if (!funcObject.name.equals("")) {
      funcObject.function_bool += (variable -> bool)
    }
    //This means that no variable has been created previously and we are in the global scope
    else {
      program_bool += (variable -> bool)
    }
  }
}

object evaluate_object extends Evaluate