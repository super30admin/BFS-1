#Time Complexity : O(N)
#Space Complexity : O(N)

# Yes it ran on leetcode

import queue


class Solution(object):
    def levelOrder(self, root):
        res = []
        q = queue.Queue()
        if root == None:
            return None

        q.put(root)

        while not q.empty():
            a = []
            size = q.qsize()

            for i in range(size):
                curr = q.get()
                a.append(curr.val)

                if curr.left is not None:
                    q.put(curr.left)
                if curr.right is not None:
                    q.put(curr.right)

            res.append(a)
        return res