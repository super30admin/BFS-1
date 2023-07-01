import queue
# Time Complexity :O(n)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = queue.Queue()
        res = []
        if root is None:
            return root

        q.put(root)
        while not q.empty():
            size = q.qsize()
            level_data = []
            while size > 0:
                data = q.get()
                level_data.append(data.val)
                size -= 1
                if data.left != None:
                    q.put(data.left)
                if data.right != None:
                    q.put(data.right)
            res.append(level_data)
        return res