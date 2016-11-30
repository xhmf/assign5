package com.example.assign5

/**
  * Created by lyee on 11/27/16.
  */
class PrintNodeClass {
  def printNodeNicely(node:Node, depth:Int): Unit = {
    var depthInDashes:String = new String
//    for(i <- 0 to depth) {
//      depthInDashes += "#"
//    }
    print(depth + " ")
    println(depthInDashes + node.identification)
    for(child <- node.nodeChildren) {
      printNodeNicely(child, depth+1)
    }
  }
}
object PrintNodeObject extends PrintNodeClass
