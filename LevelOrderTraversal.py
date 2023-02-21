# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#All TC passed on leetcode

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
  
         #Here we follow DFS approach. We pass along with treenode, its level (depth) for each recurssive call. If the level==size of res then new list has to be created to add the cur node value. Else the list of that level already exists, hnece cur node is added to res of its level.
        #time compleixty - O(n)
        #space complexity - O(h) where h height of tree i.e. because max stack size is ht of tree
        self.res = []
        
        def helper(root, level):
            if not root:
                return 
            
            if level==len(self.res):
                self.res.append([])
            self.res[level].append(root.val)

            if root.left:
                helper(root.left, level+1)
            
            if root.right:
                helper(root.right, level+1)

        
        helper(root, 0)
        return self.res


#------------------------------------OR------------------------------------------
        
        #Here we follow BFS approach. We process each level of tree by adding nodes into queue and poping the left node each time. Each level is added to a new list which is appended to res.
        #time compleixty - O(n)
        #space complexity - O(n/2) = O(n) because max size of queue is no. of leaf node which is n/2
        if not root:
            return []

        res = []
        queue = collections.deque()
        queue.append(root)

        while queue:
            res.append([])
            for i in range(len(queue)):
                node = queue.popleft()
                res[-1].append(node.val)

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
        return res

                
        