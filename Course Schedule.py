# time complexity is o(V + E), V is the number of vertices and E is the number of edges in the graph
# space complexity is o(V + E), V is the number of vertices and E is the number of edges in the graph

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if(len(prerequisites) == 0):
            return True
        indef = [0 for i in range(numCourses)]
        dependency_dict = dict()
        for edge in prerequisites:
            indef[edge[0]] += 1 
            if edge[1] not in dependency_dict:
                dependency_dict[edge[1]] = list()
            dependency_dict[edge[1]].append(edge[0])
        from collections import deque
        q = deque()
        count = 0
        for i in range(len(indef)):
            if(indef[i] == 0):
                q.append(i)
                count += 1
        while(len(q) != 0):
            temp = q.popleft()
            if(temp not in dependency_dict):
                continue
            for i in dependency_dict[temp]:
                indef[i] -= 1
                if(indef[i] == 0):
                    q.append(i)
                    count += 1
                if(count == numCourses):
                    return True
        return False
        
            
        
        