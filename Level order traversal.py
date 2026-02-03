class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root is None:
            return result
        queue=[]
        queue.append(root)

        while queue:
            size=len(queue)
            level=[]
            for i in range(size):
                curr=queue.pop(0)
                level.append(curr.val)

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(level)   
        return result  