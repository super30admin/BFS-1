class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        """
        TC- O(v+e)
        SC- O(v+e)
        """
        hashmap = {}
        ans = []
        indegree = [0] * numCourses
        for course in prerequisites:
            if course[1] in hashmap:
                hashmap[course[1]].append(course[0])
            else:
                hashmap[course[1]] = [course[0]]
            indegree[course[0]] += 1

        q = collections.deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                indegree[i] -= 1

        while q:
            curr = q.popleft()
            ans.append(curr)
            children = hashmap.get(curr)
            if children is not None:
                for child in children:
                    indegree[child] -= 1
                    if indegree[child] == 0:
                        q.append(child)

        if len(ans) == numCourses:
            return ans
        else:
            return []








