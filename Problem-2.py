# T.C = O(V+E) S.C = O(V+E)
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegrees = [0] * numCourses
        hashm = {}
        for pr in prerequisites:
            indegrees[pr[0]] +=1
            if pr[1] not in hashm:
                hashm[pr[1]] = []
            hashm[pr[1]].append(pr[0])

        count = 0
        q = deque()
        for i in range (numCourses):
            if(indegrees[i]==0):
                q.append(i)
                count+=1
        

        while q:
            curr = q.popleft()
            if curr in hashm:
                dependents = hashm[curr]
                for dependent in dependents:
                    indegrees[dependent]-=1
                    if(indegrees[dependent]==0):
                        q.append(dependent)
                        count+=1
                        if(count==numCourses):
                            return True

        return count == numCourses