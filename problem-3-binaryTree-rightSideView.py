"""
Problem:
https://leetcode.com/problems/binary-tree-right-side-view/

Approach: BFS

1. Maintain a queue
2. push nodes at each level to the queue
3. pop nodes from each level from the queue and add the last node of the level to the global array 

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    result = None
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        que = deque()
        if root==None:
            return self.result
        que.append(root)
        
        while(que):
            size=  len(que)
            for i in range(size):
                cur = que.popleft()
                if(i == size-1):
                    self.result.append(cur.val)
                if(cur.left!=None):
                    que.append(cur.left)
                if(cur.right!=None):
                    que.append(cur.right)
        return self.result

"""
Approach: DFS

1. Maintain global array, and maintain the level information for each node in the recursive stack
2. start recursing in the right side of the root, if  size of the global array equals the level, then append the root.val to the gloabal list
3. recurse on the left side of the tree

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No
class Solution:
    res = None
    
    def dfs(self, root, level):
        if root==None:
            return 
        
        if level==len(self.res):
            self.res.append(root.val)
        
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)
            
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.res = []
        if root==None:
            return self.res
        
        self.dfs(root,0)
        return self.res
        
        
  