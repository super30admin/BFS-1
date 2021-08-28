
class Solution:
    def __init__(self):
        self.result = []

    """
    BFS approach
    TC - O(n)
    SC - O(n)
    """
    def approach1(self, root):
        result = []
        q = []
        q.append(root)

        while len(q) != 0:
            size = len(q)
            li = []
            for i in range(size):
                cur = q.pop(0)
                li.append(cur.val)
                if cur.left != None:
                    q.append(cur.left)
                if cur.right != None:
                    q.append(cur.right)
            result.append(li)
        return result

    """
    DFS approach
    TC - O(n)
    SC - O(h)
    """
    def approach2(self, root: Optional[TreeNode], level: int):
        if root == None:
            return
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)
        self.approach2(root.left, level + 1)
        self.approach2(root.right, level + 1)

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        # return self.approach1(root)
        self.approach2(root, 0)
        return self.result
