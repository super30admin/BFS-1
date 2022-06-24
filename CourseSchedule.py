# // Time Complexity : O(N)
# // Space Complexity : O(N)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preRequisiteMap = collections.defaultdict(list)
        indegree = [0] * numCourses
        for dep, indep in prerequisites:
            preRequisiteMap[indep].append(dep)
            indegree[dep] += 1

        # print(indegree, preRequisiteMap)

        queue = collections.deque([])
        for idx, val in enumerate(indegree):
            if val == 0:
                queue.append(idx)
        result = []
        while queue:
            # print(queue,result)
            # size = len(queue)
            # for i in range(size):
            curr = queue.popleft()
            result.append(curr)
            if len(result) == numCourses:
                return True
            for i in preRequisiteMap[curr]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    queue.append(i)
        return False
