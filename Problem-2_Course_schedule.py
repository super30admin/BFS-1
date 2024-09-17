# APPROACH  
# Time Complexity : O(V + E), E: len(prerequisites), V: numCourses
# Space Complexity : O(V + E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 0. edges are from independent node to dependent node
# 1. Build adjacency list using Hashmap (node as key and child as values)
# 2. Build indegree list (ind for each node) - store the incoming edges for each node
# 3. Have a queue and add first those courses whose inDegree is 0 (meaning no dependency (prerequisites)
# 4. Each time, I add a course to the queue, decreement the inDegree of it's children


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if len(prerequisites) == 0:
            return True
        
        inDegree, course_q, hashmap = [0 for _ in range(numCourses)], deque(), {}
        
        for ind in range(len(prerequisites)):
            if prerequisites[ind][1] in hashmap:
                hashmap[prerequisites[ind][1]].append(prerequisites[ind][0])
            else:
                hashmap[prerequisites[ind][1]] = [prerequisites[ind][0]]
                
            inDegree[prerequisites[ind][0]] += 1
        
        
        for ind in range(len(inDegree)):
            if inDegree[ind] == 0:
                course_q.append(ind)
                
                        
        while len(course_q) > 0:
            curr_course = course_q.popleft()
            if curr_course in hashmap and len(hashmap[curr_course]) > 0:
                for child in hashmap[curr_course]:
                    inDegree[child] -= 1
                    
                    if inDegree[child] == 0:
                        course_q.append(child)
                        
                        
        for ind in range(len(inDegree)):
            if inDegree[ind] != 0:
                return False
            
        return True
        
