# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
#Time Complexity=O(n)
#Space Complexity=O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result=[]
        q=deque()
        q.append(root)
        while q:
            s=len(q)
            curr=[]
            for i in range(s):
                e=q.popleft()
                if e.left:
                    q.append(e.left)
                if e.right:
                    q.append(e.right)
                curr.append(e.val)
            result.append(curr)
        return result
        
        

# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)

#Time Complexity=O(V+E)
#Space Complexity=O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        depend=[0]*numCourses
        h=defaultdict(list)
        for i in prerequisites:
            depend[i[0]]+=1
            h[i[1]].append(i[0])
        q=deque()
        for i in range(len(depend)):
            if depend[i]==0:
                q.append(i)
        while q:
            e=q.popleft()
            l=h[e]
            for i in l:
                if depend[i]>0:
                    depend[i]-=1
                if depend[i]==0:
                    q.append(i)
        for i in range(len(depend)):
            if depend[i]!=0:
                return False
        return True
            
            
            
        
        
