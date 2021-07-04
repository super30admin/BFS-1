# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #edge case
        if not root:
            return []
        temp = [root]
        sol = []
        #level order traversal
        while temp:
            #append most right in this level
            sol.append(temp[-1].val)
            newtemp = []
            for i in temp:
                if i.left:
                    newtemp.append(i.left)
                if i.right:
                    newtemp.append(i.right)
            temp = newtemp
        return sol