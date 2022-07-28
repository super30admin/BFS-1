'''
## Problem 207: Course schedule.

## Author: Neha Doiphode
## Date:   07-25-2022

## Description:
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    You are given an array prerequisites where prerequisites[i] = [ai, bi],
    indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.

## Examples:
    Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take.
                     To take course 1 you should have finished course 0. So it is possible.

    Example 2:
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
                     To take course 1 you should have finished course 0,
                     and to take course 0 you should also have finished course 1. So it is impossible.

    Example 3:
        Input: numCourses = 5, prerequisites = [[1,4],[2,4],[3,1],[3,2]]
        Output: True

## Constraints:
    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.

## Notes:
    Graph concepts:
        * Types of Graph Representations:
            - Adjecency matrix
            - Adjecency list

        * In-degrees array = array with vertices as indices and values as number of incoming edges to the node.
                    0
                /       \
               2         3
                  \   /
               |    1    |
               4    -    5

               Input array: (in, out): [[2, 0][3, 0][1, 2][1, 3][4, 2][5, 4][5, 3]]

               In-degrees:Indices                 :[0, 1, 2, 3, 4, 5] (Vertices)
                          Number of incoming edges:[0, 2, 1, 1, 1, 2] (number of dependencies on the corresponding vertex/index)

        * Adjecency list:   0: [2, 3]
                            2: [1, 4]
                            3: [1, 5]
                            4: [5]
                            1: []
                            5: []

        * Topological sort:
            1. We start from an independent node.
            2. Use in-degrees array, a queue and adjecency list.
            3. Using a queue, try to clear out in-degrees array.
               If we are able to clear the array, there is no cycle present in the graph.
               If we are NOT able to clear in-degrees array, there is cycle existing in the graph.
               Nodes are added to the queue based on the criteria that,
               if all dependencies for a vertex/in-degree array for a node is cleared.

            Definition: Topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that,
                        for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.


## Time complexity: O(V + E),   where n is number of courses.
                                To build in-degrees array, we go over all dependencies.
                                Later, For each vertex, we don't iterate upon all edges.
                                We only iterate over only few edges.
                                Hence the time complexity is V + E and NOT V * E.

                                If every vertex has edge over every other vertex, at a time,
                                we iterate over ONLY corresponding edges and not all edges.

## Space complexity: O(V + E),  For In-degrees array: Number of courses
                                For Adjecency list  : Number of courses
                                For Queue           : Number of courses
                                We store values based on number of edges per vertex.

Note: Time and space complexities are same for both BFS and DFS based approaches used.
'''

from queue import Queue
from typing import List, Optional

def get_input():
    print("Enter total number of courses: ", end = "")
    numCourses = int(input())
    print("Enter total number of prerequisite entries: ", end = "")
    numPreReqs = int(input())
    prerequisites = []
    print("Enter pairs in the format: Course number <space> Pre-requisite course number")
    for preReq in range(numPreReqs):
        print(f"Pre-requisite requirement {preReq + 1}: ", end = "")
        l = input()
        l = [int(val) for val in l.split()]
        prerequisites.append(l)
    return numCourses, prerequisites

class Solution:
    # Used in DFS based solution
    courses_map = {}
    path = []
    visisted = []
    def canFinish_BFS(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True

        # step 1:
        # Create adjecency list and indegrees array
        courses = {}
        for num in range(numCourses):
            courses[num] = []

        # step 2: Fill in adjecency list and indegrees array
        indegrees = [0] * numCourses
        for pair in prerequisites:
            if not pair[1] in courses:
                courses[pair[1]] = []
            courses[pair[1]].append(pair[0])
            indegrees[pair[0]] += 1

        # Step 3: Clear in-degrees array based on pre-requisites
        #         with the help of adjecency list and queue/BFS
        q = Queue()
        for index, node in enumerate(indegrees):
            if node == 0 :
                q.put(index)

        while not q.empty():
            node = q.get()
            depedent_nodes = courses[node]
            if len(depedent_nodes) != 0:
                for node in depedent_nodes:
                    indegrees[node] -= 1
                    if indegrees[node] == 0:
                        q.put(node)

        # Cyclic dependencies don't exist if all dependencies in indegrees are cleared out.
        return all(val == 0 for val in indegrees)

    def has_cycle(self, vertex: int):
        # base case
        if self.path[vertex] == True:
            # visiting a node that we already visited on the path.
            # that means, we have a cycle.
            return True

        # Also, there is no point in carrying out a DFS on a visited node and not found a cycle.
        if self.visited[vertex] == True:
            return False

        # logic or action
        # Mark the vertex in consideration to be on the path being taken
        self.path[vertex]    = True
        # Mark the vertext as visited
        self.visited[vertex] = True
        # Now get all edges going out from the vertex in consideration using adjecency list.
        edges = self.courses_map[vertex]

        # Now give a recursive call
        for edge in edges:
            if self.has_cycle(edge):
                return True

        # backtrack
        self.path[vertex] = False
        return False

    def canFinish_DFS(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True

        # step 1: Create path and visited arrays
        self.path    = [False] * numCourses
        self.visited = [False] * numCourses

        for num in range(numCourses):
            self.courses_map[num] = []

        # Fill in adjecency list and indegrees array
        for pair in prerequisites:
            if not pair[1] in self.courses_map:
                self.courses_map[pair[1]] = []
            self.courses_map[pair[1]].append(pair[0])


        for i in range(numCourses):
            if self.visited[i] == False and self.has_cycle(i):
                return False
        return True

# Driver code
solution = Solution()
numCourses, prerequisites = get_input()
print(f"Input: Total number of courses to be completed: {numCourses}")
print(f"Input: Pre-requisites(Course number , Pre-requisite course number): {prerequisites}")
print(f"Approach 1: Using BFS: Is it possible to complete all courses?: {solution.canFinish_BFS(numCourses, prerequisites)}")
print(f"Approach 2: Using DFS: Is it possible to complete all courses?: {solution.canFinish_DFS(numCourses, prerequisites)}")
