# https://leetcode.com/problems/course-schedule/submissions/838187462/
#using BFS since we have to do level order traversal and we need to use queue for BFS
# Time Complexity : O(E+V)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
import collections
class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:

        inDegree = [0 for x in range(numCourses)]
        q = collections.deque()
        preMap = collections.defaultdict(list)
        for item in prerequisites:
            inDegree[item[0]] += 1
            preMap[item[1]].append(item[0])

        for i in range(numCourses):
            if (inDegree[i] == 0):
                q.append(i)
        
        print(q)
        completedCourses = 0

        while(len(q) != 0):
            course = q.popleft()
            d = preMap[course]
            completedCourses += 1
            for x in d:
                inDegree[x] -= 1
                if(inDegree[x] == 0):
                    q.append(x)
        
        if completedCourses == numCourses:
            return True
        else:
            return False