class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        Maintain path and visited boolean array and use recursion with baktracking in dfs manner; if any node appears in path again that means that path has been followed so there's a cycle present. We push and pop elements from the path. If a node is visited it does not have a cycle.
        TC- O(v+e) - where v is the number of courses and e is the number of dependencies
        Sc- O(v+e)
        """
        def hascycle(course):
            nonlocal hashmap
            nonlocal path
            nonlocal visited
            ###base case
            """
            If I reach a course which is already  inside the path or already visited
            """
            # print(course)
            if path[course] is True:
                return True  ##here is a cycle
            if visited[course] is True:
                return False  ## i have already visited it and there's no cycle
            ##logic below
            visited[course] = True

            ###action below
            path[course] = True

            ###recursion below
            """
            we have multiple babies over here since this is a graph so we get a list of 
            all the dependent children 
            """
            # children=hashmap[course]
            children = hashmap.get(course)
            ###remember in some cases children can be None
            if children is not None:
                for child in children:
                    if hascycle(child):
                        return True
                        ###backtrack
            path[course] = False
            return False

        hashmap = {}
        path = [False] * numCourses
        visited = [False] * numCourses
        for edge in prerequisites:
            if edge[1] not in hashmap:
                hashmap[edge[1]] = [edge[0]]
            else:
                hashmap[edge[1]].append(edge[0])
        for i in range(numCourses):
            if not visited[i] and hascycle(i):
                ###the graph has cycle
                return False
        return True

# """
# https://leetcode.com/problems/course-schedule/
# We will make use of three different data structures like an indegree array of datatype list, adjacency matrix, and using deque for
# search.
# TC: O(n)
# Sc:O(n)
#
# """
#
# import collections
# class Solution:
#     def canFinish(self, numCourses, prerequisites):
#         indegreesArray=[]
#         adjacencyMatrix = dict()
#
#         for edge in prerequisites:
#             indegreesArray[edge[0]]+=1 ##node dependent on something
#             if not edge[1] in adjacencyMatrix:
#                 # adjacencyMatrix[edge[1]]=[edge[0]]
#                 adjacencyMatrix[edge[1]].append([edge[0]]) ####adding dependepnt values on independent keys
#
#         deQ=collections.deque()
#         count=0
#         ###now adding independent nodes
#         for i in range(len(indegreesArray)):
#             if indegreesArray[i]==0: ##if the node is not dependent on any node
#                 deQ.appendleft(i)
#                 count+=1
#         ###BFS
#         while not len(deQ) == 0:
#             currentCourse=deQ.popleft()
#             ###take all the courses which were dependent on this course
#             children=adjacencyMatrix.get(currentCourse)
#             if children!=None:
#                 for child in children:
#                     indegreesArray[child]-=1
#                     if indegreesArray[child]==0:
#                         deQ.appendleft(child)
#                         count+=1
#
#
#         return count==numCourses
#
#
# numCourses = 2
# prerequisites = [[1, 0]]
#
#
