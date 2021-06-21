'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 207. Course Schedule
# There are a total of numCourses courses you have to take, labeled from 0 
# to numCourses - 1. You are given an array prerequisites where 
# prerequisites[i] = [ai, bi] indicates that you must take course bi first 
# if you want to take course ai.

# For example, the pair [0, 1], indicates that to take course 0 
# you have to first take course 1.
# Return true if you can finish all courses. Otherwise, return false.

#-----------------
# Time Complexity: 
#-----------------
# O(M + N) - Need to iterate over M courses and N requisities once
#------------------
# Space Complexity: 
#------------------
# O(M + N): Need dictionary with M+N space. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_map = {}
        for i in range(len(prerequisites)):
            if prerequisites[i][1] not in course_map:
                course_map[prerequisites[i][1]] = [prerequisites[i][0]]
            else:
                course_map[prerequisites[i][1]].append(prerequisites[i][0])
        
        requisites = [False] * numCourses
        visited = [False] * numCourses
        # print(course_map)
        
        for i in range(numCourses):
            if not self.canFinishHelper(i, course_map, requisites, visited):
                return False
        return True
    
    def canFinishHelper(self, course:int, course_map:dict, requisites:List[bool], visited:List[bool]) -> bool:
        if visited[course]:
            return True

        if requisites[course]:
            return False
        else:
            requisites[course] = True
            result = True
            if course in course_map:
                for required_course in course_map[course]:
                    result = self.canFinishHelper(required_course, course_map, requisites, visited)
                    if not result:
                        return False
            
            requisites[course] = False
            visited[course] = True
            return result