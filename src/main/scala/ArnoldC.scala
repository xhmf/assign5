package com.example.assign5


class ArnoldC {
  var start: Boolean = false

  class Talk {
    def TO(the: The): The = {
      return the
    }
  }
  object TALK extends Talk

  class The {
//    def HAND(): Hand = {
//      return HAND
//    }
    def HAND(text:String): Unit = {
      println(text)
    }
  }
  object THE extends The

//  class Hand
//  object HAND extends Hand {
//    def apply(text: String): Unit = {
//      println(text)
//    }
//  }


  class Its {
    def SHOWTIME() = {
      start = true
    }
  }
  object ITS extends Its
}

object Arnold extends ArnoldC {
  def main(args: Array[String]): Unit = {
    TALK TO THE HAND "Hello world"
  }
}
