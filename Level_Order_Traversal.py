#Time Complexity:O(n)
#Space Complexity:O(n)
#leetcode submission:successful
# We keep a list of list of nodes and then travest from 1 element in the list and keep adding the children of each element of the list

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None: return []
        q=[]
        q.append([root])
        for x in q:
            res=[]
            for i in x:
                if i:
                    
                    if i.left:
                        res.append(i.left)
                    if i.right:
                        res.append(i.right)
            if res:
                q.append(res)
        return [[x.val for x in level] for level in q]