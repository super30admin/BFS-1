


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
        if not(root):
            return res
        q= [root]
        #temp_lst = [] #if we declare here for each level we have to empty this
        while q:
            #print("....")
            temp_lst = [] #for each level we are creating a new list, that is for the current list
            size = len(q)
            for i in range(size): #as length of queue changes for every iteration, we do not use length here directly
                #print("..----..")
                curr = q.pop(0) #pop first element in queue
                temp_lst.append(curr.val)
                if curr.left:
                    #print("..kkkk..")
                    q.append(curr.left)
                if curr.right:
                    #print("..klklk..")
                    q.append(curr.right)
            res.append(temp_lst)
        return res



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