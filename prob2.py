# Time Complexity :O(n)
# Space Complexity :O(n)
# Leet Code: Yes

import queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if len(prerequisites) == 0:
            return True
        #prepare adjacency list and indegree array

        ad_list = {}
        indegree_list = [0 for _ in range(numCourses)]
        q = queue.Queue()

        for data in prerequisites:
            dependent = data[0]
            independent = data[1]

            indegree_list[dependent] += 1
            if independent not in ad_list:
                ad_list[independent] = [dependent]
            else:
                ad_list[independent].append(dependent)

        count = 0
        for i in range(numCourses):
            if indegree_list[i] == 0:
                q.put(i)
                count += 1
        
        while not q.empty():
            val = q.get()
            if val in ad_list:
                for data in ad_list[val]:
                    indegree_list[data] -= 1
                    if indegree_list[data] == 0:
                        q.put(data)
                        count += 1
                        if count == numCourses:
                            return True

        return False

