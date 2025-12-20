# Time Complexity : It is O(n) since we are iterating with all the roots.
# Space Complexity : It is O(n) since we are inserting all elements in the result list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result =[]
        if root == None:
            return result
        
        queue = deque()
        queue.append(root)
        
        while queue:
            Level =[]
            queueLen = len(queue)
            for i in range(queueLen):
                rootNode=queue.popleft()            
                if(rootNode!=None): 
                    Level.append(rootNode.val)
                if (rootNode!=None and rootNode.left !=None):
                    queue.append(rootNode.left)
                if (rootNode!=None and rootNode.right !=None):
                    queue.append(rootNode.right)
            result.append(Level)    
        return result   