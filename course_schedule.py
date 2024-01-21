class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        hashmap = {}
        indegrees = [0]*numCourses
        
        for edge in prerequisites:
            out_e = edge[1] 
            in_e = edge[0]
            
            indegrees[in_e] +=1
            
            if out_e not in hashmap:
                hashmap[out_e] = []
                
            hashmap[out_e].append(in_e)
            
        queue = deque()
        count = 0
        
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)
                count += 1
          
        if count == numCourses:
            return True
        
        if len(queue) == 0:
            return False
        
        while len(queue) != 0:
            curr = queue.popleft()
            children = hashmap.get(curr,[])
            
            for child in children:
                indegrees[child] -= 1
                if indegrees[child] == 0:
                    queue.append(child)
                    count += 1

                    if count == numCourses:
                        return True
                    
                    
        return False
                
                
                
            
            
                
            
            
                
            
            
        
