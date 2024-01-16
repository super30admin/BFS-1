#Time Complexity :O(V+E), where V is the number of courses and E is the number of prerequisites
#Space Complexity :O(V+E)
#Did this code successfully run on Leetcode :yes


from ast import List
from collections import defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degree = defaultdict(set)
        out_degree = defaultdict(set)

        for i, j in prerequisites:
            out_degree[j].add(i)
            in_degree[i].add(j)

        connection_removed = 0
        in_degree_zero = []

        for x in range(numCourses) :
            if not in_degree[x]:
                in_degree_zero.append(x)
                connection_removed += 1
        while in_degree_zero:
            node = in_degree_zero.pop()
            for y in out_degree[node]:
                in_degree[y].remove(node)
                if not in_degree[y]:
                    in_degree_zero.append(y)
                    connection_removed += 1
        return connection_removed == numCourses


        