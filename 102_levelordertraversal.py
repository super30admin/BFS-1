
# Time complexity - O(n)
# Space Complexity - O(n)

# Ran on Leetcode- yes



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        init_node = [root]
        
        final = []
        
        if root==None:
            return final
        
        self.maxLevel = 0
        
        def helper(root, level, maxLevel):
            
            if root==None:
                return
            
            if level > maxLevel:
                maxLevel = level
                if maxLevel > self.maxLevel:
                    self.maxLevel = maxLevel
            
            left = helper(root.left, maxLevel+1, maxLevel)
            right = helper(root.right, maxLevel+1, maxLevel)
            
        
            if left == None and right==None:
                return
        
        helper(root,1,-1)
        
        while self.maxLevel > 0:
            vis = []
            node_list = []
            for node in init_node:
                
                vis.append(node.val)
                
                left = node.left
                right = node.right
                
                if left!=None:
                    node_list.append(left)
                if right!=None:
                    node_list.append(right)
            
            final.append(vis)
            init_node = node_list
            self.maxLevel -=1
            
        return final
