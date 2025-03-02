#  Time Complexity : O(V + E)
#  Space Complexity : O(V + E)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Built an adjacency list map to track course dependencies and an in-degree array degree to count how many prerequisites each course has. Then, I used a queue to process courses with zero prerequisites first, decrementing dependencies for subsequent courses, and returned True if all courses could be completed  i.e. all degrees became zero.

from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        degree = [0] * numCourses
        map = defaultdict(list)
        queue = deque()

        for i in prerequisites:
            degree[i[0]] += 1
            map[i[1]].append(i[0])
        
        for i in range(numCourses):
            if degree[i] == 0:
                queue.append(i)
        
        while queue:
            course = queue.popleft()

            for child in map[course]:
                degree[child] -= 1
                if degree[child] == 0:
                    queue.append(child)

        return all(j == 0 for j in degree)