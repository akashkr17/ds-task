package edu.knoldus


import edu.knoldus.tree.{NAryTreeCount, Tree}
import org.scalatest.funsuite.AnyFunSuite

class NAryTreeSpec extends AnyFunSuite {

	val tree = new NAryTreeCount()
	val firstTree: Tree = Tree(1, Some(List(Tree(2, Some(List(Tree(5, None), Tree(6, None), Tree(7, None)))), Tree(3, Some(List(Tree(8, None)))),
		Tree(4, Some(List(Tree(9, None), Tree(10, None), Tree(11, None)))))))

	test("Total number of nodes in nary tree should be 11 in firstTree") {
		assert(tree.countNodes(firstTree) == 11)
	}

	test("Number of nodes having more than 2 children should be 3 in firstTree ") {
		assert(tree.countNodes2(firstTree) ==3)
	}


	val SecondTree: Tree = Tree(1, Some(List(Tree(2, Some(List(Tree(5, None), Tree(6, None), Tree(7, None)))),
		Tree(4, Some(List(Tree(9, None), Tree(10, None)))))))

	test("Total number of nodes in nary tree should be 8 in firstTree") {
		assert(tree.countNodes(SecondTree) == 8)
	}

	test("Number of nodes having more than 2 children should be 1 in firstTree ") {
		assert(tree.countNodes2(SecondTree) ==1)
	}


}

