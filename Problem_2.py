# Time Complexity : O(V + E) where V is the number of vertices and E is the number of edges.
# Space Complexity :  O(V) worst case a recursion could explore all nodes and the stack will hold them all. 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        def dfs(curr, visited, checked):
            if curr in visited:
                return False
            if curr in checked:
                return True
            
            visited.add(curr)
            for adj in adjList[curr]:
                if adj in adjList: 
                    if not dfs(adj, visited, checked):
                        return False
            
            
            visited.remove(curr)
            checked.add(curr)
            return True

        adjList = {}
        for pre in prerequisites:
            second, first = pre 
            adjList[first] = adjList.get(first, []) + [second]
         
        visited = set()
        checked = set()
        for curr in adjList.keys():
            if not dfs(curr, visited, checked):
                return False
        
        return True