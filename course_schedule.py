# Time Complexity: O(n) where n is the number of courses
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjacency_dict = dict()
        inCount = [0 for _ in range(numCourses)]
        for i,j in prerequisites:
            if j not in adjacency_dict:
                adjacency_dict[j] = []
            adjacency_dict[j].append(i)
            inCount[i] += 1

        q = deque()
        count = 0
        for i,val in enumerate(inCount):
            if val == 0:
                q.append(i)
                count += 1
        if count == numCourses:
            return True
        while q:
            node = q.popleft()
            if node in adjacency_dict:
                children = adjacency_dict[node]
                for i in children:
                    inCount[i] -= 1
                    if inCount[i] == 0:
                        count += 1
                        q.append(i)
        return count == numCourses
