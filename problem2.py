# https://leetcode.com/problems/binary-tree-level-order-traversal/

# Time Complexity : O(M + N) where N is number of courses and M is size of pre-requisites
#  Space Complexity : O(M + N)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : None


# Your code here along with comments explaining your approach.
# Approach : This is a graph problem, we first visualize the graph. Then we create a adjacency list
# and indegree's for all the courses. we then add all the courses with indegree == 0 into the queue
# we start counting the number of courses while we remove once course at a time from queue, and reducing
# the indegree of it's dependent courses. If any courses indegree equals 0, we add it to the queue.
# We do this until the queue is empty. At the end we check if number of courses is equal to completed
# courses and return the result.


from queue import Queue
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree_map = {}
        adj_list = {}
        _queue = Queue()
        completed_courses = 0
        if not prerequisites:
            return True

        for course in range(numCourses):
            indegree_map[course] = 0
            adj_list[course] = []

        for requisite in prerequisites:
            source = requisite[1]
            destination = requisite[0]
            adj_list[source].append(destination)
            indegree_map[destination] += 1

        for source, degree in indegree_map.items():
            if degree == 0:
                _queue.put(source)

        completed_courses = _queue.qsize()
        while _queue.qsize() > 0:
            cur_course = _queue.get()
            next_courses = adj_list.get(cur_course, [])
            for course in next_courses:
                indegree_map[course] -= 1
                if indegree_map[course] == 0:
                    completed_courses += 1
                    _queue.put(course)

        return completed_courses == numCourses


