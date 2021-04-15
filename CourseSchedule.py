from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # Time Complexity is O(n), 
        # Space Complexity is O(n),where n is the numCourses
        # Topological Sort Aproach
        # We start with the course with no prerequisites and visit all other
        # nodes as we clear prerequisites
        graph = {}
        
        for i in range(numCourses):
            graph[i]=[]
        
        numDegree = [0]*numCourses
        for c1,c2 in prerequisites:
            graph[c2].append(c1)
            numDegree[c1]+=1
        
        q = deque()
        
        for i in range(len(numDegree)):
            if(numDegree[i] == 0):
                q.append(i)
        
        
        count = 0
        while(q):
            curr = q.popleft()
            count+=1
            for course in graph[curr]:
                #print(numDegree,course)
                numDegree[course]-=1
                if(numDegree[course] == 0):
                    q.append(course)
        
        if(count == numCourses):
            return True
        return False