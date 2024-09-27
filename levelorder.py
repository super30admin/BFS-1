# // Time Complexity :O(v+e) 
# // Space Complexity :O(v+e)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result=[]
        self.queue=[]
        self.count=0
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return []
        self.queue.append(root)
        num=0
        while self.queue:
            num=num+1
            size=len(self.queue)
            
            if self.count==len(self.result):
                self.result.append([])
                
                
            for i in range(size):
                node=self.queue.pop(0)
                self.result[self.count].append(node.val)
                if node.left:
                    self.queue.append(node.left)
                if node.right:
                    self.queue.append(node.right)
            self.count=self.count+1
        return self.result