# leetcode: ACCEPTED
# Idea: It is like a Directed Graph, If there is cycle in the graph, then courses cannot be taken. Using DFS and keeping tracking of nodes which are visited or were there in recursion stack, we can find the cycle in the graph

# time complexity:O(n)


from collections import defaultdict


class Solution:
    def __init__(self):
        self.graph = defaultdict(list)
        self.visited = None
        self.recStack = None

    def createGraph(self, prerequisites):
        for v, u in prerequisites:
            print(v, u)
            if v in self.graph.keys():
                self.graph[v].append(u)
            else:
                self.graph[v] = [u]
            print(self.graph)

    def isCycle(self, node):
        self.visited[node] = True
        self.recStack[node] = True
        for neighbour in self.graph[node]:
            if self.visited[neighbour] == False:
                if self.isCycle(neighbour) == True:
                    return True
            else:
                if self.recStack[neighbour] == True:
                    return True
        self.recStack[node] = False
        return False

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.createGraph(prerequisites)  # creating a adjaceny lst
        self.visited = [False] * numCourses
        self.recStack = [False] * numCourses
        for course in range(numCourses):
            if self.visited[course] == False:
                if self.isCycle(course):
                    return False
        return True