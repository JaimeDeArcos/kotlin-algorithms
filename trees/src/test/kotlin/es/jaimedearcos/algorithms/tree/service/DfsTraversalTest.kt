package es.jaimedearcos.algorithms.tree.service

import es.jaimedearcos.algorithms.tree.data.BinaryTreeNode
import kotlin.test.assertEquals
import org.junit.Test
import java.util.*
import kotlin.test.assertFalse

class DfsTraversalTest {

    private val classUnderTest = DfsTraversal()
    private val preOderExpectedResult = arrayOf(10,7,6,1,8,9,11,20,14,22)
    private val inOderExpectedResult = arrayOf(1,6,7,8,9,10,11,14,20,22)
    private val postOderExpectedResult = arrayOf(1,6,9,8,7,14,22,20,11,10)

    @Test
    fun testPreOrder() {

        println("PreOrder Traversal Test...")

        // Given :
        val tree = getBinarySearchTree()
        val linkedList = LinkedList<Int>()

        // When :
        classUnderTest.preOrder(tree) { linkedList.add(it.data) }

        // Then:
        println("Expected: ${preOderExpectedResult.asList()}")
        println("Result:   $linkedList")
        assertEquals(linkedList.size, preOderExpectedResult.size)

        val areNotEqual = linkedList.asSequence()
                .zip(preOderExpectedResult.asSequence())
                .map { (fromThis, fromOther) ->  fromThis == fromOther }
                .contains(false)
        assertFalse(areNotEqual)
    }

    @Test
    fun testInOrder() {

        println("InOrder Traversal Test...")

        // Given :
        val tree = getBinarySearchTree()
        val linkedList = LinkedList<Int>()

        // When :
        classUnderTest.inOrder(tree) { linkedList.add(it.data) }

        // Then:
        println("Expected: ${inOderExpectedResult.asList()}")
        println("Result:   $linkedList")
        assertEquals(linkedList.size, inOderExpectedResult.size)

        val areNotEqual = linkedList.asSequence()
                .zip(inOderExpectedResult.asSequence())
                .map { (fromThis, fromOther) ->  fromThis == fromOther }
                .contains(false)
        assertFalse(areNotEqual)
    }

    @Test
    fun testPostOrder() {

        println("PostOrder Traversal Test...")

        // Given :
        val tree = getBinarySearchTree()
        val linkedList = LinkedList<Int>()

        // When :
        classUnderTest.postOrder(tree) { linkedList.add(it.data) }

        // Then:
        println("Expected: ${postOderExpectedResult.asList()}")
        println("Result:   $linkedList")
        assertEquals(linkedList.size, postOderExpectedResult.size)

        val areNotEqual = linkedList.asSequence()
                .zip(postOderExpectedResult.asSequence())
                .map { (fromThis, fromOther) ->  fromThis == fromOther }
                .contains(false)
        assertFalse(areNotEqual)
    }

    private fun getBinarySearchTree() : BinaryTreeNode {
        val node10 = BinaryTreeNode(22)
        val node9 = BinaryTreeNode(14)
        val node8 = BinaryTreeNode(20,node9,node10)
        val node7 = BinaryTreeNode(9)
        val node6 = BinaryTreeNode(1)
        val node5 = BinaryTreeNode(8, null, node7)
        val node4 = BinaryTreeNode(6, node6)
        val node3 = BinaryTreeNode(11, null, node8)
        val node2 = BinaryTreeNode(7,node4, node5)

        return BinaryTreeNode(10, node2, node3)
    }
}
