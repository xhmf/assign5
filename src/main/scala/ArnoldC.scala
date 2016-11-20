package com.example.assign5


class ArnoldC {
// IT'S ARNOLDC MOTHAFUCAS
  object ITS {
    // globals
//    def SHOWTIME(start: Any): start.type = {
//      return start
//    }
//    def SHOWTIME {}
    def apply(showtime: Showtime): Unit = {
    }
  }

  class Showtime
  object SHOWTIME extends Showtime

  trait Talk {
    def TO(the: The): The = {
      return the
    }
  }
  object TALK extends Talk

  class The {
    def HAND(): Hand = {
      return HAND
    }
    def HAND(text:String): Unit = {
      println(text)
    }
  }
  object THE extends The

  class Hand
  object HAND extends Hand {
    def apply(text: String): Unit = {
      println(text)
    }
  }
}

object Arnold extends ArnoldC {
  def main(args: Array[String]): Unit = {
    TALK TO THE HAND "Hello world"
  }
}
