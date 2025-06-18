'''
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
'''

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# We'll use Kahn's algo to detect cycles
# steps:
# 1. build an adjacency list from b-> a
# 2. track in-degrees(how many prerequisites each course has)
# 3. add all courses with 0 prereqs(indegree=0) to queue
# 4. process queue
# 4.1. reduce indegreee of its neighbors
# 4.2 if neighbors indegree drops to 0, add to queue
# 5. if all cources are processed, return True. else, False

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 1. build graph and in-degree count
        graph = defaultdict(list)
        indegree = [0]*numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            indegree[course] += 1
        
        # 2. init queue with courses where indegree=0
        q = deque([i for i in range(numCourses) if indegree[i] == 0])
        courses_taken = 0

        # 3. process
        while q:
            curr = q.popleft()
            courses_taken += 1

            for neighbor in graph[curr]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)
        
        # 4. return true if courses_taken = numCourses
        return courses_taken == numCourses