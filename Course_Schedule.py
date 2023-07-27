class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        premap= {i:[] for i in range(numCourses)} #mapping each course to the prereq list
        for crs, pre in prerequisites:
            premap[crs].append(pre)
        
        visitset= set()
        def dfs(crs):
            if crs in visitset:  #if a course visited twice then it's a loop so false
                return False
            if premap[crs]==[]:  #with no prereq
                return True 
            visitset.add(crs)
            for pre in premap[crs]:
                if not dfs(pre):
                    return False
            visitset.remove(crs)
            premap[crs]=[]
            return True

        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True
