import com.example.assign5.ArnoldC
import org.scalatest.FunSpec

/**
  * Created by lyee on 11/27/16.
  */
class IntegrationTests extends FunSpec {

  describe("can we print") {
    object eval_print extends ArnoldC {
      def run(): Unit = {

        System.out.println("Something should print here")
        ITS SHOWTIME
        TALK TO THE HAND "hello world"
        YOU HAVE BEEN TERMINATED;
        System.out.println("Something should have printed above")
      }
    }
    eval_print.run()

  }


  describe("should run fine") {
    object ExtensiveTestCase extends ArnoldC {
      def run(): Unit = {

        ITS SHOWTIME
          TALK TO THE HAND "hello world"
        TALK TO THE HAND 'myvar
        HEY CHRISTMAS_TREE 'prev
        YOU SET US UP -1
        GET TO THE CHOPPER 'sum
        HERE IS MY INVITATION 'result
        GET UP 'prev
        GET UP 1
        LET OFF SOME STEAM_BENNET 'index
        LISTEN TO ME VERY_CAREFULLY 'fib
        YOU SET US UP I LIED
          HEY CHRISTMAS_TREE 'variablename
        YOU SET US UP 'initialvalue
        GET TO THE CHOPPER 'myvar
        HERE IS MY INVITATION 'firstOperand
        ENOUGH TALK
          HE HAD TO SPLIT 'operand
        GET TO THE CHOPPER 'a
        HERE IS MY INVITATION 4
        GET UP 'b
        YOURE FIRED 2
        ENOUGH TALK
          YOU ARE NOT YOU YOU ARE_ME 'operand
        LET OFF SOME STEAM_BENNET 'operand
        CONSIDER THAT A DIVORCE 'operand
        KNOCK KNOCK 'operand
        BECAUSE IM GOING TO SAY PLEASE 'value
        YOU HAVE NO RESPECT FOR LOGIC
          GET TO THE CHOPPER 'result
        HERE IS MY INVITATION 'a
        LET OFF SOME STEAM_BENNET 'b
        ENOUGH TALK
          BECAUSE IM GOING TO SAY PLEASE 'result
        TALK TO THE HAND "a is greater b"
        YOU HAVE NO RESPECT FOR LOGIC
          LISTEN TO ME VERY_CAREFULLY 'methodName
        I NEED YOUR CLOTHES YOUR BOOTS AND YOUR_MOTORCYCLE 'arg1
        I NEED YOUR CLOTHES YOUR BOOTS AND YOUR_MOTORCYCLE 'arg2
        GIVE THESE PEOPLE AIR
          HASTA LA VISTA BABY
          HEY CHRISTMAS_TREE 'limit
        YOU SET US UP 10
        HEY CHRISTMAS_TREE 'index
        YOU SET US UP 1
        HEY CHRISTMAS_TREE 'squared
        YOU SET US UP 1
        HEY CHRISTMAS_TREE 'loop
        YOU SET US UP NO PROBLEMO
          STICK AROUND 'loop
        GET TO THE CHOPPER 'SQUARED
        HERE IS MY INVITATION 'INDEX
        YOURE FIRED 'INDEX
        ENOUGH TALK
          TALK TO THE HAND 'SQUARED
        GET TO THE CHOPPER 'LOOP
        HERE IS MY INVITATION 'LIMIT
        LET OFF SOME STEAM_BENNET 'INDEX
        ENOUGH TALK
          GET TO THE CHOPPER 'INDEX
        HERE IS MY INVITATION 'INDEX
        GET UP 1
        ENOUGH TALK
          CHILL
        YOU HAVE BEEN TERMINATED



      }
    }
    ExtensiveTestCase.run()

  }

}
