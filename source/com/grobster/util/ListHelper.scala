package com.grobster.util

import scala.annotation.tailrec

class ListHelper {

	def findLowest(n: List[Int]): Int = {
		@tailrec
		def _lowest(ul: List[Int], lwt: Int): Int = ul match {
			case Nil => lwt
			case x :: ys if(x < lwt) => _lowest(ys, x)
			case x :: ys if(x == lwt) => _lowest(ys, x)
			case x :: ys if(x > lwt) => _lowest(ys, lwt)
		}
		_lowest(n, Integer.MAX_VALUE)
	}
	
	def createRandomIntList(n: Int, ceiling: Int): List[Int] = {
		val r = scala.util.Random
		@tailrec
		def _create(n: Int, nl: List[Int], ceiling: Int): List[Int] = n match {
			case 0 => nl
			case x if(x > 0) => _create(x - 1, nl :+ r.nextInt(ceiling), ceiling)
		}
		_create(n, List.empty, ceiling)
	}
	
	def sort(li: List[Int]): List[Int] = {
		@tailrec
		def _sort(ul: List[Int], sl: List[Int]): List[Int] = ul match {
			case Nil => sl
			case x :: ys if(x == findLowest(ul)) => _sort(ys, sl :+ x)
			case x :: ys if(x > findLowest(ul)) => _sort(ys :+ x, sl)
		}
		_sort(li, List())
	}
	
	def reverse[A](li: List[A]): List[A] = {
		@tailrec
		def _rev(li: List[A], nl: List[A]): List[A] = li match {
			case Nil => nl
			case x :: ys => _rev(ys, x :: nl)
		}
		_rev(li, List.empty)
	}
	
	def insert[A](li: List[A], v: A, pos: Int): List[A] = {
		@tailrec
		def _insert(li: List[A], nl: List[A], v: A, pos: Int): List[A] = li match {
			case Nil => Nil
			case x :: ys if(li.indexOf(x) < pos) => _insert(ys, nl :+ x, v, pos - 1)
			case x :: ys if(li.indexOf(x) == pos) => nl ::: List(v) ::: List(x) ::: ys
		}
		_insert(li, List.empty, v, pos)
	}	
}