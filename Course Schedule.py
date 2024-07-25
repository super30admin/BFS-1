
#// Time Complexity : O(V+E)
# // Space Complexity : O(V+E) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dicti = defaultdict(list)
        for i,j in prerequisites:
            dicti[j].append(i)
        
        inorder = [0] * numCourses
        for i in range(numCourses):
            for j in dicti[i]:
                inorder[j] += 1
        queue = deque()
    
        count = 0
        for i in range(len(inorder)):
            if inorder[i] == 0:
                queue.append(i)
                count +=1 
        
        while queue:
            abc = queue.popleft()
            for i in dicti[abc]:
                inorder[i] -= 1
                if inorder[i] == 0:
                    queue.append(i)
                    count += 1 
        if count == numCourses:
            return True

        return False


        
# Approach:
# 1. Create a dictionary to store the prerequisites for each course. The key is the course and the
#     value is a list of prerequisites for that course.
#     2. Create an array called inorder to keep track of the number of prerequisites for each course. The
#     index of the array corresponds to the course and the value at that index is the number of prerequisites
# for that course.
#     3. Iterate through the prerequisites and increment the value at the index of the prerequisite in the inorder array
# 4. Create a queue to keep track of the courses that have no prerequisites. Add the
# courses with no prerequisites to the queue and increment the count variable.
# 5. While the queue is not empty, pop the first course from the queue and decrement the value
# at the index of the prerequisite in the inorder array. If the value at the index of the prerequisite
# is 0, add the prerequisite to the queue and increment the count variable.
# 6. If the count variable is equal to the number of courses, return True. Otherwise, return
# False.