# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        graph = collections.defaultdict(list)
        indegree = collections.defaultdict(int)
        q = []
        topsort = []
        
        for course, prerequisite in prerequisites:
            
            # add to a graph
            graph[prerequisite].append(course)
            indegree[course] += 1
            
        
        for course in range(numCourses):
            if indegree[course] == 0:
                q.append(course)
                
        while q:
            
            course = q.pop(0)
            
            indegree[course] -= 1
            topsort.append(course)
            
            for prereq in graph[course]:
                
                indegree[prereq] -= 1
                if indegree[prereq] == 0:
                    q.append(prereq)
        
        if len(topsort) == numCourses:
            return True
        else:
            return False
                