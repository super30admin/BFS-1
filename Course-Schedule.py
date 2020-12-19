'''
Approach: Topological Sort
'''


from collections import deque
'''
Class Gnode holds the graph nodes.

It has the course number as node, which is unique for all objects.
innDegree shows how many prereqs are needed for that course
outNodes shows how many courses are there for which this course is a prereq 
'''

class GNode:
    def __init__(self, node):
        self.node = node
        self.inDegree = 0
        self.outNodes = []

    def __str__(self):
        return f"{self.node} : {self.inDegree}, {self.outNodes}"

    def __repr__(self):
        return f"{self.node} : {self.inDegree}, {self.outNodes}"


class Solution:
    def canFinish(self, n: int, edges: List[List[int]]) -> bool:
        # print(n, edges)
        # Make GNode objects
        gnodes = []
        for i in range(n):
            gnodes.append(GNode(i))

        # For each node, update the GNode objects.
        for edge in edges:
            course = edge[0]
            preReq = edge[1]
            gnodes[course].inDegree += 1
            gnodes[preReq].outNodes.append(course)
        # print([node for node in gnodes])

        # Make a queue and start with all nodes with 0 prereqs
        nodeps = deque()
        for node in gnodes:
            if node.inDegree == 0:
                nodeps.append(node)
        # print(nodeps)

        # While this queue has something, that node needs to be processed.
        removal = 0 # check for number of removals
        while nodeps:
            node = nodeps.popleft() # take one node out
            for outnode in node.outNodes:
                gnodes[outnode].inDegree -= 1 # remove edge from this node to its course
                removal += 1
                if gnodes[outnode].inDegree == 0: # if this course has no prereqs, add it to the queue
                    nodeps.append(gnodes[outnode])

        return removal == len(edges) # total removals should be equal to number of edges, otherwise there is a cycle