# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We create an adjacency list and an indegree array
# We start with the sources with indegree 0, and then process it dependencies using a queue
# We then reduce their corresponding indegrees. Anytime indegree reaches 0, we have a new source which we add to the queue.
# If we have leftover vertices with an indegree > 0, then we cannot take all courses. If 0, then all courses can be taken.

from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        adj = defaultdict(list)
        indeg = defaultdict(int)
        for (a, b) in prerequisites:
            adj[b].append(a)
            indeg[a] += 1
        
        sources = deque()
        for i in range(numCourses):
            if indeg[i] == 0:
                sources.append(i)
        
        while sources:
            curr = sources.popleft()
            for dep in adj[curr]:
                indeg[dep] -= 1
                if indeg[dep] == 0:
                    sources.append(dep)
        
        return sum(indeg.values()) == 0
