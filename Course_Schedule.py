#Time Complexity : O(V + E)
#Space Complexity : O(V + KE)

# Yes it ran on leetcode


import queue


class Solution(object):

    def canFinish(self, numCourses, prerequisites):

        if len(prerequisites) == 0 or prerequisites == None:
            return True
        indegree = [0] * numCourses
        q = queue.Queue()

        dic = {}
        for i in range(numCourses):
            dic[i] = []

        for edge in prerequisites:
            indegree[edge[0]] += 1

            # if edge[1] not in dic:
            #     dic[edge[1]] = []

            dic[edge[1]].append(edge[0])

        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.put(i)

        while not q.empty():

            curr = q.get()

            children = dic[curr]

            if len(children) != 0:
                for child in children:
                    indegree[child] -= 1

                    if indegree[child] == 0:
                        q.put(child)

        for i in range(len(indegree)):
            if indegree[i] > 0:
                return False
        return True