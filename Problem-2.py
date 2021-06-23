"""
Approach: start from independent nodes and cover each level of dependent nodes, keep track of dependencies.
At the end, if the nodes without dependencies = number of courses, return true.
TC: V + E
SC: O(V)
"""
class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:

        if not prereq:
            return 1

        ingress = [0] * numCourses
        for child, parent in prereq:
            ingress[child] += 1
        q = []
        for node in range(numCourses):
            if ingress[node] == 0:
                q.append(node)
        count = 0  # signifies how many nodes have been made independent by completing all the dependencies
        # print(ingress,q)
        while q:
            node = q.pop(0)
            count += 1
            for child, parent in prereq:
                if parent == node:
                    ingress[child] -= 1

                    if ingress[child] == 0:
                        q.append(child)
            # print(q)
        return count == numCourses