# Course Schedule

# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes with Runtime: 148 ms and Memory Usage: 15.5 MB 
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using graph and bfs approach checcking for prerequisites courses.
Removing the dependencies if any and repeating untill all 
dependencies are removed.

"""
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        G = [[] for i in range(numCourses)] # graph
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