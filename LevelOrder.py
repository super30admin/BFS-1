#Time complexity : O(n) 
#Space complexity : O(n) 
#Did this code successfully run on Leetcode : Yes

#BFS
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        result =[]
        if root == None:
            return result
        queue = collections.deque([root])
        while queue:
            size = len(queue)
            levelorder =[]
            for i in range(size):
                current = queue.popleft()
                levelorder.append(current.val)
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            result.append(levelorder)
        return result