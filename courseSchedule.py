# Time Complexity : O(V + E), Space Complexity : O(V + E)
# where V is the number of prereqs visited and E is the total number of courses which have the prereqs.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    # This approach uses a hashmap to make an Adjacency List, all courses with no prereqs are
    # added to a queue and a BS is performed while maintaining the classes taken and visted.
    # in the end all classes must have been visited to return true, else return false.
    def __init__(self):
        self.store = {}

    # adjacenvy list build function
    def addVals(self, src, dest):
        try: self.store[src].append(dest)
        except: self.store[src] = [dest]

    def canFinish(self, numCourses, prerequisites):
        if not prerequisites:
            return True
        # in degrees array init
        courses = [0] * numCourses
        # adjacency list init
        for i in prerequisites:
            self.addVals(i[0], i[1])
            courses[i[1]] += 1

        queue = deque()
        # Adding all courses with no dependency to queue
        for i in range(len(courses)):
            if courses[i] == 0:
                queue.appendleft(i)
        # performing bfs to explore all courses
        while len(queue) != 0:
            curr = queue.pop()
            if curr in self.store:
                children = self.store[curr]
                # marking course visited and adding to queue if no more dependency
                for edge in children:
                    courses[edge] -= 1
                    if courses[edge] == 0:
                        queue.appendleft(edge)
        # all courses visited or not
        return sum(courses) == 0
