# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : when ever 
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if prerequisites==None or len(prerequisites)==0 : return True
        indegrees=[0 for i in range(numCourses)]
        map1={}
        for i in range(0,len(prerequisites)):
            indegrees[prerequisites[i][0]]+=1
            if not prerequisites[i][1] in map1:
                map1[prerequisites[i][1]]=[]
            map1[prerequisites[i][1]].append(prerequisites[i][0])
        print(map1)
        q=[]
        count=0
        for i in range(0,len(indegrees)):
            if(indegrees[i])==0:
                q.append(i)
                count+=1
        print(q)
        while q :
            curr=q[0]
            q=q[1:]
            print(curr)
            if curr in map1:
                li=map1[curr]
                if li:
                    for i in li:
                        indegrees[i]-=1
                        if indegrees[i]==0:
                            q.append(i)
                            count+=1
                            if count==numCourses: return True
                        
        if count==numCourses: return True
        return False
                    
                    
            
            
        