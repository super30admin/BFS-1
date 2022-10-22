class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj_list = collections.defaultdict(list)
        indegrees = numCourses * [0]
        completed_courses = 0
        
        if numCourses == 0:
            return True
        
        queue = collections.deque()
        
        for prereq in prerequisites:
            inc = prereq[0] # incoming edge (dependent course)
            out = prereq[1] # outgoing edge (independent course)
            
            adj_list[out].append(inc)
            indegrees[inc] += 1
        
        
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)
                completed_courses += 1

        
        while queue:
            vertex = queue.popleft()
            edges = adj_list[vertex]
            
            for edge in edges:
                indegrees[edge] -= 1
                if indegrees[edge] == 0:
                    completed_courses += 1
                    queue.append(edge)
                    
        return completed_courses == numCourses
        
        
# SPECIFICALLY USE DEFAULT DICTIONARY FOR THIS QUESTION
# Time Complexity: O(V + E) Vertex and Edges
# Space Complexity: O(V + E)