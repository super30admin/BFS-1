class Solution:
    def canFinish(self, numCourses, prerequisites):
        pre_map = {i: [] for i in range(numCourses)}
        
        for crs, pre in prerequisites:
            pre_map[crs].append(pre)
            
        visitSet = set()
        def dfs(crs):
            if crs in visitSet:
                return False
            if pre_map[crs] == []:
                return True
            
            visitSet.add(crs)
            for pre in pre_map[crs]:
                if not dfs(pre): return False
            visitSet.remove(crs)
            pre_map[crs] = []
            return True
        for crs in range(numCourses):
            if not dfs(crs): return False
        return True

if __name__ == "__main__":
    s = Solution()
    numCourses = 2
    prerequisites = [[1,0]]
    print(s.canFinish(numCourses, prerequisites))