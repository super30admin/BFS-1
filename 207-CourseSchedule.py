#Time Complexity : O(V+E)  as we formed adjacency list with the course dependency and not visiting node if already visited
# Space Complexity : O(V+E) for path, visited and adjacency list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import defaultdict
        courseDict = defaultdict(list)
        
        for relation in prerequisites:
            nextCourse,prevCourse = relation[0],relation[1]
            if prevCourse not in courseDict.keys():
                courseDict[prevCourse] = []
            courseDict[prevCourse].append(nextCourse)
        visited = [False] * numCourses
        path    = [False] * numCourses
        
        def hasCycle(course):
            #base
            if path[course]:
                return True
            if visited[course]:
                return False
            
            
            #logic
            visited[course] = True
            path[course]    = True
            for child in courseDict[course]:
                if hasCycle(child):
                    return True
            
            path[course] = False
            return False
            
        
        for i in range(numCourses):
            if visited[i] == False and hasCycle(i):
                return False
        return True
    
        
        
        