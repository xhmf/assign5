import com.example.assign5._
import org.scalatest.FunSpec

/**
  * Created by lyee on 11/22/16.
  */
class StringParserTest extends FunSpec {
    describe("should run fine")
    {
      object StringParserTestObject extends StringParser {
        def run(): Unit = {
          val node:Node =
            parseStringIntoAST("ITS SHOWTIME TALK TO THE HAND \'fried rice\' YOU HAVE BEEN TERMINATED")
          PrintNodeObject.printNodeNicely(node, 0)
        }
      }
      StringParserTestObject.run()
    }

    describe("should run fine")
    {
      object StringParserTestObject extends StringParser {
        def run(): Unit = {
          val node:Node =
            parseStringIntoAST("ITS SHOWTIME " +
              "HEY CHRISTMAS TREE \'var\' " +
              "YOU SET US UP I LIED " +
              "GET TO THE CHOPPER \'var\' " +
              "HERE IS MY INVITATION I LIED " +
              "CONSIDER THAT A DIVORCE NO PROBLEMO " +
              "KNOCK KNOCK I LIED " +
              "ENOUGH TALK " +
              "TALK TO THE HAND \'var\' " +
              "YOU HAVE BEEN TERMINATED ")
          PrintNodeObject.printNodeNicely(node, 0)
        }
      }
      StringParserTestObject.run()
    }

  describe("should run fine")
  {
    object StringParserTestObject extends StringParser {
      def run(): Unit = {
        val node:Node =
          parseStringIntoAST("LISTEN TO ME VERY CAREFULLY \'notakeyword\'" +
           "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE \'arg1\'" +
            "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE \'arg2\'" +
            "GIVE THESE PEOPLE AIR" +
            "HASTA LA VISTA BABY" + "ITS SHOWTIME"+
            "GET YOUR ASS TO MARS \'result1\'" +
            "DO IT NOW \'notakeyword\' \'9\' \'4\'" +
            "YOU HAVE BEEN TERMINATED")
        PrintNodeObject.printNodeNicely(node, 0)
      }
    }
    StringParserTestObject.run()
  }
}


