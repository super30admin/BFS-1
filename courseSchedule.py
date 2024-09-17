# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        #Eg: [[2,0],[4,0],[1,2],[1,4],[3,2],[5,3]]
        
        #1. initialise empty array with length equal to number of courses
        incomingEdges = [0]*(numCourses)
        
        #2. initialise hash map to keep an adjacency list of vertex
        hashMap = {}
        
        #3. iterate and populate number of incoming edges for every element
        for edge in prerequisites:
            
            first = edge[0]
            second = edge[1]
            
            #keep increasing count for each incoming edge
            incomingEdges[first] += 1
            
            #keep adding the nodes for every outgoing edge
            if second not in hashMap.keys():
                hashMap[second] = []
            hashMap[second].append(first)
            
        #4. look for indices of incomingEdge list that have values zero: it means there wasn't any incoming edge and hence they can be the starting point
        #Build a queue and add such indices to the queue
        #If no such index found, there exists a cycle and topological sort doesn't exist-> return False
        queue = []
        for i in range(len(incomingEdges)):
            if incomingEdges[i] == 0:
                queue.append(i)
                
        #5. while queue is not empty, keep decrementing counter if node in incomingEdge list is visited 
        while queue:
            course = queue.pop(0)
            #get it's chilren from the hashmap and add it to the queue
            if course in hashMap:
                children = hashMap[course]
                for i in children:
                    incomingEdges[i] -= 1
                    if incomingEdges[i] == 0:
                        queue.append(i)
                        
        #6. If incomingEdge list is entirely 0, reurn True; else there exists a case where there is a cycle between course and hence return False
        for i in (incomingEdges):
            if i!=0:
                return False
        return True
                
            
                
            
            
        
        