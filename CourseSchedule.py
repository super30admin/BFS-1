'''
    Time Complexity:
        O(V+E) (where V = number of courses, E = course dependencies)

    Space Complexity:
        O(V+E) (where V = number of courses, E = course dependencies)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS Fashion
        Process available courses (which have pre_req count = 0) first
        When processing this available course, reduce its dependent's pre_req count ('cause you've already taken this course).
        Keep track of the number of courses taken to check at the end.
'''
class Solution:
    def __init__(self):
        self.dependents = {}
        self.pre_req_counts = []
        self.courses_taken = 0
        self.q = collections.deque()

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.build_relationships_with(numCourses, prerequisites)
        self.take_courses()

        return self.courses_taken == numCourses

    def build_relationships_with(self, num_courses, pre_reqs):
        self.pre_req_counts = [0] * num_courses
        self.dependents = {c: [] for c in range(num_courses)}

        for course, pre_req in pre_reqs:
            self.dependents[pre_req].append(course)
            self.pre_req_counts[course] += 1

    def take_courses(self):
        for course, pre_req_count in enumerate(self.pre_req_counts):
            if pre_req_count == 0:
                self.q.append(course)

        while self.q:
            course = self.q.popleft()
            self.courses_taken += 1
            self.unblock_dependents(course)

    def unblock_dependents(self, course):
        for dependent in self.dependents[course]:
            self.pre_req_counts[dependent] -= 1

            if self.pre_req_counts[dependent] == 0:
                self.q.append(dependent)
