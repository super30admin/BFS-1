//In this problem, we need to perform a level order traversal of a binary tree. This means we visit all the nodes at each level of the tree from left to right. 
// We maintain a queue to keep track of the nodes at the current levele. We start by adding the root node to the queue. Then we enter a loop that continues until the queue is empty.
// In each iteration of the loop, we get the no. of nodes in the queue and add them to a level list. For each node we also add its left and right childeren to the queue. 
// Time complexity is O(n) where n is the no. of nodes. Space complexity is O(w) where w is the max no. of nodes at any level. 

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val q : ArrayDeque<TreeNode> = ArrayDeque()
        q.addLast(root)

        while(q.isNotEmpty()) {
            val size = q.size
            val level = mutableListOf<Int>()

            for(i in 0 until size) {
                val node = q.removeFirst()
                level.add(node.`val`)
                node.left?.let {q.addLast(it)}
                node.right?.let {q.addLast(it)}
            }

            result.add(level)
        }

        return result
    }
}