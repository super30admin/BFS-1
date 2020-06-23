# Time Complexity : O(n) 
# Space Complexity : O(h) Space | O(n) worst case.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution:
    result = None 
    def levelOrder(self,root):
        self.result = []
        if not root:
            return self.result
        self.dfs(root,0)
        return self.result
    
    # def bfs(self,root):
    #     q = [root]
    #     while q:
    #         size = len(q)
    #         temp = []
    #         for _ in range(size):
    #             node = q.pop(0)
    #             if node.left:
    #                 q.append(node.left)
    #             if node.right:
    #                 q.append(node.right)
    #             temp.append(node.val)
    #         self.result.append(temp)
    #     return self.result
    
    def dfs(self,root,level):
        # edge case 
        if not root:
            return 
        # Logic 
        if len(self.result) == level:
            temp = []
            self.result.append(temp)
        self.result[level].append(root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)

if __name__ == "__main__":
    s = Solution()
    n = Node(3)
    n.left = Node(9)
    n.right = Node(20)
    n.right.left = Node(15)
    n.right.right = Node(7)
    res = s.levelOrder(n)
    print(res)
            
            
