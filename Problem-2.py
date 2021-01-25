#Time Complexity :O(n)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegree=[0]*numCourses
        hmap={}
        queue=collections.deque()
        for i in prerequisites:
            arr=i
            indegree[arr[0]]+=1   
            if(arr[1] not in hmap):
                hmap[arr[1]]=[arr[0]]
            else:
                hmap[arr[1]].append(arr[0])
        
        for i in range(len(indegree)):
            if(indegree[i]==0):
                queue.append(i)
        counter=0
        while(len(queue)>0):
            curr=queue.popleft()
            counter+=1
            if(curr not in hmap):
                continue
            
            arr=hmap[curr]
            for i in arr:
                indegree[i]-=1
                if(indegree[i]==0):
                    queue.append(i)
     
        if(counter==numCourses):
            return True
        return False
        