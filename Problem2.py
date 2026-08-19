#Problem 207. COURSE SCHEDULE
# TIME COMPELXITY: O(V+E) where V is the numberCourses and E is the prerequisites
# SPACE COMPLEXITY: O(V+E) to store the graph, queue and indegree array.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree=[0]*numCourses
        graph={}

        for prerequisite in prerequisites:
            indegree[prerequisite[0]]+=1
            if prerequisite[1] not in graph:
                graph[prerequisite[1]]=[]
            graph[prerequisite[1]].append(prerequisite[0])

        count=0
        q=deque()

        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)
                count+=1
        
        if not q:
            return False
        if count==numCourses:
            return True

        while q:
            current=q.popleft()
            dependencies=graph.get(current)
            if dependencies:
                for dependencie in dependencies:
                    indegree[dependencie]-=1
                    if indegree[dependencie]==0:
                        q.append(dependencie)
                        count+=1
                        if count==numCourses:
                            return True

        return False