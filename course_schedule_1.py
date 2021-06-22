class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        from collections import deque
        """
        :rtype: bool
        :SC:O(V+E) (v=num of vertexes, E=num of edges)
        :TC:O(V+E)
        """
        # base
        if not prerequisites: return True
        
        inDegrees = [0]*numCourses
        graph = {i:set() for i in range(numCourses)}
        
        # computing hashmap graph and indegrees 
        for edge in prerequisites:
            inn=edge[0]
            out=edge[1]
            inDegrees[inn]+=1
            graph[out].add(inn)
        
        q=deque()
        for course_no, in_deg in enumerate(inDegrees):
            if in_deg==0:
                q.append(course_no)
        
        # BFS
        visited_node=0
        while q:
            node=q.popleft()
            visited_node+=1
            for sett_val in graph[node]:
                inDegrees[sett_val]-=1
                if inDegrees[sett_val]==0:
                    q.append(sett_val)
        
        return visited_node == numCourses
    
        
            
            
            
        
        