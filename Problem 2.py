class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        graph = defaultdict(list)
        for i, j in prereq:
            graph[i].append(j)

        
        visited = set()
        def dfs(course):
            if not graph[course]:  #no dependency
                return True
            if course in visited:
                return False
            
            visited.add(course)
            for pre in graph[course]:
                if not dfs(pre):
                    return False
            visited.remove(course)
            graph[course] = []
            return True



        for i in range(numCourses):
            if not dfs(i): 
                return False
        return True
