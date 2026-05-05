# Time Complexity: O(V+E) V is the number of courses (vertices) and E is the number of prerequisites (edges)
# Space Complexity: O(V+E)
# Did this code successfully run on Leetcode : Yes


from collections import defaultdict,deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        ndeg=[0]*numCourses
        adjlist=defaultdict(list)
        c=0
        queue= deque()

        for n in prerequisites:
            ndeg[n[0]]+=1
            adjlist[n[1]].append(n[0])

        for i in range(numCourses):
            if ndeg[i]==0:
                c+=1
                queue.append(i)

        if c==numCourses: return True

        while queue:
            node = queue.popleft()

            for neighbor in adjlist[node]:
                ndeg[neighbor]-=1
                if ndeg[neighbor]==0:
                    queue.append(neighbor)
                    c+=1
                
                if c==numCourses:
                    return True
        
        return False
        


        

        