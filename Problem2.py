'''
1. Create a dictionary for quick lookup of prerequisites and an indegrees array.
2. Maintain a queue that keeps the track of courses that are independent.
3. For each course in the queue, check if it has any dependencies. If yes, reduce the indegree of the dependent course by 1.
4. If the indegree of the dependent course becomes 0, add it to the queue as it is now independent.

TC: O(V+E) 
SC: O(V+E) 
where V is the number of courses and E is the number of dependencies.
'''
from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if  len(prerequisites) == 0:
            return True

        dependency = {}
        indegrees = [0]*numCourses
        q = Queue()
        count = 0

        for prerequisite in prerequisites:
            From = prerequisite[0]
            To = prerequisite[1]

            indegrees[From] += 1

            if To not in dependency:
                dependency[To] = []
            dependency[To].append(From)

        for i in range(numCourses):
            if indegrees[i] == 0:
                q.put(i)
                count+=1
        
        while not q.empty():
            cur = q.get()
            if cur in dependency:
                subs = dependency[cur]
                for sub in subs:
                    indegrees[sub] -= 1
                    if indegrees[sub] == 0:
                        q.put(sub)
                        count+=1

        return count == numCourses
        

            