package com.grobster.util

import scala.annotation.tailrec

class ListHelper {
	def findLowest(n: List[Int]): Int = {
		var lowest = Integer.MAX_VALUE
		for(x <- n) { if(x < lowest) lowest = x }
		lowest
	}
	
	def newLowest(n: List[Int]): Int = {
		@tailrec
		def _lowest(ul: List[Int], lwt: Int): Int = ul match {
			case Nil => lwt
			case x :: ys if(x < lwt) => _lowest(ys, x)
			case x :: ys if(x == lwt) => _lowest(ys, x)
			case x :: ys if(x > lwt) => _lowest(ys, lwt)
		}
		_lowest(n, Integer.MAX_VALUE)
	}
	
	def createRandomNumberList(numOfRanNums: Int, numCeiling: Int): List[Int] = {
		val r = scala.util.Random
		val array = new Array[Int](numOfRanNums)
		var nvar = numOfRanNums
 
		while(nvar > 0) {
			val num = r.nextInt(numCeiling)
			array(nvar - 1) = num
			nvar -= 1
		}
		array.toList
	}
	
	
	
	def sort(li: List[Int]): List[Int] = li match {
		case Nil => Nil
		case x :: ys if(x == findLowest(li)) => x :: sort(ys)
		case x :: ys if(x > findLowest(li)) => sort(ys :+ x)
	}
	
	def newSort(li: List[Int]): List[Int] = {
		@tailrec
		def _sort(ul: List[Int], sl: List[Int]): List[Int] = ul match {
			case Nil => sl
			case x :: ys if(x == newLowest(ul)) => _sort(ys, sl :+ x)
			case x :: ys if(x > newLowest(ul)) => _sort(ys :+ x, sl)
		}
		_sort(li, List())
	}
	
}