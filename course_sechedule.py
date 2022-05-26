# Time Complexity : O(V + E) where V is number of subjects and E number of prerequisites
# Space Complexity : O(V * E) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import defaultdict
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        hashmap = defaultdict(list)
        indegrees = [0 for i in range(numCourses)]
        q = deque()
        count = 0
        for edge in prerequisites:
            indegrees[edge[0]] +=  1
            hashmap[edge[1]].append(edge[0])
            
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.appendleft(i)
                count += 1
                
        if len(q) == 0:
            return False
            
        while len(q) > 0:
            sub = q.pop()
            dependents = hashmap[sub]
            for d in dependents:
                indegrees[d] -=  1
                if indegrees[d] == 0:
                    q.appendleft(d)
                    count += 1
                    if count == numCourses:
                        return True
        