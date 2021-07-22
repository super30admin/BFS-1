from collections import deque
from collections import defaultdict


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        queue = deque()
        premap = defaultdict(list)
        countmap = {}
        count = 0

        for p in prerequisites:

            pre = p[1]
            c = p[0]

            premap[pre].append(c)
            # if pre in premap:
            #     premap[pre].append(c)
            # else:
            #     premap[pre] = [c]

            if c in countmap:
                countmap[c] += 1
            else:
                countmap[c] = 1

        for i in range(numCourses):
            if i not in countmap:
                queue.append(i)

        # print(countmap)
        # print(premap)
        if len(queue) == 0:
            return False

        while len(queue) != 0:
            node = queue.popleft()
            count += 1
            # print(node)

            if node in premap:
                course_list = premap[node]

                for c in course_list:
                    countmap[c] -= 1
                    if countmap[c] == 0:
                        queue.append(c)

        if count == numCourses:
            return True

        return False





