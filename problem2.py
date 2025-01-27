# Checking if there are any cycles
# Stop return False if any course to be done is already in ongoing
# TC SC = O(V+E) O(n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        rg = { i: [] for i  in range(numCourses)}
        pr = prerequisites
        for c in pr:
            course, req = c[0], c[1]
            rg[course].append(req)
        print(rg)

        status = [0] * numCourses
        ongoing = 1
        completed = 2 
        def dfs(c):
            if status[c] == completed: return True
            if status[c] == ongoing: return False
            status[c] = ongoing
            if rg[c]:
                pre_req = rg[c]
                for pre in pre_req:
                    if not dfs(pre):
                        return False
            status[c] = completed
            return True


        for c in range(0, numCourses):
            if not dfs(c):
                return False
        return True