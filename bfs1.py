# problem 1 : 102. Binary Tree Level Order Traversal : https://leetcode.com/problems/binary-tree-level-order-traversal/
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root :
            return []
        level_order = []
        de = deque()
        de.append((root, 1))
        while de :
            node, level = de.popleft()
            if len(level_order) < level :
                new_level = [node.val]
                level_order.append(new_level)
            else :
                level_order[level-1].append(node.val)
            if node.left :
                de.append((node.left, level + 1))
            if node.right :
                de.append((node.right, level + 1))
            #print(de)
                
        return level_order
        

# problem 2 : 207. Course Schedule : https://leetcode.com/problems/course-schedule/
# Time Complexity : O(E+V) 
# Space Complexity : O(E+V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    # # basic approach not good
    #     pre = collections.defaultdict(list)
    #     for ele in prerequisites:
    #         pre[ele[0]].append(ele[1])
    #     taken = set()
    #     for i in range(numCourses):
    #         if i not in pre:
    #             taken.add(i)
    #             for key, value in pre.items():
    #                 if i in value:
    #                     del value[value.index(i)]
    #     while len(taken) != numCourses:
    #         change= False
    #         for i in range(numCourses):
    #             if i not in taken and pre[i] == []:
    #                 change = True
    #                 taken.add(i)
    #                 for key, value in pre.items():
    #                     if i in value:
    #                         del value[value.index(i)]
    #         if change == False:
    #             return False
    #     return True
    
    ## better solution with TC and SC (E + V)
#         pre = collections.defaultdict(list)
#         for ele in prerequisites:
#             pre[ele[0]].append(ele[1])
#         checked = [False] * numCourses
#         path = [False] * numCourses
#         for i in range(numCourses):
#             if self.iscycle(i, pre, checked, path):
#                 return False
#         return True
    
#     def iscycle(self,curr, pre, checked, path):
#         if checked[curr]:
#             return False
#         if path[curr]:
#             return True
        
#         path[curr] = True
#         cycle = False
#         for ele in pre[curr]:
#             cycle = self.iscycle(ele, pre, checked, path)
#             if cycle:
#                 break
#         path[curr] = False
#         checked[curr] = True
#         return cycle
    
    ## topological sort with TC and SC (E + V)
        G = [[] for i in range(numCourses)]
        degree = [0] * numCourses
        for j, i in prerequisites:
            G[i].append(j)
            degree[j] += 1
        bfs = [i for i in range(numCourses) if degree[i] == 0]
        for i in bfs:
            for j in G[i]:
                degree[j] -= 1
                if degree[j] == 0:
                    bfs.append(j)
        return len(bfs) == numCourses

# problem 3 : 199. Binary Tree Right Side View : https://leetcode.com/problems/binary-tree-right-side-view/
# Time Complexity : O(n)
# Space Complexity : O(D) - diameter of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        pn, pl = root, -1
        de = deque([(root,0)])
        res = []
        while de:
            cn, cl = de.popleft()
            if cl != pl :
                res.append(cn.val)
                pn, pl = cn, cl
            if cn.right:
                de.append((cn.right, cl+1))
            if cn.left:
                de.append((cn.left, cl+1))
        return  res       


