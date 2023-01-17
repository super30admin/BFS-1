# Time Complexity :O(E+V)
# Space Complexity :O(E+V)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        indegrees = [0]*numCourses
        pres = {}
        
        
        for a, b in prerequisites:
            if b not in pres:
                pres[b] = [a]
            else:
                pres[b].append(a)
            
            indegrees[a] += 1
        
        
        queue = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)
        
     
        ans = []
        while queue:
            new = queue.popleft()
            ans.append(new)
            if new in pres:
                for next in pres[new]:
                    indegrees[next] -= 1
                    if indegrees[next] == 0:
                        queue.append(next)
            
        if len(ans) != numCourses:
            return False
        return True