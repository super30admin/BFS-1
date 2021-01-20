class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        '''
        Complexity:
        Time: O(V+E)
        Space: O(V+E)
        '''
        # find cycle in the graph, if there is a cycle then no else yes
        
        # topological sort
        # create indegree array
        
        # O(V) operation
        indegree = [0 for i in range(0,numCourses)]
        x = {i:[] for i in range(0,numCourses)}
        # O(E) operation
        for i in range(0,len(prerequisites)):
            f,t = prerequisites[i]
            indegree[t] += 1
            if(f in x.keys()):
                x[f].append(t)
            else:
                x[f] = [t]
        # queue
        q = deque()
        rem = 0
        for i in range(0,len(indegree)):
            if(indegree[i]==0):
                q.append(i)
                rem +=1
                # we dont need this as we dont see the element
                #indegree[i] = -1
        
        
        while(len(q)>0):
            n = q.pop()
            for i in x[n]:
                indegree[i] -= 1
                if(indegree[i]==0):
                    q.append(i)
                    rem +=1
                    #indegree[i] = -1
            
        if(rem==numCourses):
            return True
        else:
            return False
        
