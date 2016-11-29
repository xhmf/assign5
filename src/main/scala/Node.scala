package com.example.assign5

import scala.collection.mutable.ArrayBuffer

/**
  * Created by lyee on 11/20/16.
  */
abstract class Node {

  var identification : String
  var nodeChildren : ArrayBuffer[Node]
}