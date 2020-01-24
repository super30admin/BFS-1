"""
Time Complexity : O(V*E)
Space Complexity : O(V+E)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue

class Solution:
    def canFinish(self, numCourses, prerequisites):
        in_degree = [0]*numCourses
        adjacency = {}
        q = Queue()

        # build adjacency map (so we achieve O(1) lookup times) and in_degree list
        for i in range(len(prerequisites)):
            in_degree[prerequisites[i][0]] += 1     
            if prerequisites[i][1] not in adjacency:
                adjacency[prerequisites[i][1]] = []
            adjacency[prerequisites[i][1]].append(prerequisites[i][0])
        
        # put initial element in queue that have no dependencies
        for i in range(len(in_degree)):
            if in_degree[i] == 0:
                q.put(i)
        
        # start doing BFS
        while not q.empty():
            course = q.get()
            dependencies = adjacency.get(course)
            # check for whether the course had an dependencies or not
            # so that you do not get None as children
            if dependencies: 
                for i in dependencies:
                    in_degree[i] -= 1
                    if in_degree[i] == 0:
                        q.put(i)
                        
        for i in range(len(in_degree)):
            if in_degree[i] > 0:
                return False
            
        return True
            
s = Solution()
print(s.canFinish(6, [[0,2], [0,4], [2,1], [4,1], [1,5], [2,3], [3,5]]))