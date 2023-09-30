#BFS
#TC:O(n) SC:O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return root

        mainList=[]
        q=[]
        q.append(root)
        while q!=[]:
            List=[]
            for i in range(len(q)):
                curr = q.pop(0)
                List.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
            mainList.append(List)

        return mainList 

#DFS
#TC:O(N) SC:O(H)
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         if not root:
#             return root
#         self.mainList=[]
#         self.BinaryTree(root,0) 
#         return self.mainList
    
#     def BinaryTree(self, root,level):
#         if not root:
#             return
#         if len(self.mainList)>level:
#             self.mainList[level].append(root.val)
#         else:
#             self.mainList.append([root.val])
#         self.BinaryTree(root.left,level+1)  
#         self.BinaryTree(root.right,level+1)
