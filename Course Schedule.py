# Time Complexity :
# TC: O(V+E)

# Space Complexity :
# SC: O(V+E)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# I have maintained an Indegree's Array --> to keep track of 
# each course dependee(how many courses need to be completed to take this course)
# I have maintained an Adgecentcy List(Hashmap) --> to keep track of dependents of each course.
# I have maintained a queue. Initially we will fill the queue with independent courses.
# now we will remove first course from queue and take its dependents from Adgecentcy List and decrease the degree
# of these courses by one in Indegree's Array.
# If the degree of course becomes zero it becomes independent and now we add it to queue.
# We will maintain a count which will increase whenever a course is added to a queue.
# We will keep doing this until queue becomes empty.
# If the queue becomes empty and count becomes equal to number of courses that means
# All courses has become independent and we can return true.
# Else False



class Solution:
    
    # TC: O(V+E)
    # SC: O(V+E)
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegreesArray = [0 for i in range(numCourses)]
        adjecentcyList = dict()
        count = 0
        
        for edges in prerequisites:
            
            # Filling Indegree's Array --> array
            indegreesArray[edges[0]] += 1
            
            # Filling Adgecentcy List --> Hashmap
            if (not adjecentcyList.get(edges[1], None)):
                adjecentcyList[edges[1]] = []
            adjecentcyList[edges[1]].append(edges[0])
            
        import queue
        q = queue.Queue()
        
        # Fill queue with all the independent nodes
        for i in range(len(indegreesArray)):
            if indegreesArray[i] == 0:
                q.put(i)
                count += 1
                
        while (not q.empty()):
            
            curr = q.get()
            # Take all courses which are dependent on this course
            children = adjecentcyList.get(curr, None)
            
            if children is not None:
                for child in children:
                    indegreesArray[child] -= 1
                    if (indegreesArray[child] == 0):
                        q.put(child)
                        count += 1
  
        return count == numCourses