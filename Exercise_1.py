# Time Complexity: O(N) where N is the number of nodes in the tree
# Space Complexity: O(N) for the queue used in BFS
# Were you able to solve the problem on Leetcode?: Yes
# Did you face any challenges while solving the problem? No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        if not root:
            return self.result
        
        # BFS method
        # queue to hold nodes at each level, starting with root node
        q = [root]

        # while there are nodes in the queue, process each level
        while q:
            # get the size of the current level
            size = len(q)
            level_nodes = []
            
            # process each node in the current level based on the size of the queue at the start of the level
            for _ in range(size):
                # pop the node from the front of the queue
                # and add its value to the level nodes list
                # if the node has left or right children, add them to the queue for the next
                # level processing
                curr = q.pop(0)
                level_nodes.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            # after processing all nodes in the current level, add the level nodes list to the result
            self.result.append(level_nodes)

        return self.result

            


