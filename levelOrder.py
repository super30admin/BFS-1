# T(N) = O(H)
# S(N) = O(1)
class Solution:
    di=[]
    def helper(self,root,level):
        if root==None:
            return
        if len(self.di)==level:
            self.di.append([root.val])
        else:
            self.di[level].append(root.val)
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.di=[]
        self.helper(root,0)
        return self.di
        