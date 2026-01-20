class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course = { i:[] for i in range(numCourses)}
        for i,j in prerequisites:
            course[i].append(j)
        visited = set()
        def dfs(c):
            if c in visited:
                return False
            if course[c] == []:
                return True
            visited.add(c)
            for i in course[c]:
                if not dfs(i):
                    return False
            visited.remove(c)
            course[c] = []
            return True
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True
        

        