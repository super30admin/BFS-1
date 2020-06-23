   ---------------------Level Order Traversal--------------------------------------   
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(N/2) ~ O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and append them to queue with level 0. I can iterate through entire lista nd append value to temp. I can have a variable with next level, when ever my level changes, I am appending my temp 
#array to resultant list and making temp to empty.


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        
        queue = collections.deque([(root, 0)])
        i = 1
        temp = []
        res = []
        while queue:
            curr, level = queue.popleft()
            
            if level == i:
                res.append(temp)
                i +=1
                temp = []
            
            temp.append(curr.val)
            if curr.left:
                queue.append((curr.left, level+1))
            if curr.right:
                queue.append((curr.right, level+1))
        if temp:
            res.append(temp)
        return res
        
   ---------------------Is Balanced--------------------------------------   
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(1) as we are not using any temp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and and for every iteration we will check the level of the node and if the level of the node is greater than the length of result array, then 
# we can insert a new array into res array and append the next elements into that array.

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        def dfs(root, level):
            if len(res) == level:
                res.append([])
            
            res[level].append(root.val)
            
            if root.left:
                dfs(root.left, level+1)
            
            if root.right:
                dfs(root.right, level+1)
        
        dfs(root, 0)
        return res
        
        