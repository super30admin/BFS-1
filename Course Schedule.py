# Time Complexity :  O(V+E) V = number of verticies, E = number of edges 
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseMap = {}
        count = 0
        inDegree = [0] * numCourses
        if len(prerequisites) == 0:
            return True

        for pair in prerequisites:
            inDegree[pair[0]] += 1

            if pair[1] not in courseMap:
                courseMap[pair[1]] = [pair[0]]
            else:
                courseMap[pair[1]].append(pair[0])

        q = []
        for i in range(len(inDegree)):
            if inDegree[i] == 0:
                q.append(i)
                count += 1
                
        while(len(q) > 0):
            temp = q.pop(0)
            if temp in courseMap:
                for i in courseMap[temp]:
                    inDegree[i] -= 1
                    if inDegree[i] == 0:
                        count += 1
                        q.append(i)
                        if count == numCourses:
                            return True
        return False