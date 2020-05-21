#Time Complexity:O(v+e)
#Space Complexity:O(v)

#Ran successfully on Leetcode:Yes
#Algorithm:
 
# BFS uses the indegrees of each node. We will first try to find a node with 0 indegree. If we fail to do so, there must be a cycle in the graph and we return false. Otherwise we have found one. We set its indegree to be -1 to prevent from visiting it again and reduce the indegrees of all its neighbors by 1. This process will be repeated for n (number of nodes) times. If we have not returned false, we will return true.
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegree = [0] * numCourses
        edges = [set() for _ in range(numCourses)]
        for u, v in prerequisites:
            edges[v].add(u)
            indegree[u] += 1
        sources = [v for v in range(numCourses) if indegree[v] == 0]
        topo_order = []
        while sources:
            s = sources.pop(0) # can be any sequence to delete
            topo_order.append(s)
            for v in edges[s]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    sources.append(v)
        return len(topo_order) == numCourses
