# Time Complexity : - 
# Space Complexity : -

# Did this code successfully run on Leetcode : -
# Any problem you faced while coding this : Not able to solve


import collections
class Solution:
    def canFinish(self, numCourses, prerequisites) -> bool:
        forward = collections.defaultdict(set)
        backward = collections.defaultdict(set)
        
        for i,j in prerequisites:
            forward[i].add(j)
            backward[j].add(i)
        print(forward)
        print(backward)
        
        stack = []
        for i in range(numCourses):
            if not forward[i]:
                stack.append(i)
        