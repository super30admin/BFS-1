# Time complexity :O(N) 
# Space complexity :O(N)
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
            if not root:
                return
            queue=[root]
            next_queue=[]
            level=[]
            res=[]
            while queue:
                for root in queue:
                    level.append(root.val)
                    if root.left:
                        next_queue.append(root.left)
                    if root.right:
                        next_queue.append(root.right)
                res.append(level)
                level=[]
                queue=next_queue
                next_queue=[]
            return res