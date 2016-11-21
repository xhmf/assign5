package arnold

import com.example.assign5._
import org.scalatest.FunSpec

class ArnoldCSpec extends FunSpec {
  describe("Adding 1 to 1") {
    it("should equals 2"){
      assert(1+1 == 2)
    }
  }

  describe("should run fine")
  {
    object DoesItCompile extends ArnoldC {
      def run(): Unit = {
        ITS SHOWTIME
          TALK TO THE HAND "hello world"
        YOU HAVE BEEN TERMINATED
      }
    }
    DoesItCompile.run()
  }

  describe("should run fine")
  {
    object Asdfasdf extends StringList {
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
    object Asdfasdf extends StringList {
      def run(): Unit = {
        var list = StringListInstance.getSequence("TALK TO THE HAND \"potato asdf\" ITS SHOWTIME")
        for(i <- list) {
          println(i)
        }
      }
    }
    Asdfasdf.run()
  }

  //TODO: debug
  describe("should run fine")
  {
    object Asdfasdf extends StringList {
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

