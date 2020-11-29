package es.jaimedearcos.algorithms.tree.data

data class BinaryTreeNode(
        val data:Int,
        val left: BinaryTreeNode? = null,
        val right: BinaryTreeNode? = null
)