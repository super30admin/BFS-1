# Time Complexity : O(N)  //Where n is the size of the list we are iterating
#  Space Complexity : O(N)  //We are using queue to return result
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # Root is None -> return empty list
        if not root:
            return []
        
        # Initialize level
        curr_level = 0
        
        # Initialize levels list of lists -> O(1)
        level2nodes = defaultdict(list)
        
        # Start bfs at root -> O(N)
        # init queue with root node and level 0
        queue = deque([(root, 0)])
        while queue:
            # pop next element in queue
            node, level = queue.popleft()            

            # add curr node to the corresponding level list
            level2nodes[level].append(node.val)
            
            # order -> bfs(left) than bfs(right) to same level
            if node.left:
                queue.append((node.left, level + 1))
            if node.right:
                queue.append((node.right, level + 1))

        return level2nodes.values()