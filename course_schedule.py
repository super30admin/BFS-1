# Time Complexity : Add - O(V+E)
# Space Complexity :O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I am first putting the edges into hashmao for quick look up of the neighbours
2. Then using indegree list for each node, to track the indegree
3. The nodes with 0 indegree will be pushed to queue as they are independent
4. For remaining nodes, we start in BFS manner, starting with childrens of the source node, anc decrementing
   its indegree, if it becomes zero, they are ready to be processed and hence are pushed to queue
'''
from collections import deque, defaultdict
class Solution:
    def __init__(self):
        self.graph_dict = defaultdict(lambda : [])
        
    def addEdge(self, u, v):
        
        if u not in self.graph_dict:
            self.graph_dict[u] = [v]
            
        else:
            self.graph_dict[u].append(v)
            
        if v not in self.graph_dict:
            self.graph_dict[v] = []
            
            
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if prerequisites == [] or prerequisites[0] == []:
            return True
        
        indegree_map = [0]*numCourses
        
        for pairs in prerequisites:
            self.addEdge(pairs[0], pairs[1])
            indegree_map[pairs[1]] += 1
            
        # print (self.graph_dict)
        queue = deque()
        for i in range(len(indegree_map)):
            if indegree_map[i] == 0:
                queue.append(i)
             
        # print (queue, indegree_map, self.graph_dict)
        while queue:
            
            source = queue.popleft()
            for v in self.graph_dict[source]:
                if indegree_map[v] >= 1:
                    indegree_map[v] -= 1
                    
                if indegree_map[v] == 0:
                    queue.append(v)
        
        for i in indegree_map:
            if i > 0:
                return False
        return True