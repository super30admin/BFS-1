# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj_list = collections.defaultdict(list)
        indegrees = [0] * numCourses

        for course, pre in prerequisites:
            adj_list[pre].append(course)
            indegrees[course] += 1
        
        queue = collections.deque()
        for ix in range(numCourses):
            if indegrees[ix] == 0:
                queue.append(ix)
        
        coursesTaken = 0
        while queue:
            take = queue.popleft()
            coursesTaken += 1
            neib = adj_list[take]
            for n in neib:
                indegrees[n] -= 1
                if indegrees[n] == 0:
                    queue.append(n)
        
        return coursesTaken == numCourses