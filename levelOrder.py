# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#BFS Solution:
#Time Complexity:O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode:Yes
#Difficulties: Since I am using nested for loop while returning result, does this make n=my TC as O(N^2)?? 
#We create a queue where we add our root. 
# Then a temp variable is created where we store the values of node.left and node.right. Onbce we finish dealing with all children of a particular node, we append it to out result. 

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        q=[[root]]
        for level in q:
            record=[]
            for node in level:
                
                if node.left:
                    record.append(node.left)
                if node.right:
                    record.append(node.right)
            if record:
                q.append(record)
        return [[x.val for x in level] for level in q]
    
    
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        q, result = deque(), []
        if root:
            q.append(root)
        while len(q):
            level = []
            for _ in range(len(q)):
                x = q.popleft()
                level.append(x.val)
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            result.append(level)
        return result
        
        
        
