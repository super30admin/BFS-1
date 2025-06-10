
# // Time Complexity :O(V+E)
# // Space Complexity :O(V+E)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach 
# Start with course that need 0 preq then dec count of courses that need this course as preq by 1 do same process untill end

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        d=dict()
        preCount=[0 for i in range(numCourses)]
        for i in prerequisites:
            #[a,b]--> preq is b 
            preCount[i[0]]+=1
            if i[1] in d:
                d[i[1]].append(i[0])
            else:
                d[i[1]]=[i[0]]

        
        q=deque() #this is queue FIFO
         #get starting course preCount[i]==0
        completedCourses=0
        for i in range(len(preCount)):
            if preCount[i]==0:
                q.append(i) #might be more than one starting course
                completedCourses+=1
        # print(q)
        while( len(q)>0):
            currCourse=q.popleft()
            if currCourse  in d: 
                for i in d[currCourse]: #will get key error if current course in not in d
                    preCount[i]-=1
                    if preCount[i]==0:
                        q.append(i)
                        completedCourses+=1
        # print(preCount)
        
        return completedCourses==numCourses
        





           



        
