# GRAPHS Problem

#Time Complexity : O(V+E) where V is the vertices of the graph (numCourses) and E is the edges of the graph (given list of prerequisites)
#Space Complexity : O(V+E) that is the space required by the map used
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We create an indegree array of length numCourses with count of the dependency of that index from the prerequisites. If 
# the value at any particular index is 0, it means that courses is independent. We also create a map with independent values as the key,
# and dependent values as the value to that key. We create a queue and add the indexes from the indegree array whos value is 0. 
# and increase a count variable. If the queue is empty, we return false. While q is not empty, we pop a value and get the values from the 
# map corresponding to that popped value. For the these values, we decrement the indegree array for that particular index. Now,
# if this indegree array value becomes 0, we add it into the queue and increment the counter. In the endm if the counter is equal to
# the number of courses, we return True.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites: return True
        mapp = {}
        indegree = [0] * numCourses
        for pr in prerequisites:
            indegree[pr[0]] += 1
            if pr[1] not in mapp:
                mapp[pr[1]] = []
            mapp[pr[1]].append(pr[0])
        count = 0
        q = deque()
        for i in range(0, len(indegree)):
            if indegree[i] == 0:
                q.append(i)
                count += 1
        if not q: return False
        while q:
            curr = q.popleft()
            children = mapp.get(curr, [])
            if children != []:
                for child in children:
                    indegree[child] -= 1
                    if indegree[child] == 0:
                        q.append(child)
                        count += 1
                        if count == numCourses: return True
        return False
