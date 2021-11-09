#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res= []
        queue = [root]
        
        while queue:
            qlen = len(queue)
            level =[]
            for _ in range(qlen):
                node  = queue.pop(0)
                if node:
                    level.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if level:
                res.append(level)
        return res