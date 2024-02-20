#
# @lc app=leetcode id=207 lang=python3
#
# [207] Course Schedule
#

# @lc code=start
'''
Time Complexity - O(V+E). We traverse all the edges. This can be greater than number of nodes or even lower. Hence it will be the higher of the two
Space Complexity - O(V+E). We are using adjacency list but it will be of size V+E

This code works on LeetCode
'''
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees, dependencies = [0 for i in range(numCourses)], {} #create indegrees array to store indegree of every vertex and the map to maintain the adjacency list
        for dependency in prerequisites:
            inVertex = dependency[0]
            outVertex = dependency[1]
            indegrees[inVertex] += 1 #increase the indegree of the vertex that has a dependency
            if outVertex not in dependencies: #check for the vertex in the adjacency list, if not present create a list for the vertex
                currDependency = [inVertex] 
                dependencies[outVertex] = currDependency                
            else:
                currDependencies = dependencies.get(outVertex) #append the dependent vertex in the list of the vertex it depends on
                currDependencies.append(inVertex)
        courseCount = 0 #maintain a course count 
        courseQ= deque() #create a queue
        for i in range(len(indegrees)): #find all courses that are independent(i.e. indegree 0). They can be taken
            if indegrees[i] == 0:
                courseQ.append(i) #add the course to the queue
                courseCount+=1 #increase course count
        completeFlag = True #set a flag to ensure that we have taken all the courses
        if not courseQ: #if queue is empty at beginning return False as we cannot complete the courses if they are interdependent
            completeFlag = False
        while courseQ: #Continue until my queue is not empty
            currCourse = courseQ.popleft() #Take first course in the queue
            print(currCourse)
            dependents = dependencies.get(currCourse) #get list of all dependent courses from adjacency list
            if dependents == None: #continue if the course is not a requirement for any course
                continue
            for dependent in dependents: #if course is a requirement, then find all courses that are dependent on this course
                indegrees[dependent]-=1 #reduce their indegree by 1 as we are completing a requirement for that course
                if indegrees[dependent] == 0: #if we complete all requirements then indegree will be zero and we can take the course so we add it in the queue
                    courseQ.append(dependent)
                    courseCount+=1 #increase course count at the same time
                    if courseCount == numCourses:
                        completeFlag = True
                        break #get out of the loop if we complete all the courses
            if courseCount == numCourses:
                break #get out of the loop if we complete all the courses
        if courseCount != numCourses:
            completeFlag = False #if queue is empty but we could not complete all courses, it means that we were not able to take a course due to interdependent courses 
        return completeFlag #return the final result

        
# @lc code=end

