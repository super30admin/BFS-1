# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english
	# Create a inout degree set
	# create a hashmap of course:course than can be taken after taking the key course
	# Run BFS of the created adjacency list

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        Prerq = [0] * numCourses
        AdvancedMap = {}
        
        for course in prerequisites:
            Prerq[course[0]] += 1
            if course[1] not in AdvancedMap:
                AdvancedMap[course[1]] = []
            AdvancedMap[course[1]].append(course[0])
        Queue = deque()
        
        for i in range(len(Prerq)):
            if Prerq[i] == 0:
                Queue.append(i)
        if len(Queue) == 0:
            return False
        count = 0
        while Queue:
            SelectedCourse = Queue.popleft()
            count += 1
            if SelectedCourse not in AdvancedMap:
                CanTakeCOurse = []
            else:
                CanTakeCOurse = AdvancedMap[SelectedCourse]
            if CanTakeCOurse:
                for i in CanTakeCOurse:
                    Prerq[i] -= 1
                    if Prerq[i] == 0:
                        Queue.append(i)
        return count == numCourses
        