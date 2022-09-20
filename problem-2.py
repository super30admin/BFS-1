class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        if len(prerequisites) == 0 or numCourses == 1: 
            return True
        
        indegree = [0] * numCourses
        adjacency_list = {}
        q = []
        
        for i in range(numCourses):
            adjacency_list[i] = []
            indegree[i] = 0
            
        for p in prerequisites:
                adjacency_list[p[1]].append(p[0])
                indegree[p[0]] += 1
        
        # print(adjacency_list)
        # print(indegree)
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)
        completed = 0
        while q:
            e = q.pop(0)
            completed += 1
            for n in adjacency_list[e]:
                indegree[n] -= 1
                if indegree[n] == 0:
                    q.append(n)
        if completed == numCourses:
            return True
        else:
            return False