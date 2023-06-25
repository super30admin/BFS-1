#Time Complexity is:
#Space complexity is:
#Code ran successfully on leetcode
#Found no issues while coding

import collections
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        #we will be checking the length of prerequisites and returning true if it is empty or null
        if(prerequisites==None or len(prerequisites)==0):
            return True
        #Creating an hashmap to store independent nodes as keys and dependent nodes as values
        map_dic={}
        #Creating an indegrres array to note the incoming edges to a node
        indegrees=[0 for i in range(0,numCourses)]
        #We will be going through the prerequisites and we will be updating map_dic{} and indegrees array
        for i in prerequisites:
            indegrees[i[0]]+=1
            if(i[1] not in map_dic):
                map_dic[i[1]]=[]
            map_dic[i[1]].append(i[0])
        #Creating a queue
        q=collections.deque()
        count=0
        #We will be going through indegrees and we will be appending all the indexes which have 0 as values
        #We will be incrementing count value
        for i in range(0,numCourses):
            if(indegrees[i]==0):
                q.append(i)
                count+=1
              
        while(len(q)):
            #We will be popping values from the queue
            curr=q.popleft()
            #If curr is an independent node
            if(curr in map_dic):
                #We will be finfing the children of the curr in map_dic{}
                children=map_dic[curr]
                for i in children:
                    #We will be reducing the value for the children in indegrees
                    indegrees[i]-=1
                    #If indegrees of a particular child is 0, we will add that to the queue
                    if(indegrees[i]==0):
                        q.append(i)
                        count+=1
                        #If the count equals to the no of courses, we will return True
                        if(count==numCourses):
                            return True
        return False