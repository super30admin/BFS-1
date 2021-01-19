# Time Complexity : O( |E| + |V|) V: No. of courses and E is the No. of dependencies  
# Space Complexity : O( |E| + |V|) V: No. of courses and E is the No. of dependencies  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        queue = []
        result = []
        # Here I took defaultdic with list so that the course will store in form of list
        dic = collections.defaultdict(list)
        degree = [0] * numCourses
        
        # Append precourse as key and course as value in dic
        for precourse, course in prerequisites:
            dic[precourse].append(course)
            degree[course] += 1
        
        # if my degree[i] is zero meaning I can take that course since it doesn't have any prerequisities so I will add to the queue
        for i in range(len(degree)):
            if degree[i] == 0:
                queue.append(i)
        
        # perform till queue is not empty 
        while queue:
        
            # pop each element from queue which is my next course to take
            courseNumber = queue.pop(0)
            
            # append my course into result since I can take that
            result.append(courseNumber)
            
            dicvalue= dic[courseNumber]
            
            for nextcourse in dicvalue:
                # if we found we will decrement in degree array
                degree[nextcourse] -= 1
                # if it's == 0 then it means we can add to the queue
                if degree[nextcourse] == 0:
                    queue.append(nextcourse)
        
        # check len of result and num of courses
        return len(result) == numCourses
