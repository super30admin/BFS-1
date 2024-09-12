// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        incomingEdges=[0]*numCourses
        hashMap={}
        # define incomingEdges and adjacency list
        for i in range(len(prerequisites)):
            incomingEdges[prerequisites[i][0]]+=1
        for i in range(len(prerequisites)):
            if prerequisites[i][1] in hashMap:
                hashMap[prerequisites[i][1]]=hashMap.get( prerequisites[i][1],0)+[prerequisites[i][0]]
            
            else:
                hashMap[prerequisites[i][1]]=[prerequisites[i][0]]
        #find starting point
        queue=[]
        for i in range(len(incomingEdges)):
            if incomingEdges[i]==0:
                queue.append(i)
        if len(queue)==0:
            return False
        while len(queue)!=0: #BFS 
            poppedElement=queue.pop(0)
            if poppedElement in hashMap:
                for k in hashMap[poppedElement]: #topological sort is performed
                    incomingEdges[k]-=1
                    if incomingEdges[k]==0:
                        queue.append(k)
        print(incomingEdges)
        for i in incomingEdges:
            if i!=0:
                return False
        return True
 