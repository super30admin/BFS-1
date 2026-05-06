# Time Complexity : O(V+E) where v is number of course and E is number of dependencies
# Space complexity :O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : converting the logic of mapping the dependency of each course was hard it took time.

# Your code here along with comments explaining your approach
# Create an adjacency list linking prerequisites to their dependent courses and counting exactly how many prerequisites each course requires.
# Scan the indegree array to find all courses that require no prerequisites and place them into a queue to process first.
# Process courses from the queue and reduce the indegree of any dependent courses by 1, and add them to the queue. If all courses processed then return True else False.

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegree = [0] * numCourses
        graph = {}

        #mapping dependency of each course
        for pre in prerequisites:
            indegree[pre[0]] += 1
            if pre[1] not in graph:
                graph[pre[1]] = []
            graph[pre[1]].append(pre[0])
        
        count = 0
        q = deque()

        #add independent course to queue 
        for i in range(0,numCourses):
            if indegree[i] == 0:
                q.append(i)
                count += 1

        if not q:
            return False
        if count == numCourses:
            return True

        # updating the q of dependency
        while q:
            curr = q.popleft()
            dependency = graph.get(curr)
            if dependency:
                for course in dependency:
                    indegree[course] -= 1
                    if indegree[course] == 0:
                        q.append(course)
                        count += 1
                        if count == numCourses:
                            return True
        return False