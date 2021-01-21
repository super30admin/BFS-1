# Created by Aashish Adhikari at 10:28 PM 1/20/2021

'''
Time Complexity:
O(V + E)
Space Complexity:
O(V + E) for the hashmap used.
'''

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """


        hm = {}

        # count the number of prerequisites that need to be fulfilled for each course
        ctr = [0 for _ in range(0, numCourses)]

        for pair in prerequisites:

            if pair[1] not in hm:
                hm[pair[1]] = [pair[0]]

            else:
                hm[pair[1]].append(pair[0])

            ctr[pair[0]] += 1



        from collections import deque
        independent_courses = deque()


        for idx in range(len(ctr)):
            if ctr[idx] == 0:
                independent_courses.append(idx)





        while len(independent_courses) != 0:

            # reduce the prerequisites required for the courses

            fulfilled = independent_courses[0]

            if fulfilled in hm:

                for course in hm[fulfilled]:

                    ctr[course] -= 1

                    if ctr[course] == 0:

                        independent_courses.append(course)

            independent_courses.popleft()


        if sum(ctr) == 0:
            return True
        else:
            return False




