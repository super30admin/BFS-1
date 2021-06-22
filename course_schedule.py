class Solution:
    '''
    Note: you can identify that this is a graph problem because there is a relationship you have to find.
    
    '''
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import defaultdict
        
        course_dict = defaultdict(list)
        
        for c in prerequisites:
            # go through the courses and find the next course for each prev
            nxt, prev = c[0], c[1]
            course_dict[prev].append(nxt)
        
        visited = [False] * numCourses
        dfs_path = [False] * numCourses
        
        for c in range(numCourses): # if you found a cycle, then return false
            if self.is_cycle(c, course_dict, visited, dfs_path):
                return False
        return True
    
    def is_cycle(self, c, course_dict, visited, dfs_path):
        
        # we've already visited this node so no cycle
        if visited[c]:
            return False
        
        # we've seen this before in our current path so it is a cycle
        if dfs_path[c]:
            return True
        dfs_path[c] = True
        res = False
        # this is the DFS search
        for node in course_dict[c]:
            res = self.is_cycle(node, course_dict, visited, dfs_path)
            if res: break
        
        # essentially popping the node from path
        dfs_path[c] = False
        
        visited[c] = True
        
        return res