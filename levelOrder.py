# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No
class Solution(object):
    def rec(self,root,d,result):
        if(root==None):
            return
        if(len(result)<=d):
            result.append([])
        result[d].append(root.val)
        self.rec(root.left,d+1,result)
        self.rec(root.right,d+1,result)
        
        
    def levelOrder(self, root):
        result=[]
        self.rec(root,0,result)
        return(result)
        