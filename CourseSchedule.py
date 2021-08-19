"""
Time Complexity : O(n) n = Edge + Vertex
Space Complexity : O(n) n = Edge + Vertex
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Create a node which has all the out nodes and inDegrees
class Node(object):
    def __init__(self):
        self.inDegrees = 0
        self.outNodes = []
from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(Node)
        count = 0
        # Creating a dictionary with the vertex and its corresponding course 
        # and updating the inDegrees
        for rel in prerequisites:
            nextC, prevC = rel[0], rel[1]
            graph[prevC].outNodes.append(nextC)
            graph[nextC].inDegrees += 1
            count += 1
        # Creating a queue and adding the values that already have inDegrees 0
        q = deque()
        for k, v in graph.items():
            if v.inDegrees == 0:
                q.append(k)
        # Count variable to main the pop count
        remove = 0
        # Traverse through the elements in the queue and adding the one's whose
        # inDegree is 0, updating the count 
        while q:
            course = q.pop()
            for nextC in graph[course].outNodes:
                graph[nextC].inDegrees -= 1
                remove += 1
                
                if graph[nextC].inDegrees == 0:
                    q.append(nextC)
        # If my count of courses is equal to the one's we removed from queue
        # we return True else False
        if remove == count:
            return True
        else:
            return False
            
        