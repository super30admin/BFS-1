'''
// Time Complexity : 0(n) -- indegrees, adjacencyList and queue
// Space Complexity : 0(n) -- indegrees, adjacencyList and queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
from collections import deque

class Solution:
    
    def indegreesList(self,prerequisites):

        # Create indegrees
        indegrees = {}
        
        # Step 1: fill-up the indegrees
        for edge in prerequisites:
            
            # Check for dependents
            if edge[0] not in indegrees:
                indegrees[edge[0]] = 1
            else:
                indegrees[edge[0]] = indegrees[edge[0]] + 1
            
            # Check for independents
            if edge[1] not in indegrees:
                indegrees[edge[1]] = 0
        
        return indegrees
    
    def adjacencyList(self,prerequisites):
        
        # Step 2: Create adjacencyList
        adjacencyList = {}
        
        # fill-up the adjacencyList
        for edge in prerequisites:
            
            # Check for independents
            if edge[1] not in adjacencyList:
                adjacencyList[edge[1]] = []
            
            adjacencyList[edge[1]].append(edge[0])
        
        return adjacencyList
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # base case
        if len(prerequisites) == 0:
            return True
        
        # Step 1: fill-up the indegrees
        indegrees = self.indegreesList(prerequisites)
        #print('1. Indegrees List is:\t', indegrees)
        
        # Step 2: fill-up the adjacencyList
        adjacencyList = self.adjacencyList(prerequisites)
        #print('2. Adjacency List is:\t', adjacencyList)
        
        # Declaring queue 
        queue = deque([])
        
        # Step 3: Pick up independent key from indegree 
        for key in indegrees:
            
            if indegrees[key] == 0:
                queue.append(key)
                # Reduce my course count
                numCourses -= 1
                
                if numCourses == 0:
                    # We have to do only specific no of course
                    return True
        
        # Step 4: intialize a deque and perform bfs traversal
        
        # Iterate the queue
        while len(queue) != 0:
            # Pop from the queue
            ele = queue.popleft()
            
            # Decrease the couses count
            numCourses -= 1
            
            if numCourses == 0:
                # We have to do only specific no of course
                return True
            
            # Go-to adjacencyList
            if ele in adjacencyList:
                dependents = adjacencyList[ele]
                
                # Iterate dependents and reduce indegrees value by 1
                for d in dependents:
                    indegrees[d] = indegrees[d] - 1
                    
                    if indegrees[d] == 0:
                        # Append the d to the queue
                        queue.append(d)
        
            # continue the popping process
            continue
        
        #print('3. numCourses is:\t',numCourses)
        if numCourses <= 0:
            return True
        else:
            return False
            
        