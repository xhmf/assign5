package com.example.assign5

class ArnoldKeyword {
  var ended: Boolean = true

  def getName(): String = ""

  def addString(text: String) = {}

  def apply(sym: Symbol): ArnoldKeyword = {
    this.addString(sym.name)
    this
  }

  def arnoldParam(param: String): ArnoldKeyword = {
    if (this.ended) {
      this.ended = false
      this.addString(this.getName())
    }
    this.addString(Thread.currentThread.getStackTrace()(2).getMethodName)
    this.addString(param)
    this
  }

  def otherParam(param: String, surround: String): ArnoldKeyword = {
    if (this.ended) {
      this.ended = false
      this.addString(this.getName())
    }
    this.addString(Thread.currentThread.getStackTrace()(3).getMethodName)
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

  def BE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THAT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BACK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WANT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def STEAM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FIRED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PEOPLE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SAY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BUNCH(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def OFF(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CONSIDER(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAD(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAND(param: String): ArnoldKeyword = {
    this.stringParam(param)
  }

  def GO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CLOTHES(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BECAUSE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def OF(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BOOTS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def STICK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def RESPECT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HAVE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SOME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DOWN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GOING(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WHAT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FOR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def I(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DIVORCE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CAREFULLY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ASS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def AROUND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LIED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SHOWTIME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def KNOCK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BABY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHRISTMAS_TREE(param: Symbol): ArnoldKeyword = {
    this.symbolParam(param.name)
  }

  def AND(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def UP(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def US(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NOT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NOW(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LISTEN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOURE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THEM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def GIVE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def THESE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def FUCK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PROBLEMO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MOTORCYCLE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ILL(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ASK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TALK(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ME(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HEY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HERE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HASTA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def NEED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BULLSHIT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def PLEASE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ANSWERED(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def WRONG(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHOPPER(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def MARS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IMMEDIATELY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def DID(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def AIR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BEEN(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def LOGIC(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOUR(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TERMINATED(): ArnoldKeyword = {
    this.arnoldParam("")
  }

  def LA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def BENNET(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def TO(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def QUESTIONS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def HIM(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def VISTA(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def A(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def VERY(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ITS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IS(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def IT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def SPLIT(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def YOU(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ENOUGH(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def ARE(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def INVITATION(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }

  def CHILL(param: ArnoldKeyword): ArnoldKeyword = {
    this.arnoldParam(param.getName())
  }


}
