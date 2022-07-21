# Time Complexity :O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        preMap = {i:[] for i in range(numCourses)}

        for course, prereq in prerequisites:
            preMap[course].append(prereq)
       
    #   preMap= {0:[1,2],1:[3,4],2:[],3:[4],4:[]}

        visited=set()
        
        def dfs(course):
            if course in visited:
                return False
            if preMap[course]==[]:
                return True
           
            visited.add(course)

            for i in preMap[course]:
                if dfs(i) == False:
                    return False
            preMap[course]=[]
            visited.remove(course)
            return True
            
        for course in preMap.keys():
            if dfs(course) == False:
                return False
        return True
            