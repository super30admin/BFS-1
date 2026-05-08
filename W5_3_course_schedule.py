class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # Maintain a list
        indegrees = [0] * numCourses

        # Maintain a hashmap
        outdegree_graph = {}

        # We initialize the indegree by going over prerequisities and outdegrees by using a hashmap
        for pre in prerequisites:
            indegrees[pre[0]] = indegrees[pre[0]] + 1

            if pre[1] not in outdegree_graph:
                outdegree_graph[pre[1]] = []

            outdegree_graph[pre[1]].append(pre[0])

        q = deque()
        count = 0

        for i in range(0, numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count = count + 1

        if count == numCourses:
            return True
        
        # if Queue is empty
        if not q:
            return False
        
        while q:
            curr = q.popleft()

            # self-note: Do not use outdegree_graph.get[curr]
            dependencies = outdegree_graph.get(curr)

            if dependencies:
                for dep in dependencies:
                    indegrees[dep] = indegrees[dep] - 1
                    if indegrees[dep] == 0:
                        q.append(dep)
                        count = count + 1

                        if count == numCourses:
                            return True 

        return False

# time complexity: O(v + e)
# space complexity: O(v + e)

