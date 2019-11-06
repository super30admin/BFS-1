class Solution:
    
    def remove(self,prereqs,v) :
        for n in prereqs :
            if v in prereqs[n] :
                prereqs[n].remove(v)
        prereqs.pop(v)
    
    def bfs(self,prereqs) :
        # inorder map

        to_delete = [i for i in prereqs if not prereqs[i]]
        while to_delete :
            for v in to_delete :
                self.remove(prereqs,v)
            to_delete = [i for i in prereqs if not prereqs[i]]

        if prereqs :
            return False
        return True
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        prereqs = {}
        for v in range(numCourses) :
            prereqs[v] = set([])
        for e in prerequisites :
            prereqs[e[0]].add(e[1])
                        
        return self.bfs(prereqs) 
            
        
