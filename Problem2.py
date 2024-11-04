# Time Complexity : O(V + E)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Course Schedule

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0] * numCourses 
        graph = defaultdict(list) 

        for pr in prerequisites:
            indegrees[pr[0]] = indegrees[pr[0]] + 1            
            graph[pr[1]].append(pr[0]) 

        que = deque([i for i in range(numCourses) if indegrees[i] == 0])
        count = 0
        while que:
            course = que.popleft()
            count += 1
            for dependent in graph[course]:
                indegrees[dependent] -= 1
                if indegrees[dependent] == 0:
                    que.append(dependent)
        return count == numCourses