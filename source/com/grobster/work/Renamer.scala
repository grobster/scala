package com.grobster.work

import java.nio.file._
import scala.annotation.tailrec
	
	class Renamer(val p: Path) {
		val fileEndings = List(".jpg", ".jpeg", ".png", ".bmp")
		
		def isValidGid(s: String): Boolean = { s.length == 8 && s(0) == 'Z' && s(1) == '0' }
		
		def findGid(sl: List[String]): String = sl match {
			case Nil => ""
			case x :: ys if(isValidGid(x)) => x
			case x :: ys if(!isValidGid(x)) => findGid(ys)
		}
		
		def newPath(p: Path): Renamer = new Renamer(p)
		
		
		
		
		def findGid2(ls: List[String]): String = {
			@tailrec
			def _find(ls: List[String]): String = ls match {
				case Nil => "nothing"
				case x :: ys if(isValidGid(x)) => x
				case x :: ys if(!isValidGid(x)) => _find(ys)
				case _ => "not found"
			}
			_find(ls)
		}
	}