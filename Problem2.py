# Leetcode 207: Course Schedule
# V -> Number of courses and E -> dependencies
# Time - O(V + E)
# Space - O(V + E)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        
        dependency_count = []
        adjacency_list = []

        for i in range(numCourses):
            
            dependency_count.append(0)
            adjacency_list.append([])
            
        for rel in prerequisites:
            
            dependency_count[rel[0]] += 1
            adjacency_list[rel[1]].append(rel[0])
         
        q = []
        
        for i in range(len(dependency_count)):
            
            if dependency_count[i] == 0:
                q.append(i)
        
        while(len(q) != 0):
            
            course = q.pop(0)
            dependent_courses = adjacency_list[course]
            
            for c in dependent_courses:
                
                dependency_count[c] = dependency_count[c] - 1
                
                if dependency_count[c] == 0:
                    
                    q.append(c)
        
        
        for count in dependency_count:
            
            if count != 0:
                return False
            
        return True