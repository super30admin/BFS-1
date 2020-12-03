# Topological Sort
# Time complexity - O(V + 2E)
# Space complexity - O(2V+2E) # for nodes_q, visited, outgoing, incoming 
# Did this solution run on leetcode? - yes
from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:                
        # maintain indegree and outgoing nodes hashmap.
        outgoing, indegree = defaultdict(list), defaultdict(lambda: 0)
        total_edges = 0
        for node_pair in prerequisites:     # Time - O(E) edges
            node1, node2 = node_pair
            indegree[node1] += 1
            outgoing[node2].append(node1)
            total_edges+=1
        
        visited = [False] * numCourses
        nodes_q = deque()
        for course in range(numCourses):        # O(V)
            if indegree[course]==0:
                nodes_q.append(course)
        
        while nodes_q:                          # O(E+V)
            node = nodes_q.popleft()
            if visited[node]:                   # check if the node has been visited before.
                return False
            visited[node]=True                  # mark as visited
            # continue if there are no outgoing nodes from the current node.
            if node not in outgoing:
                continue
            for out_node in outgoing[node]:
                indegree[out_node]-=1
                total_edges -= 1
                if indegree[out_node]==0:
                    nodes_q.append(out_node)
        
        # check if all the edges have been removed
        if total_edges:
            return False
        return True
    

# Backtracking
# Time complexity - O(E + V^2)
# Space complexity - O(V+E) 
# Did this solution run on leetcode? - yes
from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool: 
        # case when no prerequisites
        if len(prerequisites)==0:
            return True
        
        # Space - O(E)
        outgoing = defaultdict(lambda: [])
        for prereq_pair in prerequisites:                   # Time complexity - O(E)
            outgoing[prereq_pair[1]].append(prereq_pair[0])
        
        def backtrack(course):    
            # if cycle found
            if visited[course]:
                return True
            # mark as visited.
            visited[course] = True
            ret = False
            for out_course in outgoing[course]:
                ret = backtrack(out_course)
                if ret: break   # do not go ahead if loop has been found.                    
            # unmark visited
            visited[course] = False
            return ret
            
        # Space - O(V)
        visited = [False] * numCourses
        # Time - O(V^2)
        for course in range(numCourses):    # Time - O(V)
            if backtrack(course):           # Time - O(V-1)
                return False
                
        return True
                
# DFS  
# Time complexity - O(E + V)
# Space complexity - O(2V+E) # for outgoing array, visited and marked
# Did this solution run on leetcode? - yes
from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool: 
        # case when no prerequisites
        if len(prerequisites)==0:
            return True
        
        # Space - O(E)
        outgoing = defaultdict(lambda: [])
        for prereq_pair in prerequisites:                   # Time complexity - O(E)
            outgoing[prereq_pair[1]].append(prereq_pair[0])
        
        def backtrack(course): 
            # if the node has been visited and no cycle was found
            if marked[course]:
                return False
            
            # if cycle found
            if visited[course]:
                return True
            # mark as visited.
            visited[course] = True
            ret = False
            for out_course in outgoing[course]:
                ret = backtrack(out_course)
                if ret: break   # do not go ahead if loop has been found.                    
            # unmark visited
            visited[course] = False
            marked[course] = True
            return ret
            
        # Space - O(2V)
        visited = [False] * numCourses
        marked = [False] * numCourses
        # Time - O(V) visits every node only once
        for course in range(numCourses):    
            if backtrack(course):           
                return False
                
        return True
            