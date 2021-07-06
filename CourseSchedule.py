# time complexity: O(E + V) V is the number of courses, and E is the number of dependencies.
# space complexity: O(E + V)

from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dep_map = {}
        dep_list = [0] * numCourses

        for li in prerequisites:
            node = li[0]
            dep = li[1]
            list_map = []
            if dep not in dep_map:
                list_map.append(node)
                dep_map.update({dep: list_map})
            else:
                dep_map[dep] = dep_map.get(dep).append(node)
            dep_list[node] += 1
        print(dep_map)

        q = deque()

        for i in range(len(dep_list)):
            if dep_list[i] == 0:
                q.append(i)
        count = 0
        while q:
            curr = q.popleft()
            count += 1
            child = dep_map.get(curr)
            if child != None:
                for li in child:
                    dep_list[li] -= 1
                    if dep_list[li] == 0:
                        q.append(li)

        if count == numCourses:
            return True

