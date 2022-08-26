'''
Time Complexity - O(V+E) where V is number of courses and E is the dependency between them
Space Complexity - O(V+E)
'''


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == []:
            return True
        mapping = defaultdict(list)
        indegrees = [0] * numCourses

        for i in prerequisites:
            indegrees[i[0]] += 1
            if i[1] not in mapping:
                mapping[i[1]].append(i[0])
            else:
                mapping.get(i[1]).append(i[0])

        q = deque()
        count = 0

        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
            if q == None and count == 0:
                return False
        while q:
            course = q.popleft()
            child = mapping.get(course)
            if child:
                for j in child:
                    indegrees[j] -= 1
                    if indegrees[j] == 0:
                        q.append(j)
                        count += 1
                    if count == numCourses:
                        return True

        return False
