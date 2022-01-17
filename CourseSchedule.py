# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

''' The problem reduces to checking if there is a cycle per DFS path.
    Hence, the visited set takes a sort of back tracking approach.
    The checked set is to avoid recomputation of already validated nodes, i.e., 
    if we know that there is no cycle starting from this node we can return True. 
    Kind of like memoization from Recurisve Dynamic Programming.
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        def dfs(curr, visited, checked):
            if curr in visited:
                return False
            if curr in checked:
                return True
            
            visited.add(curr)
            for adj in adjList[curr]:
                if adj in adjList: # make sure that this node has an out degree
                    if not dfs(adj, visited, checked):
                        return False
            
            
            visited.remove(curr)
            checked.add(curr)
            return True
        
        '''Convert Input to Adjacency List'''
        adjList = {}
        for pre in prerequisites:
            second, first = pre 
            adjList[first] = adjList.get(first, []) + [second]
         
        visited = set()
        checked = set()
        '''Perfrom DFS on every node that has an out degree. This may be short circuited by our checked cache.'''
        for curr in adjList.keys():
            if not dfs(curr, visited, checked):
                return False
        
        return True