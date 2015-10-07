package com.grobster.util

class ListHelper {
	def findLowest(n: List[Int]): Int = {
		var lowest = Integer.MAX_VALUE
		for(x <- n) { if(x < lowest) lowest = x }
		lowest
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
	
}