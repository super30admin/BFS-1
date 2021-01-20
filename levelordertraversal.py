# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        '''
        BFS based solution
        Complexity:
        Time: O(n)
        Space: O(n/2)
        '''
        if(root==None):
            return
        x = [[root]]
        res = [[root.val]]
        while(len(x)>0):
            arr = x.pop()
            r = []
            for i in arr:
                if(i.left!=None):
                    r.append(i.left)
                if(i.right!=None):
                    r.append(i.right)
            if(len(r)>0):
                res.append([i.val for i in r])
                x.append(r)
        
        return res
        
