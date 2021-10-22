#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        
        que = collections.deque()
        que.append(root)
        
        while que:
            queLen = len(que)
            level =[] # sublist for elements at each level
            
            for i in range(queLen):
                node = que.popleft()
                if node:
                    level.append(node.val)
                    que.append(node.left) #adding children of the node
                    que.append(node.right)
            if level:
                res.append(level)
                
        return res
