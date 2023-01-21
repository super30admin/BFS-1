# Time Complexity : O(N)
# Space Complexity : O{N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Create a queue and push the root .Also create a list called res to push all the nodes
#while the queue is not empty ,iterate over the nodes in the level and push the children in the queue
#Append the result of every level in the res list


from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = deque()
        q.append(root)
        res = []
        while len(q):
            lev = []
            for i in range(len(q)):
                el = q.popleft()
                lev.append(el.val)
                if el.left:
                    q.append(el.left)
                if el.right:
                    q.append(el.right)
            res.append(lev)      
        return res