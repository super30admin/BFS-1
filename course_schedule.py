#Time Complexity: O(E+V).
#Auxiliary Space: O(E+V)
#Did this code successfully run on Leetcode :Yes

from collections import deque

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if len(prerequisites)==0:
            return 1
        
        course_map = {}
        completed = 0
        dependency_list = [0 for i in range(numCourses)]
        for each_list in prerequisites:
            if each_list[1] in course_map:
                course_map[each_list[1]].append(each_list[0])
            else:
                course_map[each_list[1]]=[each_list[0]]
            dependency_list[each_list[0]]+=1
        queue = deque()
        for index,course in enumerate(dependency_list):
            if course == 0:
                queue.append(index)
        if len(queue)==0:
            return False
        if len(queue) == numCourses:
            return True
        while(queue):
            for num in range(len(queue)):
                ele = queue.popleft()
                completed+=1
                if ele in course_map :
                    for dep in course_map[ele]:
                        dependency_list[dep]-=1
                        if dependency_list[dep] ==0:
                            queue.append(dep)
        return completed==numCourses