class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result=[]
        levels=[]
        if root==None:
            return result
        def helper(node,level):
            if len(levels)==level:
                levels.append([])
            levels[level].append(node.val)
            if node.left:
                helper(node.left,level+1)
            if node.right:
                helper(node.right,level+1)
        helper(root,0)
        for i in levels:
            result.append(i[-1])
        return result
#Time-Complexity:O(N)
#Space-Complexity: O(H)