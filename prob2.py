# Time Complexity : O(V+E)
# Space Complexity : O(V+E) for queue and hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took a few tries to get the code correct
# Your code here along with comments explaining your approach

# using a bfs approach and a map to keep the mapping between an independent course
# and a dependent course, as well as an indegrees array, 
# push all those courses into queue whose indegree is 0, 
# and iterate over such a course's dependent courses, reduce their indegree by 1,
# if the child course's indegree is 0, push it into the queue and so on
# every time you add a course to the queue, increase a counter by 1
# in the end return count == numCourses

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegrees = [0] * numCourses
        mydict = {}
        count = 0
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if edge[1] not in mydict:
                mydict[edge[1]] = []
            mydict[edge[1]].append(edge[0])
           
        q = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
        
        while len(q) != 0:
            curr = q.popleft()
            if curr in mydict:
                if mydict[curr] is not None and len(mydict[curr]) != 0:
                    children = mydict[curr]
                    for child in children:
                        indegrees[child] -= 1
                        if indegrees[child] == 0:
                            q.append(child)
                            count += 1
        return count == numCourses