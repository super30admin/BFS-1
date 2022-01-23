# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None): 
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root):
        
        result = list()
        if root == None:
            return result
        q = deque() # to implement FIFO
        q.append(root)
        print("root-> ",q)
        while q:
            temp = list()
            size = len(q)
            print("Size of Q-> ", size)
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                print("temp list -> ",temp)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            
            result.append(temp)
            print("Result -> ",result)
        
        return result
        
        
        
root = TreeNode(3)

root.left = TreeNode(9)

root.right = TreeNode(20)
root.right.left= TreeNode(15)
root.right.right= TreeNode(7)



sol = Solution()
re = sol.levelOrder(root)

print(re)




        

            
                    
        
        