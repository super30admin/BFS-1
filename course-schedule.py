# Time Complexity : O(V + E), where V is the number of courses and E is the number of dependencies
# Space Complexity : O(V + E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Store the number of pre_reqs for each course
        num_pre_reqs = [0 for i in range(numCourses)]

        # Total number of courses which have pre_reqs
        dependent_courses = 0

        # Mapping of course -> courses for which it is a pre_req
        pre_req_map = defaultdict(list)

        for course, pre_req in prerequisites:

            pre_req_map[pre_req].append(course)

            if num_pre_reqs[course] == 0:
                dependent_courses += 1

            num_pre_reqs[course] += 1

        q = list()

        for i, count in enumerate(num_pre_reqs):
            if count == 0:
                q.append(i)

        while q:
            pre_req = q.pop(0)

            for course in pre_req_map[pre_req]:
                num_pre_reqs[course] -= 1

                if num_pre_reqs[course] == 0:
                    q.append(course)
                    dependent_courses -= 1

        return dependent_courses == 0
