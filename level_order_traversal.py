# Time complexity: O(n)
# Space complexity: O(n)
# Approach: use breadth first search
# initialise a queue and add the root
# in a loop, check for queue size and create a loop inside this loop of queue's size
# pop element from queue and add this element to a list and check for its left and right children
# if left, right, chiled exists, add them
# append this list to main list of result




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        from queue import Queue
        q = Queue()
        result = []
        list = []
        q.put(root)
        #result.append([root.val])
        #print(result)
        while(not q.empty()):
            size = q.qsize()
            list = []
            for i in range(0, size):
                curr = q.get()
                list.append(curr.val)
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
            result.append(list)
        return result
            

            
            
            
        