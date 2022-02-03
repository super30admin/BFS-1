#TIme Complexity =O(n)
#Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if(root == None):
            return None
        queue = [root]
        final = []
        while(len(queue)!=0):
            l = len(queue)
            arr = []
            while(l!=0):
                val = queue.pop(0)
                if(val.left!=None):
                    queue.append(val.left)
                if(val.right!=None):
                    queue.append(val.right)
                arr.append(val.val)
                l-=1
            final.append(arr)
        return final
                
        