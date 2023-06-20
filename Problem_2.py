"""
Problem : 2

Time Complexity : O(V+E)
Space Complexity : O(V+E)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

creating a dictionary to save the dependencies of courses on another courses, and saving the indegrees
of all the number at the respective number index, for each node in Queue, traversing all its children (BFS) and reduce their indegree by one because if the
prerequisite course is completed, then its children nodes are cleared off its dependency.
After all the nodes, if indegree of any course is still greater than zero, 
it means courses can't be finished, otherwise courses can be finished.

"""

# course schedule

from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if not prerequisites:
            return True
        hmap={ i : [] for i in range(numCourses)}
        indegrees=[0 for _ in range(numCourses)]

        for pr in prerequisites:
            indegrees[pr[0]]+=1
            if not pr[1] in hmap.keys():
                hmap[pr[1]]=[]
            hmap[pr[1]].append(pr[0])
        q=deque()
        count=0
        for i in range(numCourses):

            if indegrees[i]==0:
                q.append(i)
                count+=1

        while q:
            curr=q.popleft()
            children=hmap[curr]
            if len(children)>0:
                for child in children:
                    indegrees[child]-=1
                    if indegrees[child]==0:
                        q.append(child)
                        count+=1
                        if count==numCourses:
                            return True
        return False
