#Time Complexity:O(n)
#Space Complexity:O(2n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dict={}                                             #Declaring a hash map
        indegrees=[0 for i in range(numCourses)]            # declaring an array of length numCourses
        for course in prerequisites :                       #for every prereq updating its future courses as values in hash
            if course[1] not in dict:                       
                dict[course[1]]=[]
            dict[course[1]].append(course[0])               
            indegrees[course[0]]+=1                         #increment the number of prereqs for each course at its index in indegree
        d=deque()                                           #declaring a queue
        for i in range(numCourses):                         # for every course 
            if indegrees[i]==0:                             #if the course does not require prereqs
                d.append(i)                                 #append to queue
        if len(d)==0:                                       #if the queue is empty return false
            return False
        count=0                                             #declare a count variable
        while(d):                                           #while the queue is not empty
            curr=d.popleft()                                # pop the leftmost element as current
            if curr in dict:                                # if the current element is in has map
                edge=dict[curr]                             #obtain all its dependent courses
            else:
                edge=[]
            count+=1                                        #increment count of course completed by one
            if edge:                                        #while edge is not null
                for j in edge:                              #for every subject that is dependent on current course
                    indegrees[j]-=1                         # decrement its prereq value in indegree by one
                    if indegrees[j]==0:                     #if prereques is zero
                        d.append(j)                         #append into the queu the course
        if count==numCourses:                               # if the count of completed courses is same as numCourses return true else false
            return True
        return False