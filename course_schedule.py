# Using BFS - Topological Sort
"""
[a, b] --> take course b if you want to take course a. 
[course, pre_req_course]
[dependent, independent_course]
Create a map of {independent_courses :[dependent_courses]}, as the Topological sort approach is starting from independent course and then going to dependent courses from it to be able to finish all courses
Also, we will have an indegree_map, which helps with the track of indegrees for each node, only when the indegree becomes 1, we can visit the node.
TC - O(V+E), where V is number of vertices, which are numCourses here, and E is number of edges which is the length of the prerequisites list.
SC - O(V+E) --> storing all the nodes and their edges in HashMap, and also storing the count of indegrees in indegree_map.
"""
from collections import deque, defaultdict
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courses_taken = 0
        #Create a map of independent : [dependent nodes]
        adj_map = defaultdict(list)
        for course, pre_req in prerequisites:
            adj_map[pre_req].append(course)

        #Create indegree map
        indegree_map = {key:0 for key in range(0,numCourses)}
        for course, pre_req in prerequisites:
            indegree_map[course]= indegree_map.get(course, 0) + 1
        
        q = deque()
        for key, val in indegree_map.items():
            if not val:
                q.append(key)
        if not q:
            return False
        while q:
            pop_node = q.popleft()
            courses_taken += 1
            for node in adj_map[pop_node]:
                if indegree_map[node] == 1:
                    q.append(node)
                    indegree_map[node] -= 1
                if indegree_map[node] > 1:
                    indegree_map[node] -= 1
        
        if courses_taken != numCourses:
            return False
        return True

#Using DFS to find a cycle using visited
"""
Use DFS to see if there is a cycle in dependencies. 
1. Create a Adjacency Map, for all the prerequisite courses for each course in range(numCourses). {course_no: pre_req_list}
2. Iterate over numCourses and call dfs(i)
3. For each course, iterate over its pre_req_list
4. If the pre_req_course is already in visited, then false, if None then true, other wise, iterate over the pre_req's pre_req_list and so on.. Depth wise. 
5. Before iterating add the course into the visited set.
6. After iterating over the pre_req_list, if dfs(pre_req) returned Negative, then return False, otherwise, make the pre_req_list of that course as empty[](meaning no cycles for all the pre_reqs). 
7. Also remove the node from visited. And Return True
8. For step2, if any dfs(i) returns False, return False, else keep iterating and in the end return True. 
9. We need this for loop for all courses to capture the not connected components in the graph as well. 
10. TC - O(n+p), visited all the nodes and edges, nodes is the numCourses, and edges is pre_reqs
11. SC - O(N) [visited] + O(N) [recursion stack space]
"""
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        #1. Create a Adjacency Map, for all the prerequisite courses for each course in range(numCourses). {course_no: pre_req_list}
        preMap = {i:[] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)

        visited = set()
        def dfs(crs):
            #4. If the pre_req_course is already in visited, then false, if None then true
            if crs in visited:
                return False
            if not preMap[crs]:
                return True
            
            #5. Before iterating add the course into the visited set.
            visited.add(crs)
           
            #3. For each course, iterate over its pre_req_list
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False
            
            #6. After iterating over the pre_req_list, if dfs(pre_req) returned Negative, then return False, otherwise, make the pre_req_list of that course as empty[](meaning no cycles for all the pre_reqs). 
            #7. Also remove the node from visited. And Return True

            preMap[crs] = []
            visited.remove(crs)
            return True

        #2. Iterate over numCourses and call dfs(i)
        for crs in range(numCourses):
            visited = set()
            #8. For step2, if any dfs(i) returns False, return False, else keep iterating and in the end return True. 
            if not dfs(crs):
                return False
        return True