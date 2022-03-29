# Time Complexity : O(E+V)
#  Space Complexity : O(E+V)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :  no

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = defaultdict(list)
        degrees = [0] * numCourses
        
        for p in prerequisites:
            graph[p[1]].append(p[0])
            degrees[p[0]] += 1
            
        q = deque(n for n in range(numCourses) if degrees[n] == 0)

        count = 0 
        while q:
            course = q.popleft()
            count += 1
            for neighbor in graph[course]:
                degrees[neighbor] -= 1
                if degrees[neighbor] == 0:
                    q.append(neighbor)

        return count == numCourses
        