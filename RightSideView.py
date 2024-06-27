#Time Complexity:O(n)
#Space Complexity:O(n)
#use bfs and we add the last element to result list of each level 
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result=[]
        q=[]
        if not root:
            return result
        q.append(root)
        while q:
            s=len(q)
            for i in range(s):
                curr=q.pop(0)
                temp=curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(temp) 
        return result