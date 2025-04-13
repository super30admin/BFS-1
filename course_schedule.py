

'''
Approach:
You have to identify Independent and dependent courses, and you have to solve the problem accordingly.

It's little tricky but some white boarding did help.


# Time complexity: O(n) --> The  number of nodes, as we go over every single node.
# Space complecity :O(n), Is actual space complexity (O(n)+O(n), one for hash_map and one for queue) Little confused, as we have to maintain queue and I am also using hash_map/dict as well.


# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, just on the space complexity.

'''

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if not prerequisites:
            return True

        courses =  [0 for i in range(numCourses)]

        hash_map ={}

        count =0


        for i, j in prerequisites:
            courses[i]+=1

            if j in hash_map:
                hash_map[j].append(i)
            else:
                hash_map[j]=[i]

        queue = deque()

        for i in range(len(courses)):

            if courses[i]==0:
                queue.append(i)
                count+=1


        if(count == numCourses):
            return True


        while(queue):

            current_course = queue.popleft()

            if current_course in hash_map:

                dependent_courses = hash_map[current_course]

                for course in dependent_courses:

                    courses[course]-=1

                    if courses[course]==0:
                        queue.append(course)
                        count+=1

                        if(count == numCourses):
                            return True


        return False
