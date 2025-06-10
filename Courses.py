# Time Complexity: O(V+E) where V is the number of courses and E is the number of prerequisites
# Space Complexity: O(V+E)for the adjacency list and in-degree array

# Topological Sorting with BFS
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Create in-degree array and adjacency list (map)
        in_degree = [0] * numCourses
        graph = defaultdict(list)

        for dest, src in prerequisites:
            in_degree[dest] += 1
            graph[src].append(dest)

        # Add all courses with 0 in-degree to the queue
        q = deque()
        for i in range(numCourses):
            if in_degree[i] == 0:
                q.append(i)

        # Process nodes in topological order
        while q:
            course = q.popleft()
            for neighbor in graph[course]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    q.append(neighbor)

        # Check if all courses were completed (all in-degrees are 0)
        return all(degree == 0 for degree in in_degree)