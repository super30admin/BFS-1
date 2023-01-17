# Time Complexity :
# O(V+E), where E in the worst case can be NumCourses^2

# Space Complexity :
# O(E), 

# Did this code successfully run on Leetcode :
#Yes

#We First map the prerequisites to a graph - a graph node is a course and an edge is their dependency relato
#We then store the indegrees for each of the courses
#We go through each of the courses with 0 indegrees,remove them from the graph  and reduce the indegress of all the courses dependent on this course
#We keep doing this until our queue is empty
#If we have find that at the end of this all the nodes have indegree of 0, then we return True else false


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_map = {}
        indegrees_array = [0] * numCourses
        self.queue = []

        for prerequisite in prerequisites:
            indegrees_array[prerequisite[0]] += 1
            if prerequisite[1] in course_map:
                course_map[prerequisite[1]].append(prerequisite[0])
            else :
                course_map[prerequisite[1]] = [prerequisite[0]]
        
        count_taken = 0
        for i,elem in enumerate(indegrees_array):
            if elem == 0 :
                self.queue.append(i)
                count_taken += 1
                
        if len(self.queue)== 0 :
            return False
        while len(self.queue) != 0 :
            curr_elem = self.queue.pop(0)
            print (curr_elem)
            if curr_elem in course_map:
                for dependent_course in course_map[curr_elem]:
                    indegrees_array[dependent_course] -= 1
                    if indegrees_array[dependent_course] == 0:
                        count_taken += 1
                        self.queue.append(dependent_course)

        if count_taken == numCourses:
            return True
        else :
            return False
