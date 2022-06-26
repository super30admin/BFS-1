"""
TC/SC: O(v + E) /O(E + V)
"""
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dict = {i:[] for i in range(numCourses)}
        
        for i,j in prerequisites:
            dict[i].append(j)
        visiting = set()
        def dfs(course):
            if course in visiting:
                return False
            if dict[course] ==[] :
                return True
            
            visiting.add(course)
            
            for crs in dict[course]:
                if not dfs(crs):
                    return False
            
            dict[course] =[]
            visiting.remove(course)
            return True
        
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True
        
