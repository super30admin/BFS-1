"""
QUESTION : 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

"""
"""
APPROACH
We first make the graph to figure out if its a graph probelem
E = [(1,0)(2,0)(3,1)(3,2)(4,1)(5,4)(5,2)]

We start from a node which has no dependencies, if there are 2 such, we start from both of them

To find out which one is the node with 0 dependencies, we maintain an array with indegrees

I = [0,1,1,2,1,2]
     0 1 2 3 4 5

Brute force -we traverse through the edges list and find the node where indegree is 0 in array 

OTHERWISE - we make an adjacency list or matrix

0 :[1,2]
1 :[3,4]
2 :[3,5]
3 :[]
4 :[5]
5 :[]

Now, we can refer to the indegree array (I) and start from the node which as zero indegree
as soon as that node is processed, we go to nodes which were dependent on that node and reduce their count in I array inorder to process them 

We shall maintain a queue to track the nodes which can be processed as and when their indegrees become 0

we maintain a count of courses passed in the queue. If that count is equal to the courses to be completed, we return true

TC O(V+E) - Vertices+Edges = we would visit each vertex and each edge once and only once in the worst case
SC O(V+E) - Vertices+Edges, graph adj list uses V+E storage, and indegree arr uses V, so O(E+2V)=O(V+E)


FAQ = 
When will it return false -  when we have interdependent courses or if we have cycles in the graph
We will not be able to add it to the queue as the dependencies will never become 0


"""
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0 or len(prerequisites)==0:
            return True
        #we create an indegree array and an adjacency list
        indegree= [0]* numCourses
        adj = {}
        
        """
        we will create a dictionary of dependencies such that for every course(key)
        we will store the list of courses which are dependent on that course
        
        """
        for dep, indep in prerequisites:
            #print(relation) 
            indegree[dep]+=1
            #print(indegree)
            
            if indep in adj: # we check if the independednt couse is already there in the adj dict
                adj[indep].append(dep) #we add the dependent course to that key
            else:
                adj[indep]=[dep]
        q = deque() 
        count = 0
        # print(adj)  
        for i,k in enumerate(indegree):
            if k==0:
                # we append all courses where value is 0 in the indegree arr to the queue
                q.append(i)
                # increase count by 1 to indicate you can take that course
                count+=1
         # now while q is not empty
        while q:
            # pop courses from the queue
            course = q.popleft()
            if course in adj: # check if that course key is in adj list
                for dep in adj[course]: # if so, iterate over values and decrease indegree of each of them
                    indegree[dep]-=1
                    if indegree[dep]==0: # if it becomes 0
                        q.append(dep) # add it to queue
                    
                        count+=1 # and count it towards total
                    
        return count == numCourses  # if count and numCourses is equal , you took all courses
        
    
                
        