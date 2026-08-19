#Problem 102. BINARY TREE LEVEL ORDER TRAVERSAL
# TIME COMPELXITY: O(N) where N denotes the nodes that are present in a given tree structure
# SPACE COMPLEXITY: O(N) since we will be needing to store the nodes that are coming from these level order traversal 



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result=[]
        q=deque([root])
        while q:
            size=len(q)
            level=[]
            for i in range(size):
                node=q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(level)
        return result

        