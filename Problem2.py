'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We use BFS to perform level order approach. We maintain a hashmap and a indegree list. The hashmap holds the pairs of courses,
the pre-req course becomes the key and the corresponding value list holds the list of dependent courses.

The indegree list is used to keep track of dependent courses as we go on completing the courses. The dependent courses are reduced.
We require all courses to be completed before returning True value

'''

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        maps = {i: [] for i in range(numCourses)}
        indegree = [0 for i in range(numCourses)]

        for [i,j] in prerequisites:
            maps[j].append(i)
            indegree[i] += 1

        q = collections.deque()
        count = 0

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                count += 1

        if not q:
            return False


        while q:
            curr = q.popleft()

            for i in maps[curr]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    q.append(i)
                    count += 1

            if count == numCourses:
                return True

        return False









