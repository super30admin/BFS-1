"""
//Time Complexity : O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
#The solution of BFS is not working please check

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # T.C = O(v+E)
        # S.C = O(V+E)
        if len(prerequisites)==0:
            return True
        self.path = [False]*numCourses
        self.visited = [False]*numCourses
        self.adjList = defaultdict(list)
        for edge in prerequisites:
            if edge[1] not in self.adjList:
                 self.adjList[edge[1]] = []
            self.adjList[edge[1]].append(edge[0])
        for i in range(0,numCourses):
            if( not self.visited[i] and self.hasCycle(i)):
                return False
        return True
    def hasCycle(self,i):
        #base:
        if self.path[i]:
            return True
        if self.visited[i]:
            return False
        #logic
        self.path[i] = True
        #action
        self.visited[i] = True
        edges = self.adjList[i]
        if edges!=None:
            for edge in edges:
                #RECURSIVE STEP
                if(self.hasCycle(edge)):
                    return True
        #bactrcak
        self.path[i] = False
        return False
        
        
       
        
        
        
#This solution is not working Please Let me Know     
#         from collections import defaultdict,deque
#         if len(prerequisites)==0:
#             return True
#         # indegree = [0]*numCourses
#         indegree = [2]*numCourses
#         adjList = defaultdict(list)
#         for edge in prerequisites:
#             indegree[edge[0]]+=1
#             if edge[1] not in adjList:
#                 adjList[edge[1]] = []
#             adjList[edge[1]].append(edge[0])
#         q = deque()
#         for i in range(0,numCourses):
#             if(indegree[i]==0):
#                 q.append(i)
#         if len(q)==0:
#             return False
#         cnt = 0
#         while(len(q)>0):
#             curr = q.popleft()
#             cnt+=1
#         edges = adjList.get(curr)
#         print(edges)
#         if edges!=None:
#             for edge in edges:
#                 indegree[edge]-=1
#                 if indegree[edge]==0:
#                     q.append(edge)
#         return cnt == numCourses
        
        