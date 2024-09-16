class Solution:
    
    def dfs(self,course, prereqs,current_path) :
        if course in current_path :
            return False
        current_path.add(course)
        for p in prereqs.get(course,[]) :
            if not self.dfs(p,prereqs,current_path) :
                return False
        current_path.remove(course)
        return True
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        prereqs = {}
        
        for e in prerequisites :
            if not prereqs.get(e[0]) :
                prereqs[e[0]] = []
            prereqs[e[0]].append(e[1])
        
        prereqs[-1] = range(numCourses)
        
        # add an extra end state node that is a child for all nodes 
        # use this node to recursively traverse the graph
        # if you find a node that is part of current path then mark 
        return self.dfs(-1,prereqs,set([])) 
            
        
        
        
