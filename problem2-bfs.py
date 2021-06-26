class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0 for _ in range(numCourses)]
        adjList = {}
        for j in range(numCourses):
            adjList[j] = []
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] +=1
            if prerequisites[i][1] in adjList:
                adjList[prerequisites[i][1]].append(prerequisites[i][0])
            else:
                adjList[prerequisites[i][1]] = ([prerequisites[i][0]]) 
                
        # print(adjList)
        # print(indegrees)
        q = []
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
        if not q: return False
        count = 0
        while q:
            curr = q.pop(0)
            count +=1
            edges = adjList[curr]
            for edge in edges:
                indegrees[edge] -=1
                if indegrees[edge] == 0:
                    q.append(edge)
        
        if count!= numCourses: return False
        return True 

#Time complexity is O(v+e) where v is number of nodes and e is nomber of edges.
#Space complexity is O(v+e) as we are storing all the elements in auxiliary data strructure