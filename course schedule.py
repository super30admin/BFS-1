# // Time Complexity : O(|E|+|V|) where V is the number of courses and E is the number of dependencies 
# // Space Complexity : O(|E|+|V|) where V is the number of courses and E is the number of dependencies 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        
        # map each course to prereq list
        preMap = {i:[] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
            
        # visitSet = all courses along the curr DFS path
        visitSet = set()
        def dfs(crs):
            if crs in visitSet:
                return False
            if preMap[crs] == []:
                return True
            
            visitSet.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre): return False
            visitSet.remove(crs)
            preMap[crs] = []
            return True
        
        # call dfs for every single course
        for crs in range(numCourses):
            if not dfs(crs): return False
        return True
                