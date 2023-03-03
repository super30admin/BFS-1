#Time Complexity : O(N), N being nodes in the tree
#Space Complexity : O(N), N being nodes in the tree
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug a little, but mostly okay. 

#Your code here along with comments explaining your approach in three sentences only
'''Using BFS and a queue, add level array into result for each level of BFS.
'''
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root!=None:
            #define queue
            queue = []
            queue.append(root)
            #if queue is not empty, loop through queue and add left and right
            while(len(queue)>0):
                length = len(queue)
                level = []
                for i in range(length):
                    node = queue.pop(0)
                    level.append(node.val)
                    if node.left!=None:
                        queue.append(node.left)
                    if node.right!=None:
                        queue.append(node.right)
                result.append(level)
        return result
