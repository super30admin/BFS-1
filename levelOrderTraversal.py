# TC: O(n)
# SC: O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        q=deque()
        if not root:
            return []
        q.append(root)


        while q:
            size=len(q)
            level=[]
            for i in range(size):
                curr=q.popleft()
                level.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            result.append(level)

        return result
