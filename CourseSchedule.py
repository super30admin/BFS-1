   ---------------------Course Schedule--------------------------------------   
# Time Complexity : O(E+V) E is length of prerequisites and V is the number of courses.
# Space Complexity : O(E+V) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here first we will create an array of number of prerequisites for each course we have to determine, what are the courses without prerequisites.
# Once we got the courses of no prerequisites, we will add them to queue and prepare a dictionary of what are the courses depends on that particular course.
#We the process and iterate through queue and complete the course and go to the courses which has this course as prerequisites.
#and as soon as we complete the prerequisites we will add that course into the queue and process that course again.Once we complete all courses,
#our in-degree array will have all 0's. If not we cannot complete the courses.



class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses or not prerequisites:
            return True
        
        indegree = [0 for i in range(numCourses)]
        d = collections.defaultdict(list)
        for pair in prerequisites:
            indegree[pair[0]] +=1
            d[pair[1]].append(pair[0])
        
        queue = collections.deque()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
        
        if not queue:
            return False
        
        count = 0
        while queue:
            curr = queue.popleft()
            count +=1
            for k in d[curr]:
                indegree[k] -=1
                if indegree[k] == 0:
                    queue.append(k)
        
        return count == numCourses