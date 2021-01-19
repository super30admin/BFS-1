#Time complexity : O(N) since each node is processed exactly once.
# Space complexity : O(N) to keep the output structure which contains N node values.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


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
       
        #Base case
        if root == None:
            return None
        
        # BSF Approach so using queue
        queue = []
        queue.append(root)
        result = []
        
        # we are storing a node value in temp since we need to add nodes belongings to same level
        temp = [] 
        temp.append(root.val) 
        
        # perform till queue is not empty
        while queue:
            result.append(list(temp))
            
            #it will travel through the length of the queue
            for i in range(len(queue)): 
			
				# pop every first element from the queue
                node = queue.pop(0)
                temp.pop(0)
                
				# append node.left to queue and temp till node.left is not null
                if node.left != None:
                    queue.append(node.left)
                    temp.append(node.left.val)
                  
				# append node.right to queue and temp till node.right is not null
                if node.right != None:
                    queue.append(node.right)
                    temp.append(node.right.val)
        
		#Return result which contains level order of BST
        return result
