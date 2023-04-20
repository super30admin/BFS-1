# Time Complexity :O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We first create a hashmap to store the courses that are dependent on a particular course. 
We also create a list to store the number of dependencies for each course. Then we take out 
courses that have no dependencies from the queue to finish them and change values in the list 
as prerequisites are met. After iterating through as much as we can, we just check the count 
of courses we have taken to return True or False
"""

from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == None: return True
        
        q = Queue()
        dependencies_remain = [0 for i in range(numCourses)]
        hashmap = {}
        courses_with_no_dependencies = 0

        for pair in prerequisites:
            dependencies_remain[pair[0]] += 1
            if pair[1] not in hashmap: hashmap[pair[1]] = []
            hashmap[pair[1]].append(pair[0])

        for i, j in enumerate(dependencies_remain):
            if j == 0: q.put(i); courses_with_no_dependencies += 1

        if q.qsize() == 0: return False

        while not q.empty():
            course = q.get()
            if course not in hashmap: continue

            for dependents in hashmap[course]:
                dependencies_remain[dependents] -= 1
                if dependencies_remain[dependents] == 0: 
                    q.put(dependents)
                    courses_with_no_dependencies += 1

        if courses_with_no_dependencies == numCourses:
            return True
        else:
            return False