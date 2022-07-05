class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        '''Time Complexity: O(V+E)
        Space Complexity: O(V)
        '''
        #Edge Case
        if len(prerequisites) == 0:
            return True
        
        #Create Hashmap for storing all the independent:dependents
        hashmap=dict()
        
        #Update the number of inward edges for every node (Number of dependencies)
        indegree=[0 for i in range(numCourses)]
        for edge in prerequisites: #O(E) --> Number of edges/ dependencies
            indegree[edge[0]]+=1
            if edge[1] not in hashmap:
                hashmap[edge[1]]=[]
            hashmap[edge[1]].append(edge[0])
            
        #Maintaining a queue
        queue=deque()
        count=0
        #Put into queue the courses that has indegree as 0
        for i in range(numCourses):
            if indegree[i]==0:
                queue.append(i)
                count+=1
        #Process all the nodes     
        #BFS
        while len(queue)!=0:
            curr=queue.popleft()
            print(curr)
            #reduce indgrees
            if curr in hashmap:
                dependents=hashmap[curr]
            else:
                dependents=[]
            if len(dependents)!=0:
                for course in dependents:
                    indegree[course] -=1
                    if indegree[course]==0:
                        queue.append(course)
                        count+=1
                        if count==numCourses:
                            return True
        return False
        
            
        
