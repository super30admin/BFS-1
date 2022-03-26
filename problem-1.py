# Leetcode Execution: YES
# TimeComplexity:O(n)
# Space Complexity:O(n) amortized  
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
            
        result=[]
        # we are using a queue for the dfs. we first put root and loop unitl the queue is not empty 
        # we pop each element and add its left and right to the queue end 
        # we do this unitl there are elements in the queue 
        # every time we pop element we append the value to the nums array
        # and when we come out of the level order traversal we then add the nums to the result array
        q=[]
        q.append(root)
        while len(q)>0:
            count=len(q)
            nums=[]
            while(count>0):
                node=q.pop(0)
                if node!=None:
                    nums.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
                count-=1
            if nums:
                result.append(nums)
        return result