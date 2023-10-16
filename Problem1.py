'''
1. BFS uses a queue to keep the elements to be processed in FIFO order.
2. Level order means that we process the nodes level by level. Root is level 0, its children are level 1, and so on.
3. At the end of each level we will have the elements. Append them to the answer list.

TC: O(N)
SC: O(N) -> diameter of the tree

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if root == None:
            return []
        
        q = Queue()
        ans = []

        q.put(root)
        while not q.empty() :
            size = q.qsize()
            temp = []
            for i in range(size):
                cur = q.get()
                temp.append(cur.val)
                if cur.left:
                    q.put(cur.left)
                if cur.right:
                    q.put(cur.right)
            ans.append(temp)
        return ans