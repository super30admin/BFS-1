
---------------------------------- Right Side View Recursion ---------------------------------------------
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(N/2) ~ O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and maintain a depth of the node. When ever the depth is greater than the res array
# we will append the elements into res. As we are printing the right side view we will iterate through the right first and then we will go to the left view as only right elements will get inserted into res list

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        res = []
        def dfs(root, depth):
            if depth>len(res):
                res.append(root.val)
        
            if root.right:
                dfs(root.right, depth+1)
            if root.left:
                dfs(root.left, depth+1)
        
        dfs(root, 1)
        return res
        
        
---------------------------------- Right Side View Iterative---------------------------------------------
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(N/2) ~ O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and maintain a depth of the node to append to queue. When ever the depth is greater than the res array
# we will append the elements into res. As we are printing the right side view we will iterate through the right first and then we will go to the left view as only right elements will get inserted into res list
        
        
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        res = []
        queue = collections.deque([(root, 1)])
        
        while queue:
            curr, level = queue.popleft()
            if level >len(res):
                res.append(curr.val)
            
            if curr.right:
                queue.append((curr.right, level+1))
            if curr.left:
                queue.append((curr.left, level+1))
            
        return res