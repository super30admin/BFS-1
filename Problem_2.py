# Runs on Leetcode
# Runtime - O(E) - E is edges
# Memory - O(n)

'''
BFS 

1) Based on the adjacency list of the edges, created a dictionary with key as course and value as list of prereq's to be 
  completed to finish the course - which is key.
  
2) Created a list named courses which stores value 'a' at i th position where i is the vertice and a is the number of courses
   for which i is prereq.
   
3) Start a queue with all i's with courses[i] as 0.

4) While iterating theorugh the queue, retreive the queue elements value form dictionary and decrease count of courses[i] by 1.

5) Add all the courses[i] which become 0 to the queue.

'''

class Solution:
    def canFinish(self, numCourses, prerequisites):
        if not prerequisites:
            return True
        graph = {}
        courses = [0] * numCourses
        
        # course : prereq
        
        for i in prerequisites:
            courses[i[1]] += 1
            if i[0] not in graph:
                graph[i[0]] = [i[1]]
            else:
                graph[i[0]].append(i[1])
                
        for i in range(numCourses):
            if i not in graph:
                graph[i] = []
            else:
                continue
        queue = []
        for i in range(len(courses)):
            if courses[i]==0:
                queue.append(i)
            else:
                continue
        if not queue:
            return False
        while queue:
            popped = queue.pop()
            values = graph[popped]
            for i in values:
                courses[i] -= 1
                if courses[i] == 0:
                    queue.append(i)
        if 1 in courses:
            return False
        return True
