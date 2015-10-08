package com.grobster.work

import java.nio.file._
	
	class Renamer(val p: Path) {
		val fileEndings = List(".jpg", ".jpeg", ".png", ".bmp")
		
		def isValidGid(s: String): Boolean = { s.length == 8 && s(0) == 'Z' }
		
		def findGid(sl: List[String]): String = sl match {
			case Nil => ""
			case x :: ys if(isValidGid(x)) => x
			case x :: ys if(!isValidGid(x)) => findGid(ys)
		}
		
		def newPath(p: Path): Renamer = new Renamer(p)
	}