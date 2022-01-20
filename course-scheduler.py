# Time Complexity: O(V+E)
# Space Complexity: O(n)
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        map = {}
        indegrees = [0 for z in range(numCourses)]
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if not map.has_key(edge[1]):
                map[edge[1]] = []
            map[edge[1]].append(edge[0])
        
        count = 0
        q = []
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
        
        if not q: return False
        while q:
            curr = q.pop()
            children = map[curr]
            if children:
                for child in children:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)
                        count += 1
        if count == 0:
            return True
        return False