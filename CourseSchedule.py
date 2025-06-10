# Space Complexity - o(V + E) where V is the total number of Vertexes and E is the total number of Edges
# Time Complexity - o(V + E)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adjacency = defaultdict(list)

        for crs, pre  in prerequisites:
            adjacency[crs].append(pre)

        seen = set()

        def dfs(pre):

            if pre in seen:
                return False

            if adjacency[pre] == []:
                return True

            seen.add(pre)

            for crs in adjacency[pre]:
                if not dfs(crs): return False

            seen.remove(pre)
            adjacency[pre] = []
            return True

        for crs in range(numCourses):
            if not dfs(crs): return False
        
        return True
