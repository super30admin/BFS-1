def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    self.result=[]
    if root is None: 
        return self.result
    self.helper(root,0)
    return self.result
def helper(self,root,level):
    if root is None:
        return
    
    if len(self.result)==level:
        self.result.append([])
    self.helper(root.left,level+1)
    self.result[level].append(root.val)
    self.helper(root.right,level+1)

    