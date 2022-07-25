# Time Complexity = O(v + e), where v is the vertices, e is the edges
# Space Complexity = O(n)


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        if numCourses == 0:
            return True
        
        # indegrees array
        indegrees = [0] * numCourses
        # adjacency list
        dictC = {}
        
        # Determining the dependencies and adding the number of dependencies each course has, in the indegrees array
        for req in prerequisites:
            inArrow = req[0]
            outArrow = req[1]
            indegrees[inArrow] += 1
        
        # Creating an adjacency list/hash map to keep a track of what pre req is associated with what all courses
            if outArrow not in dictC:
                dictC[outArrow] = []    
            dictC[outArrow].append(inArrow)
        
        
        # BFS
        # Declaring a queue
        q = []
        # If indegrees have element == 0, it implies that, that particular course is completed. So we put that in our queue
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
           
        
        # Find from dict, what courses are associated with the 'q' element 
        while (q):
            curr = q.pop(0)
            edges = dictC.get(curr)
    
            # If its an empty list, don't bother and continue
            if edges == None:
                continue
            
            # Check for every list element from dict values and decrease their indegrees value 
            for edge in edges:
                indegrees[edge] -= 1
                if indegrees[edge] == 0:
                    q.append(edge)
                    
        # If in the end, the indegrees array has any element other than 0, it means that all course cannot be completed             
        for i in range(numCourses):
            if indegrees[i] != 0:
                return False
                
        return True
                    
                    
            
            
            
        
        