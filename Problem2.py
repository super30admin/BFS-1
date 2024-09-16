"""

    Student : Shahreen Shahjahan Psyche
    Time : O(V + E)
    Space : O(V + E)

    This code ran successfully for all the test cases in Leetcode


"""
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import deque
        
        # initializing a list to keep count how many pre-reqs are needed to do this one
        degrees = [0 for i in range(numCourses)]
        # initializing a hashmap to save thee course and the courses it opens
        records = {}
        # initializing a queue to travarse the courses when the pre-reqs are done
        q = deque()
        
        # filling up the hash map
        for i in range(len(prerequisites)):
            # increamenting the count from the value of the second position of the tuple
            degrees[prerequisites[i][1]] += 1
            # checeking whether the course exists or not. If not creating a list
            # beefore appending the value
            if not prerequisites[i][0] in records.keys():
                records[prerequisites[i][0]] = []
            records[prerequisites[i][0]].append(prerequisites[i][1])
        
        # now, we need to check the courses that does not require any pre-req 
        # and added in thee queue
        for i in range(len(degrees)):
                if degrees[i] == 0:
                    q.append(i)
        
        while(q):
            # popping out thee course
            curr_course = q.popleft()
            # if it is in the hashmap
            if curr_course in records.keys():
                opens_course = records[curr_course]
                # reducing the number of pre-reeqs and if any of theem becomes 0
                # adding that in thee queue
                for i in opens_course:
                    degrees[i] -= 1
                    if degrees[i] == 0:
                        q.append(i)
        
        # finally, if my count for pre-reqs in degree is 0 for all the courses
        # then I am returning true, otherwise false
        for i in degrees:
            if i != 0:
                return False
            
        
        return True