package edu.knoldus.list

import scala.annotation.tailrec

sealed trait MyList[+A] {
	def head: A
	def tail: MyList[A]
	def isEmpty: Boolean
	def add[B >: A](elem : B): MyList[B]
}
case object Nil extends MyList[Nothing] {
	override def head: Nothing = throw new NoSuchElementException

	override def tail: MyList[Nothing] = throw new NoSuchElementException

	override def isEmpty: Boolean = true

	override def add[B >: Nothing](elem: B): MyList[B] = Cons(elem, Nil)
}
case class Cons[+A](listHead: A, listTail: MyList[A]) extends MyList[A] {
	def head: A = listHead

	def tail: MyList[A] = listTail

	override def isEmpty: Boolean = false

	override def add[B >: A](elem: B): MyList[B] = Cons(elem,this)
}

object MainApp extends App {
	val list = Cons(1,Cons(2,Cons(3,Nil)))
	println(list)
	println(list.head)
	println(list.isEmpty)
	println(list.tail)

}


