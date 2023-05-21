#Time Complexity: O(n)
#Space Complexity: O(n)

from collections import defaultdict

class Solution:

    def canFinish(self, numCourses, prerequisites):

        recStack, visited = [], []
        graph = defaultdict(list)

        for k, v in prerequisites:
            graph[k].append(v)


        dfs(graph, visited, recStack, v):

            visited[v] = True
            recStack[v] = True
        
            for edge in graph[v]:
                if visited[edge] == False:
                    if(dfs(graph, visited, recStack, edge) == True):
                        return True

                elif recStack[edge] == True:
                    return True
                
            recStack[v] = False
        
            return False
    

        visited = [False] * numCourses
        recStack = [False] * numCourses

        for v in range(numCourses):
            if (visited[v] == False):
                if(dfs(graph, visited, recStack, v) == True)):
                    return False
            
        return True
                

