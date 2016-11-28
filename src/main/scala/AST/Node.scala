package com.example.assign5

import scala.collection.mutable.ArrayBuffer

/**
  * Created by lyee on 11/20/16.
  */
abstract class Node {

  var identification : String
  var nodeChildren : ArrayBuffer[Node]
}
abstract class False extends Node{
  identification = "false"
}
abstract class True extends Node{
  identification = "true"
}
abstract class If extends Node{
  identification = "if"
}
abstract class Else extends Node{
  identification = "else"
}
abstract class EndIf extends Node{
  identification = "endif"
}
abstract class While extends Node{
  identification = "while"
}
abstract class EndWhile extends Node{
  identification = "endwhile"
}
abstract class Plus extends Node {
  identification = "plus"
}
abstract class Minus extends Node {
  identification = "minus"
}
abstract class Multiply extends Node{
  identification = "multiply"
}
abstract class Divide extends Node{
  identification = "divide"
}
abstract class Mod extends Node{
  identification = "mod"
}
abstract class Equals extends Node{
  identification = "equals"
}
abstract class GreaterThan extends Node{
  identification = "greaterthan"
}
abstract class Or extends Node {
  identification = "or"
}
abstract class And extends Node {
  identification = "and"
}
abstract class DeclareMethod extends Node{
  identification = "declaremethod"
}
abstract class NonVoidMethod extends Node{
  identification = "nonvoidmethod"
}
abstract class MethodArgs extends Node{
  identification = "methodargs"
}
abstract class Return extends Node{
  identification = "return"
}
abstract class EndMethod extends Node{
  identification = "endmethod"
}
abstract class CallMethod extends Node{
  identification = "callmethod"
}
abstract class AssignVariableToMethodCall extends Node{
  identification = "assignvariabletomethodcall"
}
abstract class DeclareInt extends Node{
  identification = "declareint"
}
abstract class BeginName extends Node{
  identification = "beginmain"
}
abstract class EndName extends Node{
  identification = "endmain"
}
abstract class Print extends Node{
  identification = "print"
}
abstract class AssignVariable extends Node{
  identification = "assignvariable"
}
abstract class SetValue extends Node{
  identification = "assignvariable"
}
abstract class EndAssignVariable extends Node {
  identification = "endassignvariable"
}
abstract class Arguments extends Node {
  identification = "arguments"
}