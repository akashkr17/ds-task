package edu.knoldus.tree


import scala.annotation.tailrec

object BinaryTree {

	abstract class IntTree
	case object EmptyTree extends IntTree
	case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

	@tailrec
	def contains(tree: IntTree, value: Int): Boolean = {
		tree match {
			case EmptyTree                      => false
			case Node(e, left, _) if e < value  => contains(left, value)
			case Node(e, _, right) if e > value => contains(right, value)
			case _                              => true
		}
	}

	def insert(tree: IntTree, value: Int): IntTree = {
		tree match {
			case EmptyTree => Node(value, EmptyTree, EmptyTree)
			case Node(element, left, right) if (element < value) =>
				Node(element, insert(left, value), right)
			case Node(element, left, right) if (element > value) =>
				Node(element, left, insert(right, value))
			case _ => tree
		}
	}

	def inorder(binaryTree: IntTree): List[Any] = {
		binaryTree match {
			case Node(data, leftChild, rightChild) => List(inorder(leftChild), data, inorder(rightChild))
			case Node(data, leftChild, _) => List(inorder(leftChild), data)
			case Node(data, _, rightChild) => List(data, inorder(rightChild))
			case Node(data, _, _) => List(data)
			case EmptyTree => Nil
		}
	}

	def preorder(binaryTree: IntTree): List[Any] = {
		binaryTree match {
			case Node(data, leftChild,rightChild) => List(data, preorder(leftChild), preorder(rightChild))
			case Node(data, leftChild, _) => List(data, preorder(leftChild))
			case Node(data, _,rightChild) => List(data, preorder(rightChild))
			case Node(data, _, _) => List(data)
			case EmptyTree => Nil
 		}
	}

	def postOrder(binaryTree: IntTree): List[Any] = {
		binaryTree match {
			case Node(data, leftChild, rightChild) => List(postOrder(leftChild), postOrder(rightChild), data)
			case Node(data, leftChild, _) => List(postOrder(leftChild), data)
			case Node(data, _, rightChild) => List(postOrder(rightChild), data)
			case Node(data, _, _) => List(data)
			case EmptyTree => Nil
		}
	}
}


object BinaryTreeMain extends App {

	val t: BinaryTree.type = BinaryTree
	val tree: BinaryTree.Node = t.Node(8, t.Node(5, t.Node(7, t.EmptyTree, t.EmptyTree),
		t.EmptyTree), t.Node(7, t.EmptyTree, t.Node(2, t.EmptyTree, t.EmptyTree)))

	println(t.inorder(tree))
	println(t.preorder(tree))
	println(t.postOrder(tree))

}

