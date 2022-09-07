# // Time Complexity : O(E+V) 
# // Space Complexity : O(E+V) 
# // Did this code successfully run on Leetcode : yes
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites)==0:
            return True
        holder=[0]*numCourses
        for i in range(len(prerequisites)):
            holder[prerequisites[i][0]]+=1
            stack=[]
        for i in range(0, len(holder)):
            if holder[i]==0:
                stack.append(i)
        count=0
                
        while stack:
            cur=stack.pop()
            count+=1
            #process the node
            for i in range(len(prerequisites)):
                if prerequisites[i][1]==cur:
                    holder[prerequisites[i][0]]-=1
                    if holder[prerequisites[i][0]]==0:
                        stack.append(prerequisites[i][0])
        return count==numCourses