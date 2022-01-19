# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Deque, List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # dependency array
        indegree = [0] * numCourses

        # hasmap as an adjacency list
        hashmap = {}

        # base
        if len(prerequisites) == 0:
            return True

        # increment the dependencies in the dependency array if any
        for i in prerequisites:
            indegree[i[0]] = indegree[i[0]] + 1

            # if any node already present in the hashmap append the new dependent edge to existing one
            if i[1] in hashmap.keys():
                hashmap[i[1]].append(i[0])
            else:
                hashmap[i[1]] = [i[0]]

        q = Deque()
        count = 0  # keeping a count to check if all the nodes in the dependency array are checked

        for i in range(len(indegree)):
            # if the number of dependencies of a node is 0 append that particular node to the queue q
            if indegree[i] == 0:
                q.append(i)
                count = count + 1  # then increment the count

        if len(q) == 0:
            return False

        while q:
            curr = q.popleft()

            if curr in hashmap.keys():
                li = hashmap[curr]

                # reducing the dependencies of courses which were dependent on current course
                if len(li) > 0:
                    for i in range(len(li)):
                        indegree[li[i]] = indegree[li[i]] - 1

                        if indegree[li[i]] == 0:
                            q.append(li[i])
                            count = count + 1

        # if all the course are done then return true or else false
        if count == numCourses:
            return True

        else:
            return False
