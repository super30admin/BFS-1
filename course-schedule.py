class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #null cases
        if numCourses == 1:
            return True
        indegrees = [0 for i in range(numCourses)]
        
        dic = {}
        
        for i in range(len(prerequisites)):
            key = prerequisites[i][1]
            val = prerequisites[i][0]
            
            indegrees[val]+=1
            
            if key not in dic:
                dic[key] = [val]
            else:
                dic[key].append(val)
            
        
        #create queue, count =0
        q = []
        count = 0
        
        #add independent nodes to the queue
        for i,num in enumerate(indegrees):
            if indegrees[i] == 0:
                q.append(i)
                count +=1
                    
        #while queue is not empty, 
            #add all courses which are dependent on this course
            #if list in map is not null, iterate over it, decreasing the count in indegree, if its zero, add it
        while(q):
            curr = q.pop(0)
            children = dic.get(curr)
            
            if(children is not None):
                for child in children:
                    indegrees[child]-=1
                    if indegrees[child] == 0:
                        q.append(child)
                        count +=1
                        
        for i in indegrees:
            if i >0:
                return False
        
        return True
            
                        
        
        
            