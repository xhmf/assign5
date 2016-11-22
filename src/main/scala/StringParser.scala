/**
  * Created by lyee on 11/20/16.
  */

package com.example.assign5

import scala.collection.mutable.ArrayBuffer

class StringParser {
  var givenList:ArrayBuffer[String] = new ArrayBuffer[String]
  def ParseStringIntoAST(string: String): Node = {
    givenList = StringListInstance.getSequence(string)
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
    if(checkOp.equals(breakCode) || (checkOp.equals("endif") && breakCode.equals("else"))) {
      //Don't remove the breakCode, specifically for the if statement
      return createNode(breakCode)
    }
    //surround with try catch!!
    var currOp:String = givenList.remove(0)
    var node = createNode(currOp)
    node.identification match {
      //All nodes with exactly one child which will NOT continue the AST any further
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
           | "callmethod"
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
        if(currOp.equals("else")) {
            node.nodeChildren += recur("endif")
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
      /*Declare method can have 1-3 params in the following order:
          method name
          [optional] arguments
          [optional] inner AST

          ALSO for now I'm treating methods with a return statement the same as I'd treat a
          void method. The return statement will be at the bottom of the function's AST.
          If we want to push the return statement up to the function level,
          I can easily change that later.
       */
      case "declaremethod" | "nonvoidmethod" => {
        //Add method name
        node.nodeChildren += createNode(givenList.remove(0))
        //If arguments is at the top of the stack
        if(givenList(0).equals("methodargs")) {
          node.nodeChildren += recur("endmethod")
        }
        //If body is at the top of the stack
        if(!givenList(0).equals("endmethod")) {
          node.nodeChildren += recur("endmethod")
        }
        //Now no matter what, endmethod will be at the top of the stack
        givenList.remove(0)
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
      //callmethod has 2 nodes - method name, method param
      //(rest of the tree is included in whatever calls this function)
      case "callmethod" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += createNode(givenList.remove(0))
        return node
      }
      //assignvariablefrommethodcall will have three args - variable name, func call, rest of AST
      //I think this function is unnecessary. We'll see if we can remove this in the future.
      case "assignvariablefrommethodcall" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("should hit callmethod")
        node.nodeChildren += recur(breakCode)
        return node
      }
      //Three nodes - var name, int value (caught by setinitialvalue), rest of ast
      case "declareint" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("should hit setinitialvalue")
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
        return node
      }
      /*This one only has three children. Name of variable to assign,
      the assignment equation (caught by setvalue), and the rest of the tree
     */
      case "assignvariable" => {
        node.nodeChildren += createNode(givenList.remove(0))
        node.nodeChildren += recur("endassignvariable")
        return node
      }
      /*This is the fun one! It has n children but we don't know how many it has until we
        hit the breakCode, aka endassignvariable
       */
      case "setvalue" => {
        //First node is the first variable that we start with
        node.nodeChildren += createNode(givenList.remove(0))
        //This part is essentially a "fold" operation
        currOp = givenList(0)
        //runs until the value of this operation reaches endassignvariable
        while(!currOp.equals("endassignvariable")) {
          //catches any operation, which will then proceed to have one node after it
          node.nodeChildren += recur("endassignvariable")
        }

        //remove the endassignvariable string
        givenList.remove(0)
        return node
      }
      //Uhoh!! Should never reach here!!
      case _ => {
        throw new Exception("YOU MESSED UP SOMEWHERE IN YOUR CODE GO BACK AND CHECK EVERYTHING")
      }
    }
  }
}
