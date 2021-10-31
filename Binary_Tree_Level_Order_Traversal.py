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
        if root is None:
            return []
        self.final = []
        self.return_list = []
        node_list = [(root,0)]
        while len(node_list) != 0:
                
            if node_list[0][1] < len(self.final):
                self.final[node_list[0][1]].append(node_list[0][0].val)
            else:
                self.final.append([node_list[0][0].val])
                
            if node_list[0][0].left is not None:
                node_list.append((node_list[0][0].left,node_list[0][1]+1)) 
            if node_list[0][0].right is not None:
                node_list.append((node_list[0][0].right,node_list[0][1]+1))
            
            node_list.pop(0)
            
    
        return self.final