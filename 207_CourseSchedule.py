"""
Leetcode- https://leetcode.com/problems/course-schedule/ (submitted)
O(E) TC and O(E) space - where E is edges in the graph (dependency list)
Challenges- NA
Lecture- https://www.youtube.com/watch?v=UWwsFlt_xuo
FAQ-
Best technique? BFS
Can we use DFS? Yes, refer below

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course
ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
"""

from collections import deque


class Solution:
    """
    Ideation - BFS O(E) TC and O(E) space - where E is edges in the graph (dependency list)
    Let's start with creating a hashmap (adjaceny list) of courses who when finished can make its children available
    (courses free to take), and inorder of the courses which shows how many courses they are dependent on.

    Start the BFS from the independent courses first, i.e. courses we no dependency, and free up other courses by
    reducing their inorder. If they become independent ,i.e.,their inorder becomes zero, add them to our BFS queue.

    In the end check if there are any courses left whose inorder is not zero, if they can't be free, then return False
    since all courses cannot be taken (because their dependency is not resolved).
    """

    def canFinish(self, numCourses, prerequisites):
        inDegree = [0 for _ in range(numCourses)]
        adjList = {}
        # create adjacency {courseid:<list of courses who have dependency of 'course'>} and inorder list
        for prereq in prerequisites:
            if prereq[1] not in adjList:
                adjList[prereq[1]] = [prereq[0]]
            else:
                adjList[prereq[1]].append(prereq[0])
            inDegree[prereq[0]] += 1

        # append nodes with inorder '0' in the queue. Starting with independent courses
        q = deque()
        # count is the number of available courses
        count = 0
        for i in range(numCourses):
            if inDegree[i] == 0:
                q.append(i)
                count += 1

        while q:
            currCourse = q.popleft()
            # no dependents for the course in adjList
            for dependent in adjList[currCourse]:
                inDegree[dependent] -= 1
                if inDegree[dependent] == 0:
                    if dependent in adjList:
                        q.append(dependent)
                    count += 1

        # if there are still any inDegree greater than zero - meaning courses still have dependencies left
        if count != numCourses:
            return False

        return True

    """
    Ideation - DFS O(E) TC and O(E) space - where E is edges in the graph (dependency list)
    Same logic as BFS, only thing to take care is how to design DFS base cases.
    """

    def canFinish1(self, numCourses, prerequisites):
        self.inDegree = [0 for _ in range(numCourses)]
        self.adjList = {}
        # create adjacency {courseid:<list of courses who have dependency of 'course'>} and inorder list
        for prereq in prerequisites:
            if prereq[1] not in self.adjList:
                self.adjList[prereq[1]] = [prereq[0]]
            else:
                self.adjList[prereq[1]].append(prereq[0])
            self.inDegree[prereq[0]] += 1

        self.visited = [False for _ in range(numCourses)]
        self.count = 0
        for i in range(numCourses):
            if self.inDegree[i] == 0 and self.visited[i] is False:
                self.dfs(i)

        if self.count == numCourses:
            return True
        return False

    def dfs(self, _id):
        # kick out if visited
        if self.visited[_id]:
            return
        # if no dependence in dependency in adjacency list, mark as visited and increase count
        if _id not in self.adjList:
            self.count += 1
            self.visited[_id] = True
            return
        # call recursive if dependency's inorder = 0 else decrement its inorder
        for dependent in self.adjList[_id]:
            self.inDegree[dependent] -= 1
            if self.inDegree[dependent] == 0:
                self.dfs(dependent)
        # once all dependencies are taken care of, mark and visited and increase the count
        self.visited[_id] = True
        self.count += 1


courses = 2
prereq = [[1, 0]]
result = Solution().canFinish1(courses, prereq)
print(result)
