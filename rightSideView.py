# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#BFS Solution
#Time Complexity:O(n)
#Space COmplexity:O(n/2)
# Did it run successfully on Leetcode:Yes
#Algorithm:
# 1. Create a queue using list
# 2. Store the root in the list. 
# 3. Calculate the size of the queue.  
# 4. Now pop the element at 0 from the list to set as current root. 
# 5. If the root has left and right child append them to the list until size becomes 0
# 6. Then we append the current root to result
# class Solution:
#     def rightSideView(self, root: TreeNode) -> List[int]:
#         if not root:
#             return []
#         result=[]
#         q=[root]
       
                
#         while q:
#             size=len(q)
#             last=-1
#             for _ in range(size):
#                 curr=q.pop(0)
#                 last=curr.val
#                 if curr.left is not None:
#                     q.append(curr.left)
#                 if curr.right is not None:
#                     q.append(curr.right)
#             result.append(last)
#         return result
    
    
    
#DFS Solution:
#Time Complexity:O(n)
#Space Complexity:O(h)
# Here I keep going to right and check the size of the result. If it is same then I append my current root value else move further. After I finsh right nodes, I move to ledft child of the root. 
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
         result=[]  
        
         self.helper(root,0,result)
         return result
        
    def helper(self,root,level,result):
        #base
        if not root:
            return []
        #logic
        if level==len(result):
            result.append(root.val)
        self.helper(root.right,level+1,result)
        self.helper(root.left,level+1,result)
        
