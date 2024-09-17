#Time complexity: 
#Space complexity:
#Works on leetcode:
#Approach: We need to check if the graph or dependencies form acyclic graph and use adjacency list for it (BFS with Kahn's algorithm for Topological Sorting).
#We keep a list to have indegrees of all courses as well as queue with nodes having 0 indegrees. Then we go through this queue
# and decrement the indegree of the adjacent node of the node, if the adjacent node indegree becomes 0, we add it to the queue.
#Finally we check if number of nodes with 0 indegree equals to total courses. 
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        deg = [0]*numCourses
        #graph = [[] for _ in range(numCourses)]
        graph = cl.defaultdict(list)
        for i,j in prerequisites:
            graph[j].append(i)
            deg[i]+=1
        
        bfs = [i for i in range(numCourses) if deg[i]==0]
        for b in bfs:
            for v in graph[b]:
                deg[v]-=1
                if deg[v]==0:
                    bfs.append(v)
        return len(bfs)==numCourses