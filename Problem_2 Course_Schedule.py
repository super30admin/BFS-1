# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indeg = [0] * numCourses
        map = defaultdict(int)
        for edge in prerequisites:
            if edge[1] not in map:
                map[edge[1]] = []
            map[edge[1]].append(edge[0])
            indeg[edge[0]] += 1
        q = deque()
        for i in range(len(indeg)):
            if indeg[i] == 0:
                q.append(i)
        count = 0
        if not q: return False
        while q:
            curr = q.popleft()
            count += 1
            edges = map[curr]
            if edges:
                for edge in edges:
                    indeg[edge] -= 1
                    if indeg[edge] == 0:
                        q.append(edge)
        if count == numCourses: return True
        return False
