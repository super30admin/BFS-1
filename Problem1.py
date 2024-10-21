# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root): #T.C->O(N),S.C->O(N/2) BFS
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        result = []
        
        if root == None: return result
        queue = deque()
        queue.append(root)

        while(len(queue) != 0):
            size = len(queue)
            temp_list = []

            for i in range(size):
                curr = queue.popleft()
                temp_list.append(curr.val)

                if(curr.left != None):
                    queue.append(curr.left)
                if(curr.right != None):
                    queue.append(curr.right)
            result.append(temp_list)
            

        return result

#DFS
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = []
    def levelOrder(self, root): #T.C->O(N) , S.C->O(H)
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):

        if root == None: return 

        if len(self.result) == level:
            self.result.append([])
        self.result[level].append(root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        
        