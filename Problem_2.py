"""
Time Complexity : O(V + E), V= vertices, E = edeges
Space Complexity: O(V + E)
Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
"""

from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == []: return True
        
        
        dict_courses = defaultdict(list)
        indegrees = [0 for _ in range(numCourses)]
        q = deque()
        count = 0
        
        # creating indegree list
        for num in prerequisites:
            indegrees[num[0]] += 1
            
            # independent to dependent node mapping
            if num[1] not in dict_courses:
                dict_courses[num[1]].append(num[0])
            else:
                dict_courses.get(num[1]).append(num[0])
                
        # Creating a queue and adding only independent nodes
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
                
        # if there is no independent node in the list
        if q == None and count == 0: return False
        
        # iterating over the queue
        while q:
            course = q.popleft()
            # now reduce the dependent nodes in the dict_courses on by one
            child = dict_courses.get(course)
            if child:
                for nodes in child:
                    indegrees[nodes] -= 1
                    if indegrees[nodes] == 0:
                        q.append(nodes)
                        count += 1
                    if count == numCourses:
                        return True
                
        return False
            
                
                
        
