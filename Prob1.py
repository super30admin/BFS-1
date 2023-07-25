# Time complexity : O(n), number of nodes
# Space complexity : O(n), number of nodes
# In DFS, Use a local level variable to keep track of level and as index in the list of list - levels. 
# Iterate in DFS manner, and append root.val at correct levels[level] place. 
# Also, if len(levels) and current level, then this level hasn't been visited before, so append an empty list.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #Method 1 - BFS - Maintain a queue to traverse one level at a time. Keep appending all the children to get to next level
        # TC - O(n) and, SC - O(n)

        # if not root: return []
        # q=deque()
        # q.append(root)
        # res=[]

        # while q:
        #     temp=[]
        #     size=len(q)

        #     for _ in range(size):
        #         cur=q.popleft()
        #         temp.append(cur.val) #preorder traversal
        #         if cur.left:
        #             q.append(cur.left)
        #         if cur.right:
        #             q.append(cur.right)
        #     res.append(temp)
        # return res
    
    #Method 2 - DFS
        if not root: return []
        levels=[]
        def dfs(root,level):
            if len(levels)==level:
                levels.append([])
            levels[level].append(root.val) #here, inorder is done, but order doesn't matter
            if root.left:
                dfs(root.left,level+1)
            if root.right:
                dfs(root.right,level+1)
        dfs(root,0)
        return levels

