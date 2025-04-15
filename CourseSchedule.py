# Time Complexity: O(2V+E)
# Space Complexity: O(2V+E)
# Does this code run on Leetcode: Yes
# Did you face any problem while coding this: No


from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegrees = [0] * numCourses
        adj_list = {}
        for pr in prerequisites:
            # dependent = pr[0]
            # independent =pr[1]
            inDegrees[pr[0]]+= 1
            if pr[1] not in adj_list:
                adj_list[pr[1]] = []
            adj_list[pr[1]].append(pr[0])
        count = 0
        q = deque()
        for i in range(numCourses):
            if inDegrees[i] == 0:
               q.append(i)
               count += 1
        
        while(len(q) != 0):
            curr = q.popleft()
            dependencies = adj_list.get(curr)
            if dependencies is not None:
                for dependent in dependencies:
                    inDegrees[dependent] -= 1
                    if inDegrees[dependent] == 0:
                        q.append(dependent)
                        count +=1
        if count == numCourses:
            return True
        return False   