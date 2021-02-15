# O(V + E) TIME AND O(V + E) SPACE WHERE V IS NO.OF COURSES AND E IS NO.OF PREREQS
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {}
        prereqs = [0 for _ in range(numCourses)]
        
        for course,prereq in prerequisites:
            if prereq not in graph:
                graph[prereq] = []
            graph[prereq].append(course)
            prereqs[course] += 1
        
        queue = []
        for course,x in enumerate(prereqs):
            if x == 0:
                queue.append(course)
        
        while queue:
            current_course = queue.pop(0)
            if current_course not in graph:
                continue
            for course in graph[current_course]:
                prereqs[course] -= 1
                if prereqs[course] == 0:
                    queue.append(course)
        
        for course in prereqs:
            if course != 0:
                return False
        return True