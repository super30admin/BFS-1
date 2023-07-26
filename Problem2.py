#Time Complexity :O(V+E)
#Space Complexity :O(V+E)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        courseMap={}
        array=[0]*(numCourses)
        q=deque()
        count=0
        for pre in prerequisites:
            array[pre[0]]+=1
            if pre[1] not in courseMap.keys():
                courseMap[pre[1]]=[]
            courseMap.get(pre[1]).append(pre[0])
        
        for i in range(len(array)):
            if array[i]==0:
                q.append(i)
                count+=1

        if not q:
            return False

        while q:
            curr=q.popleft()
            childrens=courseMap.get(curr)
            if childrens:
                for child in childrens:
                    array[child]-=1
                    if array[child]==0:
                        q.append(child)
                        count+=1
                    if count==numCourses:
                        return True
            print(array,count)
        return False

        