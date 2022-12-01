#Time complexity: O(V + E) where V is Vertices (courses) in the graph and E is edges (dependencies)
#Space complexity: O(V + E)

#Accepted on Leetcode

#Approach: 
#Topological sort, where sorting is done on the basis of number of dependencies
#Create an indegrees array which contains number of dependencies for each course, then create an adjacency list with a hashmap containing dependents for each course
#Create a queue with zero-dependency courses -> 'complete these courses' and then reduce the dependency count of each dependent (using adjacency list) from indegrees array by 1 -> if any courses dependency reduces to zero add it to the queue -> Repeat until queue is empty -> If all courses completed no cycle exists in graph



class Solution:
    from collections import deque
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #indegrees list(initialize too) and adj list
        indegrees = [0 for i in range(numCourses)]
        adjList = {}
        for prereqArr in prerequisites:
            course = prereqArr[0]
            dependency = prereqArr[1]
            indegrees[course] += 1
            if dependency not in adjList:
                adjList[dependency] = []
            adjList[dependency].append(course)
        
        #formulate queue of zero dependent courses
        courseQ = deque()
        completedCourseCount = 0
        for i,x in enumerate(indegrees):
            if x == 0:
                courseQ.append(i)
        
        #iterating over courseQ
        while len(courseQ):
            completedCourse = courseQ.popleft()
            completedCourseCount += 1
            if completedCourse in adjList:
                #reducing one dependency for each dependent course
                for dependentCourse in adjList[completedCourse]:
                    indegrees[dependentCourse] -= 1
                    if indegrees[dependentCourse] == 0:
                        courseQ.append(dependentCourse)
        
        return completedCourseCount == numCourses
                


          
                

        