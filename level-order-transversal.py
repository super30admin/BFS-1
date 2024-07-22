#BFS
# Time Complexity O(n)
# Space Complexity O(n)
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return
        result = []
        q = Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            res = []
            for i in range(size):
                ele = q.get()
                res.append(ele.val)
                if ele.left != None:
                    q.put(ele.left)
                if ele.right != None:
                    q.put(ele.right)
            result.append(res)
        return result


