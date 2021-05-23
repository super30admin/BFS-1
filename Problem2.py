# time:0(V+E)
#  space:0(v)

class Solution(object):
    
   
    def dfs_cycle(self,mymap,crs):  
        print(crs)
        if self.visited[crs] == 2:
            return True       
        self.visited[crs]  = 2       
        for pre in mymap[crs]:
            if self.dfs_cycle(mymap,pre):
                return True
        self.visited[crs] = 1        
        return False
    
    def canFinish(self, numCourses, prerequisites):
        
        if len(prerequisites) == 0:
            return True
        self.visited = [0] * numCourses
        mymap = {i:[] for i in range(numCourses)}
        
        for crs,preq in prerequisites:
            mymap[crs].append(preq)
            
        for i in range(numCourses):
            if self.visited[i] == 0:
                print(i)
                if self.dfs_cycle(mymap,i):
                    return False
        return True    
        
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        