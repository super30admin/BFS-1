# Time Complexity : O(n)
# Space Complexity : O(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach

#recursion
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = {}
        if root is not None:
            levels[1] = [root.val]
            self.traverse(root,levels,2)
        return levels.values()
		
    def traverse(self,node,levels,count):
        temp = []
        if node == None:
            return
        if node.left != None:
            temp.append(node.left.val)
        if node.right != None:
            temp.append(node.right.val)
        if temp:
            levels[count] = levels[count] + temp if count in levels else temp
            count += 1   
        self.traverse(node.left,levels,count)
        self.traverse(node.right,levels,count)