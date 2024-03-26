# Time and space complexity is O(N)
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        hmap = {i : [] for i in range(numCourses)}
        visited = set()
        
        for crs, pre in prerequisites:
            hmap[crs].append(pre)
            
        def dfs(crs):
            if crs in visited:
                return False
            
            if hmap[crs]==[]:
                return True
            
            visited.add(crs)
            
            for pre in hmap[crs]:
                if not dfs(pre):
                    return False
                
            visited.remove(crs)
            hmap[crs]=[]
            return True
        
        for c in range(numCourses):
            if not dfs(c):
                return False          
        return True
            
            
            
            
            
        