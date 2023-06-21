'''
Problem: Course Schedule
Time Complexity: O(n + m), where n is edges in prerequisites and m in number of courses
Space Complexity: O(m)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        created adjacency list of edges
        created indegree array for nodes
        performed the topological sort by taking nodes with no dependency
'''

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)

        for p in prerequisites:
            graph[p[1]].append(p[0])

        indegree = [0] *  numCourses

        for p1,p2 in prerequisites:
            indegree[p1]+=1
        
        q = deque()
        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)

        seen = set()
        while q:
            ele = q.popleft()
            seen.add(ele)
            for nei in graph[ele]:
                indegree[nei]-=1
                if indegree[nei]==0:
                    q.append(nei)
        
        return len(seen)==numCourses