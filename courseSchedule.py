'''
-- Passed test cases on LeetCode
Time Complexity : O(V + E) ; Space Complexity : O(V + E)
'''
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if (prerequisites == None or len(prerequisites) == 0):
            return True

        index = [0 for i in range(numCourses)]              

        course_list = { i : [] for i in range(numCourses) }         

    
        for i in prerequisites:
            index[i[0]] += 1
            course_list[i[1]].append(i[0])

   
        queue = deque([])

    
        for i in range(numCourses):

            if (index[i] == 0):
                queue.append(i)

        while (len(queue) > 0):

            done = queue.popleft()

            for i in course_list[done]:

                index[i] -= 1

                if (index[i] == 0):
                    queue.append(i)

      
        for i in range(numCourses):

            if (index[i] != 0):
                return False

        return True
        
