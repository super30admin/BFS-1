# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        """
        Time Complexity: O(n)
        Space Complexity: O(h)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - DFS using a recursive stack
            - passing root and level as a local variable and res as a global variable
            - create a new list in res if a new level is visited
            - the root.val is added to the list at the index no = level in res
            - Any of the pre-order, in-order, post-order approach can be taken
        """      
        self.res = list()
        self.helper(root, 0)
        return self.res

    def helper(self, root, level):
        if root == None:
            return
        if len(self.res) == level:
            self.res.append(list())
        self.res[level].append(root.val)
        self.helper(root.left, level+1)
        self.helper(root.right, level+1)


        # """
        # Time Complexity: O(n)
        # Space Complexity: O(n/2)
        # Did this code successfully run on Leetcode: Yes 

        # Any problem you faced while coding this: No
        # Your code here along with comments explaining your approach:
        # The approach: 
        #     - BFS using iterative solution
        #     - we take queue list and append root to it 
        #     - we add [root.val] to the result initially
        #     - while length of queue > 0
        #         - create a list for every level
        #         - we loop from 0 to len of queue
        #             - we pop the first value of the queue
        #             - and append left and right node value of the queue to the temp list if not None
        #             - we also add left and right node to the stack, so that we can traverse
        #         - after we exit the loop, we add temp list to the res list if len(temp) > 0
        #     - In the end, we return res
            
        # """      

        # if root == None:
        #      return list()
        # st_lst = list()
        # st_lst.append(root)
        # res = [[root.val]]

        # while (len(st_lst) > 0):
        #     temp = list()
        #     for i in range(0, len(st_lst)):
        #         a = st_lst.pop(0)
        #         if a != None and a.left != None:
        #             st_lst.append(a.left)
        #             temp.append(a.left.val)
        #         if a != None and a.right != None:
        #             st_lst.append(a.right)
        #             temp.append(a.right.val)
        #     if len(temp) > 0:
        #         res.append(temp)
        # return res

    #     """
    #     Time Complexity: O(N * H)
    #     Space Complexity: O(H)
    #     Did this code successfully run on Leetcode: Yes 

    #     Any problem you faced while coding this: No
    #     Your code here along with comments explaining your approach:
    #     The approach: 
    #         - First find the height of the tree
    #         - write a function to find the height of each node
    #             - Do post order traversal
    #                 - if root == None then return 0 
    #                 - if left height > right height then consider left height + 1
    #                 - if right height > left height then consider right height + 1
            
    #         - once we find the height of the tree
    #             - we iterate from 1 to height of the tree:
    #                 - we create a temp list and pass it to the function
    #                 - at each iteration, we add the node val to the list
    #             - at each step we keep on adding the temp to the res list
    #     """    
    #     height = self.height(root) # TC: O(N)
    #     res = list() 
    #     for i in range(1, height+1): # TC : O(H)
    #         temp_lst = list()
    #         self.levelTravel(root, i, temp_lst) # TC: O(N)
    #         res.append(temp_lst)
    #     return res

    # def levelTravel(self, node, level, temp):
    #     if node == None:
    #         return
    #     if level == 1:
    #         temp.append(node.val)
    #     else:
    #         left = self.levelTravel(node.left, level-1, temp)
    #         right = self.levelTravel(node.right, level-1, temp)

    # def height(self, node):
    #     if node == None:
    #         return 0
        
    #     l_height = self.height(node.left)
    #     r_height = self.height(node.right)
    #     if l_height > r_height:
    #         return l_height + 1
    #     else:
    #         return r_height + 1