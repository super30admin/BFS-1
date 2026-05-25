# Time Complexity --> O(V + E) where v is the number of vertices or courses and E is the number of edges or dependencies
# Space Complexity --> O(V + E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        hmap = {}
        indegree = [0 for i in range(numCourses)]
        for prereq in prerequisites:
            if prereq[1] not in hmap:
                hmap[prereq[1]] = []
            hmap[prereq[1]].append(prereq[0]) # Independent(Prereq) to Dependent mapping
            indegree[prereq[0]] += 1 # keep track of indegree

        q = deque()
        count = 0
        for i in range(len(indegree)):
            if indegree[i]==0:
                q.append(i)
                count += 1

        if count==numCourses: # If there are no courses with prereqs then return true
            return True 
        if len(q)==0:   # If there are no courses with 0 prereqs, then it is a cyclic graph and return False
            return False

        # Start with the independent courses and then look over all their dependent courses, reduce each of indegree by 1 and if all the indegrees get to 0 then return True
        while q:
            curr = q.popleft()
            if curr in hmap and len(hmap[curr])>0:
                for course in hmap[curr]:
                    indegree[course] -= 1
                    if indegree[course]==0:
                        q.append(course)
                        count += 1
                    if count==numCourses:
                        return True
        return False 
            

