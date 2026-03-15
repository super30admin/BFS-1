# https://leetcode.com/problems/course-schedule/description/

# Time Complexity: O(V+E)
# Space Complexity: O(n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        q = deque()
        adj_list = defaultdict(list)
        indegrees = [0] * numCourses
        count = 0

        for item in prerequisites: 
            indegrees[item[0]] += 1
            adj_list[item[1]].append(item[0])

        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
                count += 1

        while q:
            qroot = q.popleft()
            popped_list = adj_list[qroot]
            for i in popped_list:
                indegrees[i] = indegrees[i] - 1
                if indegrees[i] == 0:
                    q.append(i)
                    count += 1

        if count != numCourses:
            return False

        # for i in indegrees:
        #     if i != 0:
        #         return False

        return True