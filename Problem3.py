# Time Complexity : O(n) 
# Space Complexity : O(h) Space | O(n) worst case 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution:
    result = None
    def rightSideView(self,root):
        self.result = []
        if not root:
            return self.result 
        self.bfs(root)
        return self.result

    # Method 1) adding right most element from each level and recurse on right to get the right most view. 
    # def helper(self,root,level):
    #     # Base 
    #     if not root:
    #         return 
    #     # Logic 
    #     if len(self.result) == level:
    #         self.result.append(root.val)
    #     self.helper(root.right,level+1)
    #     self.helper(root.left,level+1)

    # Method 2) Adding left elements to the result array and replacing element of the level(index) by right most element of that level.
    # def helper(self,root,level):
    #     if not root:
    #         return 

    #     if len(self.result) == level:
    #         self.result.append(root.val)
    #     else:
    #         self.result[level] = root.val 
    #     self.helper(root.left,level+1)
    #     self.helper(root.right,level+1)
    
    # Method 3) BFS approach.
    def bfs(self,root):
        q = [root]
        while q:
            size = len(q)
            last = -1
            # flag = False
            for _ in range(size):
                curr = q.pop(0)
                # if flag == False:
                #     last = curr.val
                    # flag = True 
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                last = curr.val 
            self.result.append(last)
        # return 
        
if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.left = Node(2)
    n.right = Node(3)
    n.left.right = Node(5)
    n.left.right.right = Node(6)
    n.right.right = Node(4)
    res = s.rightSideView(n)
    print(res)
    