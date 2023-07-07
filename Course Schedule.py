# Time complexity : O(E + V), number of edges and vertices
# Space complexity : O(E + V), number of edges and vertices
# The code ran on Leetcode

# Maintain a hashmap to store all courses that are dependent on course i. A counter array to store how many dependencies it has. Add all courses that are independent at the start to a queue and pop them one be one. Process these nodes by removing the dependency on this popped courses. If a new node becomes independent, add it to the queue and repeat the process

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        cmap = {}
        array = [0]*(numCourses)

        for a, b in prerequisites:
            if b in cmap:
                cmap[b].append(a)
            else:
                cmap[b] = [a]
            array[a] += 1

        queue = deque()
        cnt = 0

        for i in range(len(array)):
            if array[i] == 0:
                queue.append(i)
                cnt+=1
        if cnt == 0:
            return False
        
        while queue:
            size = len(queue)
            for _ in range(len(queue)):
                cur = queue.popleft()

                if cur in cmap:
                    for n in cmap[cur]:
                        array[n] -= 1
                        if array[n] == 0:
                            queue.append(n)
                            cnt+=1
        return cnt == numCourses
