class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        ## T.C: O(v + e)
        ## S.C: O(v + e)
        
        dependency = [0 for i in range(numCourses)]
        adj = {}
        
        for i, j in prerequisites:
            dependency[i] += 1
            if j in adj.keys():
                adj[j].append(i)
            else:
                adj[j] = [i]
        
        
        q = [i for i in range(numCourses) if dependency[i] == 0]

        while q:
            
            x = q.pop(0)
            
            if x in adj.keys():
                for i in adj[x]:
                    dependency[i] -= 1
                    if dependency[i] == 0:
                        q.append(i)
                    
        return sum(dependency) == 0
            
            