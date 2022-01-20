#Time Complexity O(edge +vertices)
#Space Complexity O(edge +vertices)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    data = dict()
    in_deg = [0]*numCourses

    for x in prerequisites:
        in_deg[x[0]]+=1
        if x[1] not in data:
            data[x[1]]=list()    
        data[x[1]].append(x[0])
        
        queue = []
        for x in range(len(in_deg)):
            if in_deg[x] == 0:
                queue.append(x)
        
        count = 0
        
    if len(queue) == 0:
        return False
        
        while len(queue)>0:
            current = queue.pop(0)
            #Reduce Dependency courses 
            children = data.get(current)
            if children !=None:
                for x in children:
                    in_deg[x]-=1
                    #If it has become independant
                    if in_deg[x] == 0:
                        queue.append(x)
                        count+=1  
            
        if count == numCourses:
            return True
        else:
            return False
    
        
