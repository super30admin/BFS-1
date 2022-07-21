class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if(numCourses==0):
            return True
        hm = dict()
        indegrees = [0] * numCourses
        for i in prerequisites:
            inp = i[0]
            out = i[1]
            indegrees[inp] += 1
            if(hm.get(out) is None):
                hm[out] = []
            hm[out].append(inp)
            
            
        q = set()
        for i in range(0,numCourses):
            if(indegrees[i]==0):
                q.add(i)
        
        while(len(q)!=0):
            curr = q.pop()
            edges = hm.get(curr)
            if(edges == None):
                continue
            else:
                for edge in edges:
                    indegrees[edge] -= 1
                    if(indegrees[edge] == 0):
                        q.add(edge)
        
        for i in range(0,numCourses):
            if(indegrees[i]!= 0):
                return False
            
        return True