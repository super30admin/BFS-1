
#Time Complexity : O(v+e)
#Space Complexity :O(v)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = {i:[] for i in range(numCourses)}
        
        for crs, prereqs in prerequisites:
            preMap[crs].append(prereqs)
        
        visited = set() 
        
        def dfs(crs):
            if crs in visited: # visiting a course twice so there's a loop
                return False
            if preMap[crs] ==[]: # has no prereqs so definitely can be completed 
                return True 
            
            visited.add(crs)
            for prereqs in preMap[crs]:
                if not dfs(prereqs):
                    return False
            visited.remove(crs)
            preMap[crs] = []
            return True 
            
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True
