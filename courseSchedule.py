class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if not prerequisites:
            return True
        indegrees = [0]*numCourses
    
        dependancies = dict()
        
        processingQueue = list()
        
        for edge in prerequisites:
            inVal = edge[0]
            outVal = edge[1]
            if outVal not in dependancies:
                dependancies[outVal] = list()
            
            dependancies[outVal].append(inVal)
            indegrees[inVal] += 1

        
        for i in range(0,len(indegrees)):
            if indegrees[i] == 0:
                processingQueue.append(i)
    
        if not processingQueue:
            return False
    
        while processingQueue:
            curr = processingQueue.pop(0)
            
            
            if curr not in dependancies:
                continue
            
            for value in dependancies[curr]:
                indegrees[value]-=1
                if indegrees[value] == 0:
                    processingQueue.append(value)
        
        
        for i in indegrees:
            if i!=0:
                return False
        
        return True
            
            
#  bfs approach, bad problem..too many complexities. Design algo prior to solving these kind of problems
#  time complexity is O(v+e) v is edges and e is edges. 
            
            
            
            
        
            
        
            
            
            
        
        
        
