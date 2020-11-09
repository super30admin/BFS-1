#Time Complexity : O(v+e) where e in the number of links between courses and v is the is number of courses
#Space Complexity : O(v+e) where e in the number of links between courses and v is the is number of courses
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Firstly initialize two hashmaps, one which is basically a graph of the courses and it's prerequisites and another which holds the number of incoming nodes for each course. Now the courses which have 0 incoming links, mean there are no prerequisites for that course and we can start with these courses, so storing these courses in a queue. Now doing a BFS we find all the courses who are prerequisites to the courses in the queue, and then reduce counts of those in the incoming hashmap (as we assume that the course has been completed so the courses following it can be taken). We also keep a count to see how many courses have been completed, if in the end the total number of courses are equal to the count of the courses, then we can return true as all courses can be finished, else we return false, as it would mean we still have left over courses which we are not able to complete.

#Your code here along with comments explaining your approach


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        graph = {}
        incoming = {}

        for i in range(numCourses):
            graph[i] = []
            incoming[i] = 0

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            incoming[course] = incoming.get(course, 0) + 1

        q = deque([])
        for k, v in incoming.items():
            if v == 0:
                q.append(k)

        count = 0
        while q:
            currCourse = q.popleft()
            count += 1
            for k in graph[currCourse]:
                incoming[k] -= 1
                if incoming[k] == 0:
                    q.append(k)

        return count == numCourses
