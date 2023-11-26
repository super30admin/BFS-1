#Method 1: BFS using queues
#Time Complexity : O(n) since we iterate through all the nodes of the tree. n = number of nodes
#Space Complexity : O(n) since in worst case, all the nodes would be added in the queue. n = number of nodes
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use a queue and implement BFS over the binary tree. We add the root to the queue. We take a size variable
# to keep track of number of element in the particular level. This size variable is the size of the queue. We pop a value from
# the quese and append this value into a new list. Then we check the children of this poped value and add it into the queue if 
# present. We do the above steps for size number of times. Once this for loops end, we add the new list created into the result 
# list. 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        result = []
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            li = []
            for i in range(size):
                curr = q.popleft()
                li.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            result.append(li)
        return result

#######################################################################################################################

#Method 2: DFS
#Time Complexity : O(n) since we iterate through all the nodes of the tree. 
#Space Complexity : O(h) where h is the height of the tree. this is the size of the inhood stack for recurssion.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We initialize a result list and height as 0. We implement DFS. If the height and size of the result variable is equal,
# meaning no node is added to the result variable of that height. So we append an empty list to the result. Then we add the root value
# into the result variable at height index. then recursively call the dfs function for left and right root with increasing the height
# by 1. 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, h):
        if root is None: return
        if h == len(self.result):
            self.result.append([])
        self.result[h].append(root.val)
        self.dfs(root.left, h+1)
        self.dfs(root.right, h+1)