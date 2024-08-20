# Time complexity = O(V+E) always
# E - total no of edges and it can never be V*E
# for a dense graph = O(E) is the time complexity
# For a sparse graph = O(V) is the time complexity
# Same for space - O(V+E)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj_list = defaultdict(list)
        in_degree = defaultdict(int)

        for a, b in prerequisites:
            adj_list[b].append(a)
            in_degree[a] += 1

        queue = deque()
        for i in range(numCourses): # dont iterate over in_degree - iterate over numcourses as adj_list may not have all elements and we will miss out on the independent courses
            if in_degree[i] == 0:
                queue.append(i)
        count = 0
        while queue:
            v = queue.popleft()
            count += 1
            for course in adj_list[v]:
                in_degree[course] -= 1
                if in_degree[course] == 0:
                    queue.append(course)
        return count == numCourses








                

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
