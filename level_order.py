# Time Complexity :O(N)
# Space Complexity :O(LogN)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque
class Solution:

    def dfs(self, root, i):
        #base
        if(root==None):
            return
        #logic
        self.hash[i]=self.hash.get(i, [])+[root.val]
        if(root.left):
            self.dfs(root.left, i+1)
        if(root.right):
            self.dfs(root.right, i+1)


    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.level_trav=[]
        q=deque([])
        q.append(root)

        while(len(q)):
            l=[]
            size=len(q)
            while(size):
                curr=q.popleft()
                
                size-=1
                if(curr):
                    l.append(curr.val)
                    q.append(curr.left)
                    q.append(curr.right)
            if(len(l)):
                self.level_trav.append(l)
        return self.level_trav
    

        # self.hash={}
        # self.dfs(root,0)
        # # print(self.hash)
        # return self.hash.values()

