#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. number of nodes added to the queue at each level
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=UWwsFlt_xuo&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #BFS solution
        #defining an arraylist for retruning result
        result =[]
        #if there is no element then return result
        if root == None:
            return result
        #defining the queue for processing level wise
        queue = collections.deque([root])
        #till the queue will not be empty while loop will work
        while queue:
            #for each level taing the number of node present
            size = len(queue)
            #creating subarrays for appending each level values to the result
            levelorder =[]
            #Loop will work for the number of node at each level
            for i in range(size):
                #poping out the first element of the queue
                current = queue.popleft()
                #appending the pop vlaue to the list to be added to the result
                levelorder.append(current.val)
                #fetching the left and the right child of the current node and adding it to the queue
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            #after the iteration of the for loop at each level adding the list to the result
            result.append(levelorder)
        return result
