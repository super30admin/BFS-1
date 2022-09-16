'''
102. Binary Tree Level Order Traversal

APPROACH: Array manipulation
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTIES: A bit, I managed it. 

APPROACH: BFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: A bit, I managed it. Solved after the class

APPROACH: DFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(h)
LEETCODE: Yes
DIFFICULTIES: A bit, I managed it. Solved after the class

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Array manipulation   
        def approach1(root):
            res = []
            if root == None:
                return res
            elif root.left == None and root.right == None:
                return [[root.val]]

            res.append([root])

            i = 0
            n = len(res)
            go_ahead = True

            while go_ahead:
                # temp = []
                for j in range(0, len(res[i])):
                    node = res[i][j]
                    t = None
                    if node.left != None:
                        if len(res) == i + 1:
                            res.append([node.left])
                        else:
                            res[len(res)-1].append(node.left)
                        # temp.append(node.left)

                    if node.right != None:
                        if len(res) == i + 1:
                            res.append([node.right])
                        else:
                            res[len(res)-1].append(node.right)
                        # temp.append(node.right)

                    res[i][j] = node.val
                if len(res) == i+1:
                    go_ahead = False
                i += 1


            return res
        
        # BFS
        def approach2(root):
            res = []
            
            if root == None:
                return res
            elif root.left == None and root.right == None:
                return [[root.val]]
            
            q = deque()
            q.append(root)
            
            while len(q) != 0:
                q_size = len(q)
                tmp = []
                while q_size > 0:
                    node = q.popleft()
                    tmp.append(node.val)
                    if node.left != None:
                        q.append(node.left)
                    if node.right != None:
                        q.append(node.right)
                    q_size-=1
                res.append(tmp)
                    
            return res
        
        # DFS
        def approach3(root):
            global res
            res = []
            if root == None:
                return res
            elif root.left == None and root.right == None:
                return [[root.val]]
            
            def dfs(node, depth):
                global res
                # base
                if node == None:
                    return
                
                # logic
                if depth == len(res):
                    res.append([node.val])
                else:
                    res[depth].append(node.val)
                dfs(node.left, depth+1)
                dfs(node.right, depth+1)
            
            dfs(root, 0)
            return res
            
            
        # return approach1(root)
        # return approach2(root)
        return approach3(root)
    
