"""Approach: Using graph BFS, and Queue

TC O(V+E) - Vertices+Edges = we would visit each vertex and each edge once and only once in the worst case
SC O(V+E) - Vertices+Edges, graph adj list uses V+E storage, and indegree arr uses V, so O(E+2V)=O(V+E)"""
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # check numCourses and prerequisites for valid values
        if numCourses == 0 or len(prerequisites) == 0:
            return True
    
        # create in-degrees array and adj. list
        adj = {}
        # initiate indegree arr of size numCourses
        indegree = [0] * numCourses
        
        # for each dependent and independent course tuple in prerequisites array
        # for dependent course increase indegree by 1
        # add adj[indep] = [dep] mapping
        # meaning for each course that is dependent on some course, increase value in array by 1
        # and then in adj list dictionary, key will be course that can be taken independently and value
        # is a list of courses that are dependent on it
        for dep, indep in prerequisites:
            indegree[dep] +=1
            if indep in adj:
                adj[indep].append(dep)
            else:
                adj[indep] = [dep]

        q = deque()
        count = 0
        for i,k in enumerate(indegree):
            if k == 0:
                # Append all courses where value is 0 in the indegree arr to the queue
                q.append(i)
                # increase count by 1 to indicate you can take that course
                count += 1
        # now while q is not empty
        while q:
            # pop courses from the queue
            course = q.popleft()
            if course in adj:  # check if that course key is in adj list
                for dep in adj[course]: # if so, iterate over values and decrease indegree of each of them
                    indegree[dep] -=1
                    if indegree[dep] == 0: # if it becomes 0
                        q.append(dep)  # add it to queue
                        count += 1  # and count it towards total
        
        return count == numCourses  # if count and numCourses is equal , you took all courses