#// Time Complexity : O(n) 
# // Space Complexity : O(1)in dfs if not considering stack space o(h) in BFS   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : storing the result in list of list in DFS was a bot tricky


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return None
        # dicti = defaultdict(list)
        result = []
        def dfs(root,level):
            if root == None:
                return 
            if len(result) == level:
                result.append([])
            
            result[level].append(root.val)
            # dicti[level].append(root.val)

            if root.left:
                dfs(root.left,level+1)
            if root.right:
                dfs(root.right,level+1)
        dfs(root,0)
        # return dicti.values()
        return result
        
        #BFS
        # queue = deque()
        # queue.append(root)
        # result = []
        # while queue:
        #     size = len(queue)
        #     temp = []
        #     for i in range(size):
        #         abc = queue.popleft()
        #         temp.append(abc.val)
        #         if abc.left:
        #             queue.append(abc.left)
        #         if abc.right:
        #             queue.append(abc.right)
        #     result.append(temp)

        # return result


       
# Approach:
# 1. DFS
#  we will maintain the level at each node and we will store the result in a list of list and go on appending the node at that level to the ith position in the list.