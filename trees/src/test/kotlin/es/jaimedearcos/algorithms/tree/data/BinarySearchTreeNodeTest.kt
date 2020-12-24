package es.jaimedearcos.algorithms.tree.data

import org.junit.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class BinarySearchTreeNodeTest {

    @Test
    fun testInsert() {

        println("Binary Search Tree insertion Test...")

        // Given :
        val classUnderTest = getBinarySearchTree()

        // When :
        classUnderTest.insert(13)

        // Then:
        val expectedParent = classUnderTest.search(14)
        val insertedNode = classUnderTest.search(13)

        assert(expectedParent!!.left === insertedNode)
    }

    @Test
    fun testContains() {

        println("Binary Search Tree contains Test...")

        // Given:
        val classUnderTest = getBinarySearchTree()

        // When:
        val expected = classUnderTest.contains(14)
        val notExpected = classUnderTest.contains(13)

        // Then:
        assertTrue(expected)
        assertFalse(notExpected)
    }

    @Test
    fun testRemove() {

        println("Binary Search Tree remove Test...")

        // Given:
        val classUnderTest = getBinarySearchTree()

        // When:
        val result = classUnderTest.remove(20)

        // Then:
        assertTrue(result)
        val valueInTree = classUnderTest.contains(20)
        assertFalse(valueInTree)
    }

    private fun getBinarySearchTree() : BinarySearchTreeNode {
        val node10 = BinarySearchTreeNode(22)
        val node9 = BinarySearchTreeNode(14)
        val node8 = BinarySearchTreeNode(20,node9,node10)
        val node7 = BinarySearchTreeNode(9)
        val node6 = BinarySearchTreeNode(1)
        val node5 = BinarySearchTreeNode(8, null, node7)
        val node4 = BinarySearchTreeNode(6, node6)
        val node3 = BinarySearchTreeNode(11, null, node8)
        val node2 = BinarySearchTreeNode(7,node4, node5)

        return BinarySearchTreeNode(10, node2, node3)
    }
}
