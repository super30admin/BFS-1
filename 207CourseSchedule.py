class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0: return True
        maps = {i:[] for i in range(numCourses)}
        for crs, pre in prerequisites:
            maps[crs].append(pre)
        
        # visitSet = ()
        q =[]
        def dfs(crs):
            if crs in q:
                return False
            if maps[crs] == []:
                return True
            q.append(crs)
            for pre in maps[crs]:
                if not dfs(pre): return False
            q.remove(crs)
            maps[crs] = []
            return True

        for crs in range(numCourses):
            if not dfs(crs): return False
        return True

# T.C=>O(N) Since we traverse whole List here.
# S.C=>O(N) Recursion stack
# # Approach=> Here we create a list of size numCourse with blank list. Then we append all the crouse and prereq in that map. 
# Here we append all the course in q and continue with dfs recursion. If we enconter the pre-req course in the q which states that ther is loop 
# hence we return False. If all the queue become empty the we retrun True 