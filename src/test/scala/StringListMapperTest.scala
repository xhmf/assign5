package com.example.assign5

import org.scalatest.FunSpec

class StringListMapperTest extends FunSpec {

  describe("should run fine")
  {
    object Asdfasdf extends StringListMapper {
      def run(): Unit = {
        var list = StringListInstance.getSequence("TALK TO THE HAND ITS SHOWTIME")
        for(i <- list) {
          println(i)
        }
      }
    }
    Asdfasdf.run()
  }

  describe("should run fine")
  {
    object Asdfasdf extends StringListMapper {
      def run(): Unit = {
        var list = StringListInstance.getSequence("TALK TO THE HAND \"potato asdf\" ITS SHOWTIME")
        for(i <- list) {
          println(i)
        }
      }
    }
    Asdfasdf.run()
  }

  describe("should run fine")
  {
    object Asdfasdf extends StringListMapper {
      def run(): Unit = {
        var list = StringListInstance.getSequence("TALK TO THE HAND \"potato asdf\" ITS SHOWTIME 123 GET DOWN 1")
        for(i <- list) {
          println(i)
        }
      }
    }
    Asdfasdf.run()
  }
}
