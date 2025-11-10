# BFS-1
# Problem 1
# Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

# Implemented BFS (level-order traversal) using a queue:
# Initialize with root node in queue
# For each level: Process all nodes currently in the queue (using for i in range(len(q)))
# Collect values in temp list
# Add children to queue for next level
# Append each level's temp list to final result res
# The for loop bound (len(q)) is fixed at start of each level, ensuring clean separation between levels. 
# This pattern works for all BFS level-processing problems!

# Time Complexity: O(N) — visit each node once
# Space Complexity: O(W) — maximum width of tree (queue stores at most one level)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = [root]
        res = []
        while q:
            temp = []
            for i in range(len(q)):
                curr = q.pop(0)
                temp.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(temp)
        return res

        


# Problem 2
# Course Schedule (https://leetcode.com/problems/course-schedule/)

# Topological Sorting:
# Build graph:  
#    hashmap stores adjacency list (course → dependent courses)  
#    indegrees tracks how many prerequisites each course has  
# Initialize queue with all courses having 0 prerequisites (indegrees[i] == 0)  
# Process courses:  
#    For each course taken, reduce in-degree of its dependents  
#    Add newly unlocked courses (in-degree = 0) to queue  
#    Count total processed courses  
# Check completion: If total == numCourses, all courses can be finished  
# This detects cycles in a directed graph – if a cycle exists, some courses will never reach in-degree 0, making total < numCourses.

# Time Complexity: O(V + E) (V = courses, E = dependencies)  
# Space Complexity: O(V + E) (graph + in-degrees + queue)  



class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0]*numCourses
        hashmap = {}
        
        for pr in prerequisites:
            indegrees[pr[0]] += 1 # value at dependent index increases by 1
            if pr[1] not in hashmap:
                hashmap[pr[1]] = []
            hashmap[pr[1]].append(pr[0])

        q = deque()
        total = 0

        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                total += 1

        if not q:
            return False
        if total == numCourses:
            return True
        
        while q:
            curr = q.popleft()
            dependencies = hashmap.get(curr)
            if dependencies:
                for dep in dependencies:
                    indegrees[dep] -= 1
                    if indegrees[dep] == 0:
                        q.append(dep)
                        total += 1
                        if total == numCourses:
                            return True
        return False
