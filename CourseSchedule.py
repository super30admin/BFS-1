# Time Complexity : O(N)  //Where n is the size of the list we are iterating
#  Space Complexity : O(1)  //We are using dictonary to return result
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #Base case
        if not numCourses:
            return True

        #Declare dictionary and populate it
        preMap = {i:[] for i in range(numCourses)}
        
        for course, prereq in prerequisites:
            preMap[course].append(prereq)

        visited = set()
        #Using the dfs to recursively traverse the tree
        def dfs(course):
            #base case
            if course in visited:
                return False
            if preMap[course] == []:
                return True
            
            visited.add(course)
            
            for prereq in preMap[course]:
                if not dfs(prereq):
                    return False
                
            visited.remove(course)
            preMap[course] = []
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return False
        return True
        