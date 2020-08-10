"""
Problem:
https://leetcode.com/problems/course-schedule/

Approach: 


1. crete a map with vertex as course labels and value as list of child courses 
2. create a list called inOrder list which keeps track of the count of parent courses of a perticular course 
3. Maintain a que where we initially put the independnetn courses which can be taken
4. once we pop element from the queue(course is taken) then we reduce the count from the inOrder list, and if the count becomes 0 we put that course in the que
5. in the end, check if the inOrder list contians all 0s, if yes then return True else False

"""

# Time Complexity : O(no courses + no of prereq array) , similar to O(v+E) in case of graph
# Space Complexity : O(no courses + no of prereq array)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites==None or len(prerequisites)==0:
            return True
        
        count = 0
        
        inDegree = [0]*numCourses
        map1 = {}
        bfsQue = deque()
        
        for edge in prerequisites:
            inDegree[edge[0]]+=1
            
            if edge[1] not in map1:
                map1[edge[1]]=[]
            map1[edge[1]].append(edge[0])
        
        for i in range(len(inDegree)):
            if inDegree[i]==0:
                bfsQue.append(i)
        
        if len(bfsQue)==0:
            return False
        
        while(bfsQue):
            popped = bfsQue.popleft()
            childrenOfPopped = map1.get(popped)
            if childrenOfPopped!=None:
                for child in childrenOfPopped:
                    inDegree[child]-=1
                    if(inDegree[child]==0):
                        bfsQue.append(child)
         
        # check if indegree is all 0s or not
        for i in range(len(inDegree)):
            if inDegree[i]>0:
                return False
        
        return True