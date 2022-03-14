// Time Complexity : O(n) 
// Space Complexity : O(2*n)  (queue and hashmap)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        #Get the number of indegrees for each node or
        #number of courses need to completed to take this course
        
        in_degree={}
        for i in range(0,numCourses):
            in_degree[i]=0   
        for val in prerequisites:
                if val[0] in in_degree.keys():
                    in_degree[val[0]] =in_degree[val[0]]+1
                    
        #Keep a queue to process the course and then decrease the indegree 
        # of the next course        
        queue=[]
        for key in in_degree.keys():
            if in_degree[key] ==0:
                queue.append(key)
        # if the initial indegree is zero, then we can begin from the course
        # else we can't start the process.
        if len(queue) == 0:
            return False
        
        while len(queue)!=0:
            #pop course to finish
            v=queue.pop(0)
            #degree dependence of in_degree having this course by 1
            for val in prerequisites:
                    if val[1] == v:
                        in_degree[val[0]]=in_degree[val[0]]-1
                        
                        if in_degree[val[0]] == 0 and val[0] not in queue:
                            queue.append(val[0])
                            
        if max(in_degree.values())  ==0:
            return True
        else:
            return False
        
                            
        
