"""
TC= 0(V+E)

"""

class Solution_course:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree=[0]*numCourses
        adjlist=[[] for i in range(numCourses)] 
        #create adjacency list and indegree array
        for k,v in prerequisites:
            indegree[k]+=1
            adjlist[v].append(k)
        #print("ind",indegree)
        #see all independent node into q
        #print(adjlist)
        q=[]
        for i in range(numCourses):
            if(indegree[i]==0):
                q.append(i)
                
        while q:
            curr=q.pop(0)
            print("curr",curr)
            for course in adjlist[curr]: #cannot use dict for adjlist as it will give keyerror exception 
                indegree[course]-=1
                if indegree[course] == 0:
                    q.append(course)
        
        for i in range(len(indegree)):
            if(indegree[i]>0):
                return False
        return True
        
                
        
                
            
        
                      
            
        
        