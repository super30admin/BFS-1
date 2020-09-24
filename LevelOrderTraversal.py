// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        arrFinal=[]
        if root is None:
            return arrFinal
        queue=[root]
        while len(queue)!=0:
            size=len(queue)
            temp=[]
            for i in range(size): # find child of root until that level
                x=queue.pop(0)
                temp.append(x.val)
                if x.left!=None:
                    queue.append(x.left)
                if x.right!=None:
                    queue.append(x.right)
            arrFinal.append(temp) # add every level seperately
        return arrFinal # add the final output
 