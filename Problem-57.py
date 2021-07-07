#Course Schedule -207
# Time complexity -
#Space complexity -

# Approach - Using BFS approach, first we need to create indegree array for all the courses that need prereq
# 2) We will start BFS for the courses which doesn't have any prereq
#3) Then we start every element from queue and process it one by one.
# example [4,0] - to take course 4 we need to complete prereq 0


from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prereq):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegree=[0]*numCourses
        q=deque()
        # making indegree array
        for i in range(len(prereq)):
            indegree[prereq[i][0]]+=1
        #using bfs approach we process the elements  which doesn't have any prereq
        for i in range(len(indegree)):
            if indegree[i]==0:
                q.append(i)
        while q:
            course=q.popleft()
            for i in range(len(prereq)):
                if prereq[i][1]==course:
                    indegree[prereq[i][0]]-=1
                    if indegree[prereq[i][0]]==0:
                        q.append(prereq[i][0])
        for i in range(len(indegree)):
            if indegree[i]!=0:
                return False
        return True
