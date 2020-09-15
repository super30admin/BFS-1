# S30 Big N Problem #56 {Medium}

# LC - 207. 
# Course Schedule

# Time Complexity : O(n+m) n=no. of courses,m=no of prerequisites
# Space Complexity : O(n+m) n=no. of courses,m=no of prerequisites
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        
        courses=[0]*numCourses
        
        dic={}
        
        for x,y in prerequisites:
            
            courses[x]+=1
            
            if dic.get(y,-1)==-1:
                dic[y]=[]
                dic[y].append(x)
            else:
                dic[y].append(x)
        root=None
        stack=[]
        for i in range(0,len(courses),1):
            if courses[i]==0:
                stack.append(i)
                                              
        while stack:
            
            element=stack.pop(0)
                        
            if dic.get(element,-1)!=-1:
            
                for i in dic[element]:
                    
                    courses[i]-=1
                    if courses[i]==0:
                        stack.append(i)
                        
        for i in courses:
            
            if i!=0:
                return False
        
        return True
        
            
            
        
        
        