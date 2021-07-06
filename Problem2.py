
"""
// Time Complexity : o(v+E), 
// Space Complexity : o(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
"""
from collections import defaultdict,deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #print(numCourses)
        #BFS
        in_deg = [0] * numCourses #to keep a track of dependencies of courses, helps in selecting the nodes to start from
        
        dep = defaultdict(list) #easy access to find the nodes that are dependent on a particular node
        
        for i in prerequisites:
            
            in_deg[i[0]] += 1
            
            dep[i[1]].append(i[0])
            
        
        q = deque()
        
        for i in range(len(in_deg)): #adding all nodes that are not dependent on other node to the queue
            if in_deg[i] == 0:
                q.append(i)
                
        if len(q) == 0: #if there are no independent nodes
            return False
        
        while q:
            cur = q.popleft()
            idx = dep[cur] #get indices of dependent nodes from dictionary
            
            for i in idx: #reduce in degrees for dependent courses
                in_deg[i] -= 1
                
                if in_deg[i] == 0: #if in degrees for the node becomes zero, add it to queue for processing
                    q.append(i)
                    
        for i in in_deg: #if there are any dependency left, return false
            if i != 0:
                return False
            
        return True
                    
            
        