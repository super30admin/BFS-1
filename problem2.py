"""
Time Complexity : O(v+e) where v is the number of vertices and e is the total number of edges.
Space Complexity : O(v+e) where v is the number of vertices and e is the total number of edges.

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
create a indegree array and adjacency list such that the key of the adjacency list will be independent course and values will be the dependent courses.
Initially, add all the elements which has indegree 0 to the queue.
pop the elements from the queue, degrees the indgree count the popped element's dependent courses.
If the indgree of the dependent courses of the course which has been popped from the recursive stack is 0, then add those to the queue.
If the number of elements put in queue are equal to the number of courses then return True otherwise False.
"""
from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, edges: List[List[int]]) -> bool:
        if edges == 0:
            return True
        indegree = [0 for i in range(numCourses)]
        adjacencyList = {}
        count = 0
        
        #Create indegree list and Adjacency List
        for edge in edges:
            if edge[1] not in adjacencyList.keys():
                adjacencyList[edge[1]] = []

            temp = adjacencyList[edge[1]]
            temp.append(edge[0])
            adjacencyList[edge[1]] = temp
            indegree[edge[0]] = indegree[edge[0]] + 1

        q = Queue()
        
        #Add all the independent elements to the queue
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.put(i)
                count += 1
        
        if count == numCourses:
            return True
        #Perfrom BFS
        while(q.empty() != True):
            curr = q.get()
            if curr in adjacencyList.keys():
                children = adjacencyList[curr]
                if children:
                    for child in children:
                        indegree[child] = indegree[child] - 1
                        if indegree[child] == 0:
                            q.put(child)
                            count += 1
                        if count == numCourses:
                            return True
        return False