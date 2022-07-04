# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        '''Time Complexity:O(nlogn)
        Space Complexity: O(1)'''
        if not root:
            return
        q=deque([root])
        result=[]
        while len(q)!=0:
            size=len(q)
            newlist=[]
            #process the levels
            for i in range(size) :
                curr=q.popleft()
                newlist.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            result.append(newlist)
        return result
