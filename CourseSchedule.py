#TC: O(n)
#SC: O(n)
#Program Ran on Leetcode successfully

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        map = {}
        indegrees = [0 for i in range(numCourses)]
        for edge in prerequisites:
            indegrees[edge[0]] += 1
        
            if (edge[1] not in map):
                map[edge[1]] = []
            
            map[edge[1]].append(edge[0])
        
        queue = []
        count = 0
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)
                count += 1
        
        if count == numCourses:
            return True
        
        while (queue):
            curr = queue.pop(0)
            children = map.get(curr)
            if children is not None:
                for child in children:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        queue.append(child)
                        count += 1
                        if count == numCourses:
                            return True
        return False
                