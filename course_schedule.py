"""
Problem: 207. Course Schedule
Leetcode: https://leetcode.com/problems/course-schedule/
Solution: Graph traversal using Postorder DFS (Depth-First Search)
Time Complexity: O(E+V) where V is the number of courses, and E is the number of dependencies.
Space Complexity: O(E+V), with the same denotation as in the above time complexity.
"""


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        from collections import defaultdict
        courseDict = defaultdict(list)

        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]
            courseDict[prevCourse].append(nextCourse)

        checked = [False] * numCourses
        path = [False] * numCourses

        for currCourse in range(numCourses):
            if self.isCyclic(currCourse, courseDict, checked, path):
                return False
        return True

    def isCyclic(self, currCourse, courseDict, checked, path):
        # 1.bottom case
        if checked[currCourse]:
            # this node has been checked, no cycle would be formed with this code
            return False
        if path[currCourse]:
            # came across a marked node in the path, cyclic!
            return True

        # 2. postorder DFS on the children nodes
        # mark the node in the path
        path[currCourse] = True

        ret = False
        # postorder DFS, to visit all its children first
        for child in courseDict[currCourse]:
            ret = self.isCyclic(child, courseDict, checked, path)
            if ret: break

        # 3. after the visits of children, we come back to process the node iteself
        # remove the node from the path
        path[currCourse] = False

        # now that we've visited the nodes in the downstream,
        # we complete the check of this node
        checked[currCourse] = True
        return ret