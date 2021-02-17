'''
Time complexity: O(n)
Space complexity: O(diameter)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        output = [] # not considered for space complexity since array is expected in question
        if root is None:
            return output
        
        queue = deque() # considered for space complexity
        queue.append(root)
        
        while queue:
            size = len(queue)
            temp = []
            for x in range(0, size):
                front = queue.popleft()
                temp.append(front.val)
                
                if front.left:
                    queue.append(front.left)
                    
                if front.right:
                    queue.append(front.right)
            output.append(temp)
            
        return output