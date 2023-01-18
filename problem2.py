class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = {}
        order = []
        for i in range(numCourses):
            indegree[i] = 0
        for i in prerequisites:
            indegree[i[0]] += 1
        print(indegree)
        queue = collections.deque()
        for i in indegree:
            if indegree[i] == 0:
                queue.append(i)
        if len(queue) == 0:
            return False
        while queue:
            curr = queue.popleft()
            order.append(curr)
            for i in prerequisites:
                if i[1] == curr:
                    indegree[i[0]] -= 1
                    if indegree[i[0]] == 0:
                        queue.append(i[0])
        return len(order) == numCourses
        # indegree = {}
        # order = []
        # for i in range(numCourses):
        #     indegree[i] = 0
        # for i in prerequisites:
        #     indegree[i[1]] += 1
        # print(indegree)
        # queue = collections.deque()
        # for i in indegree:
        #     if indegree[i] == 0:
        #         queue.append(i)
        # if len(queue) == 0:
        #     return False
        # while queue:
        #     curr = queue.popleft()
        #     order.append(curr)
        #     for i in prerequisites:
        #         if i[0] == curr:
        #             indegree[i[1]] -= 1
        #             if indegree[i[1]] == 0:
        #                 queue.append(i[1])
        # return len(order) == numCourses