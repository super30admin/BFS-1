// Time Complexity : O(V+E) //V=courses, E=prerequisite 
// Space Complexity :  O(V+E) //V=courses, E=prerequisite
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree=[0 for i in range(numCourses)]
        hashmap={}
        
        for x in prerequisites:
            fromm=x[1]          //
            to=x[0]             //
            
            inDegree[to]+=1     //create indegree list to store the no of incoming edges for each courses i.e, against index 
            
            if fromm not in hashmap:        //create hashmap where key is prerequisite course and value is list which contains courses that requrire key as prereuisite
                hashmap[fromm]=[]

            hashmap[fromm].append(to)
                
        print(inDegree)
        print(hashmap)
        queue=deque()       //create queue
        
        for i in range(len(inDegree)):
            if inDegree[i]==0:      //store all teh courses in the queue which have 0 prerequisites
                queue.append(i)
        
        print(queue)
        while len(queue)!=0:        //traverse the queue
            front=queue.popleft()       //pop the first node 
            if front in hashmap:         if thats prerequisite for other courses
                for i in hashmap[front]:       //reduce 1 from each course that depend on that prerequisite course and check if that course has no other prerequisite then store that course in queue
                    inDegree[i]-=1
                    if inDegree[i]==0:
                        queue.append(i)

        
        for i in inDegree:      //check inorderlist if any of the course has any incoming edge then we will return false
            if i!=0:
                return False
        return True     //otherwise return true as there is no cycles 
