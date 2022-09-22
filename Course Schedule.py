class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        preMap = {i:[] for i in range(numCourses)}
        
        for crs,pre in prerequisites:
            preMap[crs].append(pre)
            
        visited = set()
        
        def dfs(crs):
            if(preMap[crs]==[]):
                return True
            if crs in visited:
                return False
            visited.add(crs)
            for it in preMap[crs]:
                if not dfs(it):
                    return False
            #visited.remove(crs)
            preMap[crs]=[]
            return True
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True