"""
Problem:
https://leetcode.com/problems/binary-tree-level-order-traversal/

Approach: BFS Solution

1. Maintain a queue
2. push nodes at each level to the queue
3. pop nodes from each level from the queue and add to a list and append the list to a global list

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    que = None
    res = None
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return self.res
        self.res = []
        self.que = deque()
        self.que.append(root)
        while(self.que):
            qsize = len(self.que)
            count = 0
            temp = []
            while(count<qsize):
                popped = self.que.popleft()
                temp.append(popped.val)
                count+=1
                if (popped.left!=None):
                    self.que.append(popped.left) 
                if (popped.right!=None):
                    self.que.append(popped.right)
            self.res.append(temp)
        return self.res


"""
Problem:
https://leetcode.com/problems/binary-tree-level-order-traversal/

Approach: DFS Solution

1. For each node in the tree, store the level information of the node in the recursive stack
2. Maintain a global array, if we hit a node at a perticular level in the recursion and the level is equal to the size of the list then we make a new sub list and add the node to that sub list and append the sub list to global list
3. if the length of the global list is greater that than current level, take the sub list at current level and append the root.val to that sublist

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(H) where H is the  height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    res = None
    
    def dfs(self,root,level):
        if root==None:
            return
        
        if level==len(self.res):
            self.res.append([])
        
        self.res[level].append(root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        
        
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.res = []
        if root == None:
            return self.res
        self.dfs(root,0)
        return self.res
