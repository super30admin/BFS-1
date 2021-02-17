#TimeComplexity:O(N) 
#SpaceComplexity: O(max diameter of tree)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return None
        queue=[root] if root else []
        output=[]
        output1=[root.val] 
        while(queue):
            queue1=[]
            output.append(output1)
            output1=[]
            for i in queue:
                if i.left: 
                    queue1.append(i.left)
                    output1.append(i.left.val)
                if i.right: 
                    queue1.append(i.right)
                    output1.append(i.right.val)
            queue=queue1

        return output
            
            
         