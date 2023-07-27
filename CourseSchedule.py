from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites is None or len(prerequisites) == 0:
            return True
        
        # Build graph and calculate in-degrees
        d = defaultdict(list)
        inDegrees = [0] * numCourses
        
        for course, prerequisite in prerequisites:
            d[prerequisite].append(course)
            inDegrees[course] += 1
        
        print(d)
        print(inDegrees)
        
        # Perform topological sorting using a queue
        queue = deque()
        completedCourses = 0
        
        for course in range(numCourses):
            if inDegrees[course] == 0:
                queue.append(course)
                completedCourses += 1
        
        while queue:
            course = queue.popleft()
            for nextCourse in d[course]:
                inDegrees[nextCourse] -= 1
                if inDegrees[nextCourse] == 0:
                    queue.append(nextCourse)
                    completedCourses += 1
                    if completedCourses == numCourses:
                        return True
        
        return False
