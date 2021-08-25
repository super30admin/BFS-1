# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
from collections import defaultdict
def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    graph = defaultdict(set)

    # Maintain in_degree array to find next courses to take
    in_degree = [0 for _ in range(numCourses)]

    # Create the adjacency list from the prerequisites array
    for t, f in prerequisites:
        graph[f].add(t)
        in_degree[t] += 1
    
    q = []
    for t in range(numCourses):
        if in_degree[t] == 0:
            q.append(t)
    
    # Maintain the count of courses taken
    count = 0
    while q:
        new_q = []
        
        for taken in q:
            count += 1
            
            # Modify the in_degree array to reflect the courses taken, to infer new courses that can be taken
            for depends in graph[taken]:
                in_degree[depends] -= 1
                if in_degree[depends] == 0:
                    new_q.append(depends)
        q = new_q   
    return count == numCourses