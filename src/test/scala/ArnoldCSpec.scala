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
}

