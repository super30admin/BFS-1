


#O(1) - space
#O(n) time
#passed in leet code
#logic is that at each level we have the numbe rof elements added and accordingly add the next elements in the list - BFS approach
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def levelOrder(self, root):
        res = []
        if not root:
            return res
        q= deque([root])
        #temp_lst = [] #if we declare here for each level we have to empty this
        while q:
            temp_lst = [] #for each level we are creating a new list
            size = len(q)
            for i in range(size):
                curr = q.popleft() #popleft in deques folloew fifo
                temp_lst.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)



from collections import deque
class Solution:
    def levelOrder(self, root):
        if not root: return []
        queue, res = deque([root]), []

        while queue:
            cur_level, size = [], len(queue)
            for i in range(size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                cur_level.append(node.val)
            res.append(cur_level)
        return res





#Level ordertraversal with list implementation
def levelOrder(self, root):
    """
    :type root: TreeNode
    :rtype: List[List[int]]
    """
    result = []
    if not root:
        return result

    lst = [root]
    while lst:
        result.append([node.val for node in lst])
        size = len(lst)
        for i in range(size):
            node = lst[i]
            if node.left:
                lst.append(node.left)
            if node.right:
                lst.append(node.right)
        lst = lst[size:]
    return result