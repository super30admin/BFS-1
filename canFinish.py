from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses, prerequisites):
        graph = defaultdict(list)
        
        in_degree = [0] * numCourses
        
        for course, prereq in prerequisites:
            graph[prereq].append(course)
            in_degree[course] += 1
            
        queue = deque([i for i in range(numCourses) if in_degree[i] == 0])
       
        courses_taken = 0
        
        while queue:
            current_course = queue.popleft()
            courses_taken += 1
            
            for neighbor_course in graph[current_course]:
                in_degree[neighbor_course] -= 1
                
                if in_degree[neighbor_course] == 0:
                    queue.append(neighbor_course)
                    
        return courses_taken == numCourses
