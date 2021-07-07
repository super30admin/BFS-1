#Leetcode -207
# Time complexity -
#Space complexity -
from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        degrees = [0 for i in range(numCourses)]
        q=deque()
        for i in range(len(prerequisites)):  #making indegree array
            degrees[prerequisites[i][0]]+=1
        for i in range(len(degrees)): #appending all the elements that have no prerequisites
            if degrees[i]==0:
                q.append(i)
        while q: #
            course=q.popleft() #popping the queue and appending courses which depened on these courses
            for i in range(len(prerequisites)):
                if prerequisites[i][1]==course:
                    degrees[prerequisites[i][0]]-=1
                    if degrees[prerequisites[i][0]]==0:
                        q.append(prerequisites[i][0])
        for i in range(len(degrees)): # checking if all the indegrees are met
            if degrees[i]!=0:
                return False
        return True