# // Time Complexity : O(V+E)
# // Space Complexity : O(maximum diameter)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        output = []
        
        if not root:
            return output
        # initialise queue with the root 
        queue = [root]
        
        #follow the steps that we did in level order traversal 
        #the difference is that only at the last iteration we must add the node to the output list
        while queue:
            size = len(queue)
            for x in range(size):
                front = queue.pop(0)
                
                if x == size-1 : 
                    output.append(front.val)
                if front.left is not None:
                    queue.append(front.left)
                if front.right is not None:
                    queue.append(front.right)
        
        return output
        