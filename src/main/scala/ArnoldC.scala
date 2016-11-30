package com.example.assign5

import scala.collection.mutable.ArrayBuffer


class ArnoldC {
  var text: String = ""

  def getText(): String = {
    text
  }

  class Z extends ArnoldKeyword {
    override def addString(param: String): Unit = text += " " + param

    override def getName(): String = this.getClass.getName.split("\\$")(1)

    override def parse(): Unit = {
      println(text)
      object StringParserInstance extends StringParser
      var node: Node = StringParserInstance.parseStringIntoAST(text)
      PrintNodeObject.printNodeNicely(node, 0)
      val func_object = new FuncInfo {
        override var name: String = ""
        override var body: Node = null
        override var variables: ArrayBuffer[String] = new ArrayBuffer[String]
        override var nonvoid: Boolean = true
      }
      evaluate_object.recur(node, func_object)
    };
  }

  object BE extends Z

  object THAT extends Z

  object THATS extends Z

  object BACK extends Z

  object WANT extends Z

  object STEAM extends Z

  object FIRED extends Z

  object PEOPLE extends Z

  object SAY extends Z

  object BUNCH extends Z

  object OFF extends Z

  object CONSIDER extends Z

  object HAD extends Z

  object HAND extends Z

  object GO extends Z

  object THE extends Z

  object CLOTHES extends Z

  object BECAUSE extends Z

  object OF extends Z

  object TREE extends Z

  object BOOTS extends Z

  object STICK extends Z

  object RESPECT extends Z

  object IM extends Z

  object HAVE extends Z

  object SOME extends Z

  object DOWN extends Z

  object GOING extends Z

  object HE extends Z

  object WHAT extends Z

  object FOR extends Z

  object GET extends Z

  object I extends Z

  object DIVORCE extends Z

  object CAREFULLY extends Z

  object ASS extends Z

  object AROUND extends Z

  object LIED extends Z

  object SHOWTIME extends Z

  object KNOCK extends Z

  object BABY extends Z

  object CHRISTMAS extends Z

  object AND extends Z

  object UP extends Z

  object US extends Z

  object NOT extends Z

  object NOW extends Z

  object MY extends Z

  object LISTEN extends Z

  object YOURE extends Z

  object THEM extends Z

  object GIVE extends Z

  object THESE extends Z

  object FUCK extends Z

  object PROBLEMO extends Z

  object MOTORCYCLE extends Z

  object ILL extends Z

  object SET extends Z

  object NO extends Z

  object ASK extends Z

  object TALK extends Z

  object ME extends Z

  object HEY extends Z

  object HERE extends Z

  object HASTA extends Z

  object NEED extends Z

  object BULLSHIT extends Z

  object PLEASE extends Z

  object ANSWERED extends Z

  object WRONG extends Z

  object LET extends Z

  object CHOPPER extends Z

  object MARS extends Z

  object IMMEDIATELY extends Z

  object DO extends Z

  object DID extends Z

  object AIR extends Z

  object BEEN extends Z

  object LOGIC extends Z

  object YOUR extends Z

  object TERMINATED extends Z

  object LA extends Z

  object BENNET extends Z

  object TO extends Z

  object QUESTIONS extends Z

  object HIM extends Z

  object VISTA extends Z

  object A extends Z

  object VERY extends Z

  object ITS extends Z

  object IS extends Z

  object IT extends Z

  object SPLIT extends Z

  object YOU extends Z

  object ENOUGH extends Z

  object ARE extends Z

  object INVITATION extends Z

  object CHILL extends Z

}

object Arnold extends ArnoldC {
  def main(args: Array[String]): Unit = {
    ITS SHOWTIME
      HEY CHRISTMAS_TREE 'loop
      YOU SET US UP NO PROBLEMO
      HEY CHRISTMAS_TREE 'counter
      YOU SET US UP 1
      STICK AROUND 'loop
        TALK TO THE HAND 'counter
        GET TO THE CHOPPER 'counter
          HERE IS MY INVITATION 'counter
          GET UP 1
          ENOUGH TALK
        TALK TO THE HAND "#####################################################################################"
        TALK TO THE HAND 'counter
        GET TO THE CHOPPER 'loop
          HERE IS MY INVITATION 7
          LET OFF SOME STEAM_BENNET 'counter
          ENOUGH TALK
      THATS CHILL
    YOU HAVE BEEN TERMINATED

//    ITS SHOWTIME
//      HEY CHRISTMAS_TREE 'varrr
//      YOU SET US UP 22
//      GET TO THE CHOPPER 'varrr
//      HERE IS MY INVITATION 123
//      GET UP 1
//      ENOUGH TALK
//      GET TO THE CHOPPER 'varrr
//      HERE IS MY INVITATION 'varrr
//      GET UP 1
//      ENOUGH TALK
//    GET TO THE CHOPPER 'varrr
//    HERE IS MY INVITATION 'varrr
//    GET UP 1
//    ENOUGH TALK
//      TALK TO THE HAND 'varrr
//      YOU HAVE BEEN TERMINATED


//          ITS SHOWTIME
//          STICK AROUND
//          I LIED
//          TALK TO THE HAND "POTATO"
//          THATS CHILL
//          TALK TO THE HAND "OUTSIDE OF WHILE LOOP"
//          YOU HAVE BEEN TERMINATED
    //    ITS SHOWTIME
    //      HEY CHRISTMAS_TREE 'isLessThan10
    //      YOU SET US UP NO PROBLEMO
    //      HEY CHRISTMAS_TREE 'n
    //      YOU SET US UP 0
    //      STICK AROUND 'isLessThan10
    //      GET TO THE CHOPPER 'n
    //      HERE IS MY INVITATION 'n
    //      GET UP 1
    //      ENOUGH TALK
    //        TALK TO THE HAND 'n
    //      GET TO THE CHOPPER 'isLessThan10
    //      HERE IS MY INVITATION 10
    //      LET OFF SOME STEAM_BENNET 'n
    //        ENOUGH TALK
    //        CHILL
    //    YOU HAVE BEEN TERMINATED

//    object StringParserInstance extends StringParser
//    var node: Node = StringParserInstance.parseStringIntoAST(
//      "ITS SHOWTIME BECAUSE IM GOING TO SAY PLEASE I LIED TALK TO THE HAND \"true\" BULLSHIT TALK TO THE HAND \"false\" YOU HAVE NO RESPECT FOR LOGIC TALK TO THE HAND \"end\"YOU HAVE BEEN TERMINATED"
//    )
//    PrintNodeObject.printNodeNicely(node, 0)
  }
}
