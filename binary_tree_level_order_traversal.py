"""
// Time Complexity : O(n) 
// Space Complexity : O(n)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
- Use of 2 queues - even and odd queue
- Using even queue to track even ordered level and odd queue to track
odd ordered level
- We add the root val per level from the respective queue to the final result

DFS
- We use recursion with level to track down the elements to be added to sublist
in the result array
- If the level is equal to len(results), then add a new list to results
- dfs(root.left,level+1)
- dfs(root.right,level+1)
- results[level].append(root.val)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        q = deque()
        q.append(root)
        level_order_list = []
        '''
        #Method1 - Using Length of the queue to get level wise values of the node.
        while q:
            #root = q.popleft()
            #level_order_list.append([root])
            level_vals = []
            for _ in range(len(q)):
                root = q.popleft()
                level_vals.append(root.val)
                if root.left:
                    q.append(root.left)
                    #level_vals.append(root.left.val)
                if root.right:
                    q.append(root.right)
                    #level_vals.append(root.right.val)
            level_order_list.append(level_vals)
            
        #print(level_order_list)
        return level_order_list
        '''
        #Method2 - Use of odd and even queues to keep track of the alternative levels
        even_q = deque()
        even_q.append(root)
        odd_q = deque()
        while even_q or odd_q:
            level_ans = []
            if not odd_q:
                while even_q:
                    curr = even_q.popleft()
                    if curr:
                        level_ans.append(curr.val)
                        odd_q.append(curr.left)
                        odd_q.append(curr.right)
            elif not even_q:
                while odd_q:
                    curr = odd_q.popleft()
                    if curr:
                        level_ans.append(curr.val)
                        even_q.append(curr.left)
                        even_q.append(curr.right)
            if level_ans:
                level_order_list.append(level_ans)
        return level_order_list


        #Method3 - DFS approach
        results = []
        def dfs(root,level):
            if not root:
                return
            if level == len(results):
                temp = []
                results.append(temp[:])
            dfs(root.left,level+1)
            dfs(root.right,level+1)
            results[level].append(root.val)
        #return results
        
        if root:
            dfs(root,0)
        return results