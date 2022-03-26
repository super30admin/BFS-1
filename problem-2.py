# Leetcode Execution: YES
# TimeComplexity:O(V+E)
# Space Complexity:O(V+E) 


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # we are maintaining  a map to store what courses to complete for each course
        # we also mainintain array of courses where we store how any courses to complete ech course basically how manu coruses each course of dependent on
      
        comp={}
        count=0
        courses=[0]* numCourses
        queue=[]
        for x in prerequisites:
            courses[x[0]]+=1
            if comp.get(x[1]):
                comp[x[1]].append(x[0])
            else:
                comp[x[1]]=[x[0]]
        # we then see how many courses do not require any pre requesistes and add it to queue 
       
        for i,x in enumerate(courses):
            if x==0:
                queue.append(i)
           # we loop thourght the queue and remove each course we have completed from the queue and add each course whihc have 0 pre requisites tp the queue 
        
        # if we have no such course we just return false 
        if queue:
            while(queue):
              
                a=queue.pop(0)
                count+=1
                if comp.get(a):
               
                    for i,x in enumerate(comp[a]):
                        
                        courses[x]-=1
                        if courses[x]==0:
                            queue.append(x)
            
                            
                
        else:
            return False
        
        # we then see if the courses count matches with the courses given to complete
        return count==numCourses
           
        