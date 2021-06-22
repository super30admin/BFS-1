# Time Complexity : O(v+e)
# Space Complexity : O(v+e)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#using queue to save all the courses with zero prereqs compelting them and updating the array so that next selection is from courses with no further prereqs needed
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == None or len(prerequisites) == 0:
            return True
        
        al = {}
        
        pc = [0]*numCourses
        
        for x in prerequisites:
            a = x[0]
            b = x[1]
            
            if b not in al:
                al[b] = []
            al[b].append(a)
            
            pc[a] += 1
        print(al,pc)
        queue = deque()
        count = 0
        for i in range(len(pc)):
            if pc[i] == 0:
                queue.append(i)
                count += 1
        
        while len(queue) != 0:
            x = queue.popleft()
            print(x)
            if x in al:
                for i in al[x]:
                    pc[i] -= 1
                    if pc[i] == 0:
                        queue.append(i)
                        count += 1
        return count == numCourses