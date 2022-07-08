# Time Complexity : O(v+e) where v is the vertices of the graph and e is the edges
# Space Complexity : O(v+e)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)

        incoming = [0] * numCourses

        for u, v in prerequisites:
            incoming[v] += 1
            graph[u].append(v)

        queue = []

        for i, v in enumerate(incoming) :
            if v == 0 :
                queue.append(i)
        if not queue:
            return False

        count = 0

        while queue:
            u = queue.pop()
            count += 1

            for v in graph[u] :
                incoming[v] -= 1

                if incoming[v] == 0 :
                    queue.append(v)

        return count == numCourses
