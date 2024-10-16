# 207. Course Schedule
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0] * numCourses
        adj_list = {i: [] for i in range(numCourses)}
        count = 0 
        for pr in prerequisites:
            indegrees[pr[0]] += 1
            adj_list[pr[1]].append(pr[0])

        q = deque()

        for course in range(numCourses):
            if indegrees[course] == 0:
                q.append(course)

        while q:
            curr = q.popleft()
            count += 1

            for n in adj_list[curr]:
                indegrees[n] -= 1
                if indegrees[n] == 0:
                    q.append(n)
        
        return count == numCourses
       



                



        



        