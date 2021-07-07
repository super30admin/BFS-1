#Did it run on leetcode: yes
#Did you faced any problem: No
#Time Complexity: 0(N)
#Space Compelxity: 0(N)
#Algorithm:
#- Do a binary level order traversal and the last element of the queue will be the
#right most element for every level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Leetcode -199
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#BFS
class Solution(object):
    def rightSideView(self, root):
        # edge case
        if not (root):
            return []
        result = [root.val] #in first level right most element is root
        q = [root]
        while q:
            size = len(q)

            for i in range(0, size, 1):
                curr = q.pop(0)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if q:
                result.append(q[len(q) - 1].val) # after each for loop last element appended to queue will be the last element in each level
        return result
#DFS
class Solution(object):
    def rightSideView(self, root):
        result = []
        self.helper(root,result,0)#pass root result and depth
        return result
    def helper(self,root,result,depth):
        #base case
        if not(root):
            return
        if depth == len(result):
            result.append(root.val)
        self.helper(root.right,result,depth+1)
        self.helper(root.left,result,depth+1)

#left side of a tree view
class Solution(object):
    def leftSideView(self, root):
        # edge case
        if not (root):
            return []
        result = []
        q = [root]
        while q:
            size = len(q)
            result.append(q[0].val)

            for i in range(0, size, 1):
                curr = q.pop(0)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result

#by tweaking the tree levelorder problem
class Solution(object):
    def rightSideView(self, root):
        res = []
        if not root:
            return []
        q = [root]
        temp_lst = []  # if we declare here for each level we have to empty this
        while q:
            # #for each level we are creating a new list
            size = len(q)
            temp_lst = []
            for i in range(size):
                curr = q.pop(0)  # popleft in deques folloew fifo
                temp_lst.append(curr.val)
                # temp_lst.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(temp_lst.pop())
        return res





class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []

        if not root:
            return result

        queue = [root]
        while queue:
            result.append(queue[-1].val)
            size = len(queue)
            for i in range(size):
                node = queue[i]
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            queue = queue[size:]
        return result