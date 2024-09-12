// Time Complexity : O(V+E)
// Space Complexity : O(Max depth)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return
        queue=[root]
        output=[]
        while len(queue):
            size=len(queue)
            for i in range(size): #binary level order traversal
                front=queue.pop(0)
                if front.left:
                    queue.append(front.left)
                if front.right:
                    queue.append(front.right)
                if i==size-1:
                    output.append(front.val) # add last element in every level
        return output # return output