# Time Complexity: O(V+E) 
# Space Complexity: O(V+E) 
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        adjList = defaultdict(list)
        indegree = [0]*numCourses
        
        for dest, src in prerequisites:
            adjList[src].append(dest)
            indegree[dest]+=1
            
        zeroq = deque()
        
        for i in range(len(indegree)):
            if indegree[i] == 0:
                zeroq.append(i)
                
        res = []
        while zeroq:
            c = zeroq.pop()
            res.append(c)
            for nei in adjList[c]:
                indegree[nei]-=1
                if indegree[nei] == 0:
                    zeroq.append(nei)
        
        return len(res) == numCourses