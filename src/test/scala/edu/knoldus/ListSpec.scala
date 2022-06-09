package edu.knoldus

import edu.knoldus.list.{Cons, MyList, Nil}
import org.scalatest.events.TestFailed
import org.scalatest.funsuite.AnyFunSuite

class ListSpec extends AnyFunSuite {

	val list1: Cons[Int] = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

	val list2: MyList[Nothing] = Nil
	val list3: Cons[Int] = Cons(6,Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil))))))

	val list4: Cons[Int] = Cons(1,Nil)

	test("List1 head returns the first element of list1") {
		assert(list1.head == 1)
	}
	test("List1 is not empty") {
		assert(!list1.isEmpty)
	}

	test("List1 tail method gives the remaining list excluding head empty") {
		assert(list1.tail == Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))
	}
	test("List2 is  empty") {
		assert(list2.isEmpty)
	}
	test("Head method on empty list throw Exception") {
		assertThrows[NoSuchElementException](list2.head)
	}
	test("Tail method on empty list throw Exception") {
		assertThrows[NoSuchElementException](list2.tail)
	}

	test("Add method add element 6 to list1 ") {
		assert(list1.add(6) == list3)
	}
	test("Add method add element 1 to empty list ") {
		assert(list2.add(1) == list4)
	}
}
