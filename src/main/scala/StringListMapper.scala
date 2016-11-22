/**
  * Created by lyee on 11/20/16.
  */
package com.example.assign5
import scala.collection.mutable.{ArrayBuffer, HashMap}

class StringListMapper {

  val allSayings = Map[String, String](
    "I LIED" -> "false",
    "NO PROBLEMO" -> "true",
    "BECAUSE IM GOING TO SAY PLEASE" -> "if",
    "BULLSHIT" -> "else",
    "YOU HAVE NO RESPECT FOR LOGIC" -> "endif",
    "STICK AROUND" -> "while",
    "CHILL" -> "endwhile",
    "GET UP" -> "plus",
    "GET DOWN" -> "minus",
    "YOURE FIRED" -> "multiply",
    "HE HAD TO SPLIT" -> "divide",
    "I LET HIM GO" -> "mod",
    "YOU ARE NOT YOU YOU ARE ME" -> "equals",
    "LET OFF SOME STEAM BENNET" -> "greaterthan",
    "CONSIDER THAT A DIVORCE" -> "or",
    "KNOCK KNOCK" -> "and",
    "LISTEN TO ME VERY CAREFULLY" -> "declaremethod",
    "GIVE THESE PEOPLE AIR" -> "nonvoidmethod",
    "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE" -> "methodargs",
    "ILL BE BACH" -> "return",
    "HASTA LA VISTA BABY" -> "endmethod",
    "DO IT NOW" -> "callmethod",
    "GET YOUR ASS TO MARS" -> "assignvariablefrommethodcall",
    "HEY CHRISTMAS TREE" -> "declareint",
    "YOU SET US UP" -> "setinitialvalue",
    "ITS SHOWTIME" -> "beginmain",
    "YOU HAVE BEEN TERMINATED" -> "endmain",
    "TALK TO THE HAND" -> "print",
    "GET TO THE CHOPPER" -> "assignvariable",
    "HERE IS MY INVITATION" -> "setvalue",
    "ENOUGH TALK" -> "endassignvariable"
  )

  //TODO: Catch future variable names and numbers through some identifier. Ask Larry.
  def getSequence(string: String) : ArrayBuffer[String] = {
    var stringCopy = string
    var list = ArrayBuffer[String]()
    var characterDetected:Boolean = true
    while(stringCopy.length > 0 && characterDetected) {
      characterDetected = false
      //Check quotations
      if(stringCopy.charAt(0) == '"') {
        var stringBuilder = new StringBuilder
        if(stringCopy.length == 0) {
          throw new Exception("your code is shit")
        }
        stringCopy = stringCopy.substring(1)
        var pos:Int = stringCopy.indexOf('"')
        if(pos == -1) {
          throw new Exception("your code is shit")
        }
        stringBuilder += ('"')
        stringBuilder ++= (stringCopy.substring(0,pos+1))
        stringCopy = stringCopy.substring(pos+1).trim
        list.+=(stringBuilder.toString)
        characterDetected = true
      }
      else {
        //Check numbers
        if(stringCopy.charAt(0).isDigit) {
          var pos = 0
          var stringBuilder = new StringBuilder
          while(pos < stringCopy.length && stringCopy.charAt(pos).isDigit) {
            stringBuilder += stringCopy.charAt(pos)
            pos +=1
          }
          if(pos == stringCopy.length) {
            stringCopy = stringCopy.substring(pos).trim
          }
          else {
            stringCopy = stringCopy.substring(pos+1).trim
          }
          list.+=(stringBuilder.toString)
          characterDetected = true
        }
        //check all sayings
        for(saying <- allSayings.keys){
          var currSayingLength = saying.length
          if(stringCopy.length >= saying.length) {
            if(stringCopy.substring(0, saying.length).equals(saying)) {
              //If we found a matching substring
              stringCopy = stringCopy.substring(saying.length).trim
              list.+=((allSayings.get(saying)).get)
              characterDetected = true
            }
          }
        }
      }
    }
    return list
  }

  def isDigit(char: Char):Boolean = {
    return (char + "").forall(_.isDigit) || (char == '.')
  }
}
object StringListInstance extends StringListMapper



