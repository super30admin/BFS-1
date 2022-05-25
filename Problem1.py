#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    result = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.helper(root,0)
        return self.result
    
    def helper(self,root,level):
        if root == None:
            return
        
        if level == len(self.result):
            lst = []
            self.result.append(lst)
        self.result[level].append(root.val)
        
        self.helper(root.left,level+1)
        
        self.helper(root.right,level+1)
        
        
        