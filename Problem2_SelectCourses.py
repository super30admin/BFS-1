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
        self.course_map = {}
        for i in range(len(prerequisites)):
            if prerequisites[i][1] not in self.course_map:
                self.course_map[prerequisites[i][1]] = [prerequisites[i][0]]
            else:
                self.course_map[prerequisites[i][1]].append(prerequisites[i][0])
        
        self.path = [False] * numCourses
        self.visited = [False] * numCourses
        # print(course_map)
        
        for i in range(numCourses):
            if self.hasCycle(i):
                return False
        return True
    
    def hasCycle(self, course:int) -> bool:
        if self.path[course]:
            return True

        if self.visited[course]:
            return False

        else:
            self.path[course] = True
            result = False
            if course in self.course_map:
                for required_course in self.course_map[course]:
                    result = self.hasCycle(required_course)
                    if result:
                        return True
            
            self.path[course] = False
            self.visited[course] = True
            return result