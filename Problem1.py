#Time complexity: O(n)
#Space complexity: O(n)
#Works on leetcode: yes 
#Approach: At each level, we make a new list of values of all the nodes at that level from left to right and then add it to
#the final result. Essentially, I am using BFS here, and at each height h, we add new list for level h. 
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res, queue = [], [root]
        while queue and root:
            
                res.append([node.val for node in queue])
                pair = [(node.left, node.right) for node in queue]
                queue = [n for p in pair for n in p if n]
        return res