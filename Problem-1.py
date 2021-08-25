# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    if not root: return []
    level_order = []
    q = [root]

    # BFS traversal, add each level in the queue
    while q:
        new_q = []
        cur_level = []
    
        # Iterate the nodes from queue and add their children for the next level
        for cur in q:
            cur_level.append(cur.val)
            
            if cur.left: 
                new_q.append(cur.left)
            if cur.right: 
                new_q.append(cur.right)
    
        level_order.append(cur_level)
        q = new_q
    return level_order