# Time Complexity: O(m + n) - n = num of courses / m = prereq
# Space Complexity: O(m + n)
class Solution:
    def dfs(self, adj: Dict[int, List[int]], node: int, visited: set, path: set) -> bool:
        # print("Node: ", node, "Visited: ", visited, "Path: ", path)
        if node in path:
            # print("In path %d - Cycle" % node)
            return False
        if node in visited:
            # print("Visited %d" % node)
            return True
        if len(adj[node]) == 0:
            # print("NO dep %d" % node)
            visited.add(node)
            return True
        path.add(node)
        for neighbor in adj[node]:
            # print("Checking neighbor %d" % neighbor)
            if not self.dfs(adj, neighbor, visited, path):
                # print("Failed on  neighbor %d" % neighbor)
                return False
        visited.add(node)
        path.remove(node)
        return True 

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        visited = set()
        path = set()
        adjList = {c: [] for c in range(numCourses)}
        for pre in prerequisites:
            adjList[pre[0]].append(pre[1])
        # print(adjList)
        for course, preReqs in adjList.items():
            # print("====")
            if not self.dfs(adjList, course, visited, path):
                # print("Course %d failed check" % course)
                return False
            # print("====")
        
        return True


