# // Time Complexity : O(V+E) where V: number of nodes or vertices of the graph, 
# E: number of edges of the graph
# // Space Complexity : O(V+E) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hashmap = defaultdict(list)
        
        # in-degree calculation
        indegree = [0 for  i in range(numCourses)]
        
        for i in range(numCourses):
            hashmap[i] = []
        
        for pre_req,core in prerequisites:
            
            hashmap[core].append(pre_req)
            indegree[pre_req] += 1
        
        queue = deque()
        
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
                
        while queue:
            core = queue.popleft()
            for pre_req in hashmap[core]:
                indegree[pre_req] -= 1
                if indegree[pre_req] == 0:
                    queue.append(pre_req)
                
        if sum(indegree) > 0: return False
        return True
                    