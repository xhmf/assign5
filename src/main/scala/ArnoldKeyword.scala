package com.example.assign5

class ArnoldKeyword {

  /*
   *  When using the DSL use the following substitutions:
   *    YOUR MOTORCYCLE -> YOUR_MOTORCYCLE
   *    ARE ME -> ARE_ME
   *    CHRISTMAS TREE -> CHRISTMAS_TREE
   *    VERY CAREFULLY -> VERY_CAREFULLY
   *    STEAM BENNET -> STEAM_BENNET
   */

  var ended: Boolean = true

  def getName(): String = ""

  def addString(text: String) = {}

  def parse() = {}

  def apply(sym: Symbol): ArnoldKeyword = {
    this.addString(sym.name)
    this
  }

  def apply(): ArnoldKeyword = {
    this.addString(this.getName())
    this
  }

  private def methodToString(name: String): String = {
    name.replace("_", " ")
  }

  def arnoldParam(param: String): ArnoldKeyword = {
    if (this.ended) {
      this.ended = false
      this.addString(this.getName())
    }
    this.addString(methodToString(Thread.currentThread.getStackTrace()(2).getMethodName))
    this.addString(param)
    this
  }

  def otherParam(param: String, surround: String): ArnoldKeyword = {
    if (this.ended) {
      this.ended = false
      this.addString(this.getName())
    }
    this.addString(methodToString(Thread.currentThread.getStackTrace()(3).getMethodName))
    this.addString(surround + param + surround)
    this.ended = true // True because if the param is scalar the "method param" chain ends
    this
  }

  def symbolParam(param: String): ArnoldKeyword = {
    otherParam(param, "'")
  }

  def stringParam(param: String): ArnoldKeyword = {
    otherParam(param, "\"")
  }

  def intParam(param: String): ArnoldKeyword = {
    otherParam(param, "")
  }

  def TERMINATED(): Unit = {
    this.addString("TERMINATED")
    this.parse()
  }

