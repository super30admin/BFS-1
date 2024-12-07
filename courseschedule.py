from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        res = [0] * numCourses
        q = Queue()
        adj = {}
        for i in range(len(prerequisites)):
            res[prerequisites[i][0]] += 1
            if prerequisites[i][1] in adj:
                adj[prerequisites[i][1]].append(prerequisites[i][0])
            else:
                adj[prerequisites[i][1]] = [prerequisites[i][0]]
        for i in range(len(res)):
            if res[i]==0:
                q.put(i)
        if q.qsize() == numCourses:
            return True
        if q.empty():
            return False
        while(not q.empty()):
            curr = q.get()
            res[curr] = -1
            if curr in adj:
                dep = adj[curr]
                for i in dep:
                    res[i] -= 1
                    if res[i]==0:
                        q.put(i)
        for i in res:
            if i > 0:
                return False
        return True
                

            
            



        
        
        
        