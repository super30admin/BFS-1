import collections

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        TC: O(N) 
        SC: O(N) // storing graph + indegree for n courses
        Approach : 
            1 Create graph of preq : dependent course
            2 Create indegree array for n couses : count of prereq courses for this course
            3 Apply BFS by taking course with 0 indegree and 
                    when you take a course reduce indegree of all its dependent course as its one prereq is done
                    repeat this until process until there is any course left with 0 indegrees
            4 check the indegree of all the course 
                if all courses are taken return True
                else return False
        """
        #graph creation and calculating indegree 
        graph = collections.defaultdict(list)
        indegree = [0] *numCourses
        for course, prereq in prerequisites:
            graph[prereq].append(course)
            indegree[course] += 1
        
        #start with the courses having 0 indegree (No pre requsite)
        q = []
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                
        #apply BFS to find the next course we can take       
        while q:
            x = q.pop(0)
            for i in graph[x]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    q.append(i)
        
        #checking any course left 
        c = 0
        for i in range(numCourses):
            c += indegree[i]    
            
        #if no courses left return True else False
        return True if c == 0 else False
    
            
        