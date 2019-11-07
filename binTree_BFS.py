# Definition for a binary tree node.
#Leetcode 102: Success
#Time Com : O(n)

class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution:
    def levelOrder(self, root):
        queue = []
        result = []
        queue.append(root)
        if root == None:
            return None

        while len(queue) != 0:
            #list of elements at the same level
            temp = []
            size = len(queue)
            #run for current entries in queue
            for i in range(size):
                curr = queue.pop(0)
                temp.append(curr.val)
                #push left child to queue
                if curr.left != None:
                    queue.append(curr.left)
                #push right child to queue
                if curr.right != None:
                    queue.append(curr.right)
            result.append(temp)
        return result

obj = Solution()
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)
print(obj.levelOrder(root))
