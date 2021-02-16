# // Time Complexity : O(n)??
# // Space Complexity : O(E+V)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# LOGIC
# This is a graph problem 
# We solved it in 4 steps

#     1. For loop: we created the indegrees array to store the dependencies of each nodes
#     2. In same for loop we created a hashmap which stores
#                 node1 : [dependet node 1, dependent node 2,... ]
#     3. We look for independent node in indegrees array and store those nodes into queue
#     4. we run a while loop (BFS) and decrese the value of dependencies in that

#     we check if any node has >0 in indegrees array we return false otherwise true


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 1:
            return True
        
        indegrees = [0]*numCourses
        map = {}
        
        # create Ingree
        # + map of egdges
        
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] += 1
            
            if prerequisites[i][1] not in map:
                map[prerequisites[i][1]] = []
            map[prerequisites[i][1]].append(prerequisites[i][0])
        
        # Create queue and insert independent nodes
        
        q = deque()
        for i in range(len(indegrees)):
            if indegrees[i]==0:
                q.append(i)
        while q:
            x = q.popleft()
            if x in map:
                for j in map[x]:
                    indegrees[j] -= 1
                    if indegrees[j] == 0:
                        q.append(j)
        # llok for not 0
        for i in indegrees:
            if i>0:
                return False
        
        return True
        
            
            
        
        
        
            
            
        
        