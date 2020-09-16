# 207. Course Schedule

# Approach:

# Initialize 2 hashmaps:
# first hashmap : 0..n initialized with  '0'
# second hashmap: parent node and its children
# In the first hashmap, we add the number of incoming edges for a node

# Check in the first hashmap, if there is a node with '0' incoming edges add it to the queue and perform a BFS.
# Keep adding the nodes from the queue to the resulting array.




class Solution:
    def canFinish(self, n: int, edges: List[List[int]]) -> bool:
        # Base Condition
        if not edges:
            return True
        
        Incoming = {i: 0 for i in range(n)}
        mapping = {i: [] for i in range(n)}
        
        for edge in edges:
            mapping[edge[1]].append(edge[0])
            Incoming[edge[0]]+=1
        
        q = collections.deque()
        
        for i in Incoming:
            if Incoming[i]==0:
                q.append(i)
      
        res = []

        
        while q:
            curr = q.popleft()
            res.append(curr)
            
            for nodes in mapping[curr]:
                Incoming[nodes]-=1
                if Incoming[nodes]==0:
                    q.append(nodes)
            
        return len(res)==n
            
                
        


# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
# Accepted on Leetcode: Yes.