# // Time Complexity :O(n) for each element in tree
# // Space Complexity :O(n/2) for queue process
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : 



from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []                  #  empty tree
        result = [] 

        #bfs uses queues
        q = deque()
        q.append(root)

        while q:                                # queue not empty
            temp = []                   
            size = len(q)                       # changes every level/ doubles for balanced

            for i in range(size):
                curr = q.popleft()              # pop first element
                temp.append(curr.val)           # add value to temp array 

                if curr.left:
                    q.append(curr.left)         # add to queue for next generation
                if curr.right:      
                    q.append(curr.right)        
            result.append(temp)
        return result

