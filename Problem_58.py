########### O(V+E) time and space complexity ##########
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        h = {}
        if not prerequisites:
            return True
        indegrees = collections.deque()
        for i in range(numCourses):
            indegrees.append(0)
        
        print(indegrees)
        print(prerequisites)
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if edge[1] not in h.keys():
                h[edge[1]] = collections.deque()
            h[edge[1]].append(edge[0])
        
        q = collections.deque()
        print(indegrees)
        print(h)
        
        count = 0
        
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.appendleft(i)
                count += 1
        if not q:
            return False
        if count == numCourses:
            return True
        while q:
            curr = q.pop()
            # Reduce indegrees of dependants (babies)
            print(curr)
            children = collections.deque()
            if curr in h.keys():
                children = h[curr]
            for child in children:
                indegrees[child] -= 1
                if indegrees[child] == 0:
                    q.appendleft(child)
                    count += 1
                    if count == numCourses:
                        return True
        return False
