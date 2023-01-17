# Time Complexity :
# O(N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes


#We create a Queue and start adding elements from the tree. At every iteration, we pop the the first element in the queue, and add it's left and right to the queue
#We also store the level of the node. Then for the popped element, using it's level, we add in the return list accordingly

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.queue = []
        level_order = []
        depth = 0
        if root == None :
            return []

        self.queue.append((root,depth))

        while len(self.queue) != 0:
            queue_elem = self.queue.pop(0)
            depth = queue_elem[1]
            curr_elem = queue_elem[0]
            if curr_elem.left != None :
                self.queue.append((curr_elem.left,depth+1))
            if curr_elem.right != None :
                self.queue.append((curr_elem.right,depth+1))
            if len(level_order) <= depth : 
                level_order.append([curr_elem.val])
            else :
                level_order[depth].append(curr_elem.val)
 
        return level_order
