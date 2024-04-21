class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if  not prerequisites:
            return True
        cdict = defaultdict(list)
        indegrees = [0] * numCourses
        count = 0

        for out, inside in prerequisites:
            cdict[out].append(inside)
            indegrees[inside] += 1
        
        q = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                count += 1
                q.append(i)
        if not q:
            return False
        while q:
            curr = q.pop()

            for child in cdict[curr]:
                 indegrees[child] -= 1
                 if indegrees[child] == 0:
                    q.append(child)
                    count += 1
                    if count == numCourses:
                        return True
        return False


# Time Complexity: O(V + E) 
# Space Complexity: O(V + E)
# V - number of courses, E - number of prerequisites