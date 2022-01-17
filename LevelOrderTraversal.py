'''Dear checker, please check line 84, thank you!'''


# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Recursive Solution'''
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        def recur(root, depth):
            nonlocal result
            if not root:
                return
            
            if len(result) == depth: #make a sub list for the result because it does not exist
                result.append([])
            
            result[depth].append(root.val)
            
            recur(root.left, depth + 1)
            recur(root.right, depth + 1)

        recur(root, 0)
        return result

'''Iterative Solution'''
'''Important Take Aways
1. In iterative solutions of trees, ALWAYS check for test case of empty tree.
'''
# Time Complexity : O(N)
# Space Complexity : 
#   Let H be the height of the tree such that root has height 0, the level after that has height, and so on.
#   The maximum size of the queue is the maximum width of any leve which in the worst case can be 2^(H) where H is as defined above.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        q = deque([])
        q.append(root)
        while q:
            size = len(q)
            result.append([])
            for _ in range(size):
                curr = q.popleft()
                result[-1].append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result


'''Iterative Solution for N-Ary Tree'''
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        
        if not root:
            return []
        
        
        result = []
        q = deque([ ])
        q.append(root)
        while q:
            size = len(q)
            result.append([])
            for _ in range(size):
                curr = q.popleft()
                result[-1].append(curr.val)
                if curr.children: #you can do without this if condition, however, weirdly on leetcode performance was much better with the if condition, do you know why?
                    for child in curr.children:
                        q.append(child)
        
        return result