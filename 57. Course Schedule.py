from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        map, children = [set() for i in range(numCourses)],[set() for i in range(numCourses)]

        for edge in prerequisites:
            map[edge[0]].add(edge[1])
            children[edge[1]].add(edge[0])

        q = deque()
        count = 0

        for i in range(numCourses):
            if len(map[i]) == 0:
                q.append(i)
                count += 1

        while q:
            current = q.popleft()
            for j in children[current]:
                if current in map[j]:
                    map[j].remove(current)
                    if len(map[j]) == 0:
                        q.append(j)
                        count += 1
        return  count == numCourses


