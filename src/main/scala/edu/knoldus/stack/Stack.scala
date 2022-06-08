package edu.knoldus.stack

class Stack[A] {

	private var itemsList = List[A]()

	def show(): Unit = itemsList.foreach(println)

	def push(elem: A): Unit = itemsList = elem +: itemsList

	def pop(): Option[A] = itemsList match {
		case head :: tail =>
			itemsList = tail
			Some(head)
			case List () => None
	}

	def top: Option[A] = itemsList match {
		case head :: _ => Some(head)
		case List() => None
	}

	def isEmpty: Boolean = itemsList.isEmpty
}

object StackMain extends  App {

	val stringStack  = new Stack[String]

	println(s"Stack is empty ${stringStack.isEmpty}")

  stringStack.push("This")
	stringStack.push("is")
	stringStack.push("a")
	stringStack.push("Stack")

	println(s"Stack is empty ${stringStack.isEmpty}")
	stringStack.show()
	println(stringStack.pop())
	stringStack.show()

	println(stringStack.top)
	stringStack.show()

	val list = List(1,2,3)
	list.reverse


}
