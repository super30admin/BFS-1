#time-v+e,space-v+e
class Solution:
    def __init__(self):
        self.flag=True
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hmap={}
        for i in prerequisites:
            
            if i[1] not in hmap.keys():
                hmap[i[1]]=[]
            hmap[i[1]].append(i[0])
            
        visited=[False for i in range(numCourses)]
        path=[False for i in range(numCourses)]
       
        for i in range(numCourses):
            if visited[i]==False:
                self.dfs(hmap,visited,path,i)
        return self.flag
    def dfs(self,hmap,visited,path,indx):
        
        
        if path[indx]==True:
            self.flag=False
            return
        if visited[indx]==True:
            return
        #logic
        visited[indx]=True
        path[indx]=True
        if indx in hmap.keys():
            for i in hmap[indx]:
                self.dfs(hmap,visited,path,i)
        path[indx]=False
        