  def BE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def THAT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THAT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def THAT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def THAT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def THATS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THATS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def THATS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def THATS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BACK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BACK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BACK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BACK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def WANT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WANT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def WANT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def WANT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def STEAM_BENNET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def STEAM_BENNET(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def STEAM_BENNET(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def STEAM_BENNET(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def FIRED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FIRED(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def FIRED(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def FIRED(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def PEOPLE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PEOPLE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def PEOPLE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def PEOPLE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def SAY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SAY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def SAY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def SAY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BUNCH(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BUNCH(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BUNCH(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BUNCH(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def OFF(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def OFF(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def OFF(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def OFF(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CONSIDER(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CONSIDER(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CONSIDER(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CONSIDER(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HAD(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAD(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HAD(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HAD(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HAND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAND(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HAND(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HAND(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def GO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GO(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def GO(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def GO(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def THE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def THE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def THE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CLOTHES(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CLOTHES(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CLOTHES(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CLOTHES(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BECAUSE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BECAUSE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BECAUSE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BECAUSE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def OF(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def OF(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def OF(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def OF(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def TREE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TREE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def TREE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def TREE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BOOTS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BOOTS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BOOTS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BOOTS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def STICK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def STICK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def STICK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def STICK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def RESPECT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def RESPECT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def RESPECT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def RESPECT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def IM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IM(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def IM(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def IM(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HAVE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAVE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HAVE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HAVE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def SOME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SOME(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def SOME(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def SOME(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def DOWN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DOWN(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def DOWN(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def DOWN(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def GOING(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GOING(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def GOING(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def GOING(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def WHAT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WHAT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def WHAT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def WHAT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def FOR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FOR(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def FOR(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def FOR(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def GET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GET(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def GET(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def GET(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def I(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def I(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def I(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def I(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def DIVORCE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DIVORCE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def DIVORCE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def DIVORCE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CAREFULLY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CAREFULLY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CAREFULLY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CAREFULLY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ASS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ASS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ASS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ASS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def AROUND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def AROUND(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def AROUND(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def AROUND(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def LIED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LIED(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def LIED(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def LIED(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def SHOWTIME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SHOWTIME(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def SHOWTIME(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def SHOWTIME(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def KNOCK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def KNOCK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def KNOCK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def KNOCK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BABY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BABY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BABY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BABY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CHRISTMAS_TREE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHRISTMAS_TREE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CHRISTMAS_TREE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CHRISTMAS_TREE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def AND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def AND(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def AND(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def AND(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def UP(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def UP(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def UP(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def UP(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def US(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def US(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def US(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def US(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def NOT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NOT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def NOT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def NOT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def NOW(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NOW(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def NOW(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def NOW(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def MY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def MY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def MY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def LISTEN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LISTEN(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def LISTEN(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def LISTEN(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def YOURE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOURE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def YOURE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def YOURE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def THEM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THEM(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def THEM(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def THEM(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def GIVE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GIVE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def GIVE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def GIVE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def THESE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THESE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def THESE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def THESE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def FUCK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FUCK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def FUCK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def FUCK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def PROBLEMO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PROBLEMO(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def PROBLEMO(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def PROBLEMO(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def MOTORCYCLE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MOTORCYCLE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def MOTORCYCLE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def MOTORCYCLE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ILL(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ILL(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ILL(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ILL(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def SET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SET(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def SET(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def SET(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def NO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NO(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def NO(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def NO(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ASK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ASK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ASK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ASK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def TALK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TALK(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def TALK(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def TALK(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ME(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ME(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ME(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HEY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HEY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HEY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HEY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HERE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HERE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HERE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HERE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HASTA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HASTA(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HASTA(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HASTA(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def NEED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NEED(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def NEED(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def NEED(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BULLSHIT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BULLSHIT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BULLSHIT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BULLSHIT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def PLEASE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PLEASE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def PLEASE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def PLEASE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ANSWERED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ANSWERED(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ANSWERED(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ANSWERED(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def WRONG(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WRONG(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def WRONG(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def WRONG(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def LET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LET(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def LET(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def LET(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CHOPPER(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHOPPER(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CHOPPER(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CHOPPER(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def MARS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MARS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def MARS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def MARS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def IMMEDIATELY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IMMEDIATELY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def IMMEDIATELY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def IMMEDIATELY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def DO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DO(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def DO(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def DO(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def DID(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DID(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def DID(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def DID(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def AIR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def AIR(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def AIR(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def AIR(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BEEN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BEEN(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BEEN(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BEEN(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def LOGIC(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LOGIC(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def LOGIC(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def LOGIC(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def YOUR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOUR(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def YOUR(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def YOUR(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def YOUR_MOTORCYCLE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOUR_MOTORCYCLE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def YOUR_MOTORCYCLE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def YOUR_MOTORCYCLE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }


  def LA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LA(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def LA(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def LA(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def BENNET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BENNET(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def BENNET(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def BENNET(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def TO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TO(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def TO(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def TO(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def QUESTIONS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def QUESTIONS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def QUESTIONS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def QUESTIONS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def HIM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HIM(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def HIM(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def HIM(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def VISTA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def VISTA(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def VISTA(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def VISTA(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def A(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def A(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def A(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def A(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def VERY_CARFULLY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def VERY_CAREFULLY(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def VERY_CAREFULLY(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def VERY_CAREFULLY(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ITS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ITS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ITS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ITS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def IS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IS(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def IS(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def IS(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def IT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def IT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def IT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def IT_NOW(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IT_NOW(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def IT_NOW(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def IT_NOW(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def SPLIT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SPLIT(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def SPLIT(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def SPLIT(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def YOU(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOU(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def YOU(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def YOU(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ENOUGH(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ENOUGH(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ENOUGH(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ENOUGH(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ARE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ARE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ARE(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ARE(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def ARE_ME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ARE_ME(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def ARE_ME(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def ARE_ME(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def INVITATION(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def INVITATION(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def INVITATION(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def INVITATION(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def CHILL(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHILL(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def CHILL(param: Int): ArnoldKeyword = {
    this.intParam(param.toString())
  }

  def CHILL(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }
}
