package com.example.assign5


class ArnoldC {
  def main(args: Array[String]) {
    println("Hello World!!!")
  }

  object ITS {
  }

  object TALK {
    def apply(to: To ): To = {
      return to
    }
  }

  class To
  object TO extends To{
    def apply(the: The ): The = {
      return the
    }
  }

  class The
  object THE extends The {
    def apply(hand: Hand ): Hand = {
      hand
    }
  }

  class Hand
   object HAND extends Hand{
     def apply(text: String): Unit = {
       println(text)
     }
   }
}
