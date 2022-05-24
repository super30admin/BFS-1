#Time Complexity O(N)
#Space Complexity O(N)
#It successfully runs on leetcode

#Approach: first starting with parent , we will add all left and right nodes to queue, and before adding,
#we will loop through q size so that we can add all element from one level

from collections import deque
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        q= deque()
        result=[]
        q.append(root)
        
        while q:
            l=[]
            for i in range(len(q)):
                cur=q.popleft()
                l.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            result.append(l)
        return result
            



#Time Complexity O(N)
#Space Complexity O(h)
#It successfully runs on leetcode

#Approach: we will check if we have list at particular level if not we will add new list,
# and for every level we will fill out that nodes
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode], result = None, level = 0) -> List[List[int]]:
        if not root: return []
        if result is None: result =defaultdict(list)
        result[level].append(root.val)
        self.levelOrder(root.left,result,level+1)
        self.levelOrder(root.right,result,level+1)
        return result.values()


class Solution:
    
    def levelOrder(self, root: Optional[TreeNode], result = None, level = 0) -> List[List[int]]:        
        
        result = []
        if not root : return result
        self.dfs(root,0,result)
        return result
        
        
    def dfs(self,root,level,result):
        if not root: return
        if len(result) < level + 1:
            result.append([])
        result[level].append(root.val)
        self.dfs(root.left,level+1, result)
        self.dfs(root.right,level+1, result)
        
        