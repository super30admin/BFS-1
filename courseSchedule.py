# // Time Complexity : O(E+V) : O(E) for hmap O(V) for and while loops
# // Space Complexity :O(E+V) : all three data structures(q,hmap,indegrees)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Struggled with the while loop 



from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 3 datastructures for indegrees, queue and hmap
        indegrees = [0] *numCourses             # [1,2,0,1,0] pre-reqeisites for each course number
        hmap = {}                               # {course: list of courses} //adjacency list
        
        # Create hashmap and store [1:1*, 2:2*]
        for p in prerequisites:
            indegrees[p[0]] += 1
        if p[1] not in hmap:
            hmap[p[1]] = []
        hmap[p[1]].append(p[0])
        
        # create queue and find indegress which are independant and initialize the queue
        count = 0
        q = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count +=1
        # process the queue;  if indegrees is 0 that means its parents are processed.Increment counter
        while q:
            curr = q.popleft()
            dependants = hmap.get(curr)     #no alternative
            if dependants:
                for d in dependants:            # same as above BUT with indegree -=1
                    indegrees[d]-=1
                    if indegrees[d] == 0:
                        q.append(d)
                        count +=1

        if count == numCourses: return True         # Final counter should always be equal to total courses
        return False