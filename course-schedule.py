# Time Complexity:O(V+E)
# Space Complexity:O(V+E)
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # If length is null or there are no elements in prerequisites, return True
        if len(prerequisites) == 0 or prerequisites == None:
            return True
        
        # Define an indegrees array with length as the numCourses
        # Define a dictionary to create adjacency list
        indegrees = [0]*numCourses
        d = {i:[] for i in range(numCourses)} 
        
        # create the indegrees array with the number of prerequisites
        for prerequisite in prerequisites:
            indeg = prerequisite[0]
            out = prerequisite[1]
            indegrees[indeg] += 1
            # Create the adjacency matrix by appending to the empty lists
            if out in d:
                d[out].append(indeg)
        
        # Create a queue
        # Append all the independent nodes whose indegree is zero
        q = deque([])
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
                
        # If queue is empty, return false        
        if len(q) == 0:
            return False
        # If queue exists, pop the left most element and increase count by 1
        # Get the children from the dictionary
        # Decrease the indegree count for every child explored
        # If it is independent, append to the queue
        count = 0
        while q:
            curr = q.popleft()
            count += 1
            if d[curr]:
                for child in d[curr]:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)
                        
        # If the numCourses is equal to the count, return true else false
        if count == numCourses:
            return True
        return False
            
            
        
        
        