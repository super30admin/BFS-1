# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #edge case
        if not root:
            return []
        #solution values and pointers arrays
        sol =[]
        temp = [root]
        vals = [root.val]
        #while pointers
        while temp:
            #append values to solution
            sol.append(vals)
            #temps
            newtemp =[]
            newvals =[]
            #traverse all nodes in this level
            for i in temp:
                if i.left:
                    newtemp.append(i.left)
                    newvals.append(i.left.val)
                if i.right:
                    newtemp.append(i.right)
                    newvals.append(i.right.val)
            #put the new level as old level
            temp = newtemp
            vals = newvals
        #return solx
        return sol