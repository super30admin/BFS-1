# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseGraph = {}
        indegrees = [0]*numCourses
        for i in range(numCourses):
            courseGraph[i] = []
        for prerequisite in prerequisites:
            course = prerequisite[0]
            prereq = prerequisite[1]
            
            courseGraph[prereq].append(course)
            
            indegrees[course] += 1
        
        queue = deque()
        for course in range(numCourses):
            if indegrees[course] == 0:
                queue.append(course)
        processed = 0  
        while queue:
            count = len(queue)
            for i in range(count):
                course = queue.popleft()
                adjcourses = courseGraph[course]
                for adjcourse in adjcourses:
                    indegrees[adjcourse] -=1
                    if indegrees[adjcourse] == 0:
                        queue.append(adjcourse)
                processed +=1
        
        return processed == numCourses
                    
                
        
        