#Space: O(m+n): For adjacenecy matrix
#Time: O(m+n): For adjacenecy matrix
from collections import defaultdict,deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #start by making the adjacenecy list that will store the courses, that it is a prerequisite of 
        ajacency_list = defaultdict(list)
        #dependency stores the number of courses need to be cleared for prerequisited
        dependency  = [0]*numCourses
        
        
        for val in prerequisites:
            ajacency_list[val[1]].append(val[0])
            dependency[val[0]]+=1
        
        #push all the courses for which prerequisites have been finished
        queue = deque()
        queue = deque(course for course,degree in enumerate(dependency) if not degree)
        
        
        while(queue):
            course = queue.popleft()
            for other_course in ajacency_list[course]:
                dependency[other_course]-=1
                if not dependency[other_course]:
                    queue.append(other_course)
            
        return not sum(dependency)
        