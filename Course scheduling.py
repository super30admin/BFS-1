# TC-O(V+E)
# SC-O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 1 or numCourses == 0:
            return True

        hashmap = {}
        indegree = [0] * numCourses
        q = deque()
        for course, pre in prerequisites:
            if pre not in hashmap:
                hashmap[pre] = []
            hashmap[pre].append(course)
            indegree[course] += 1

        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)

        while (q):
            course = q.popleft()
            if course in hashmap:
                for ele in hashmap[course]:
                    indegree[ele] -= 1
                    if indegree[ele] == 0:
                        q.append(ele)
        for num in (indegree):
            if num != 0:
                return False
        return True