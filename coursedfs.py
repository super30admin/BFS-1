# // Time Complexity :O(v+e) 
# // Space Complexity :O(v+e)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        print(prerequisites)
        dictionary={}
        indegree=[0]*numCourses
        queue=[]
        count=0
        for i in prerequisites:
            if i[1] not in dictionary.keys():
                dictionary[i[1]]=[]
            dictionary[i[1]].append(i[0])
            indegree[i[0]]=indegree[i[0]]+1
        print(indegree)
        for i in range(len(indegree)):
            if indegree[i]==0:
                queue.append(i)
                count=count+1
        print(dictionary)
        if not queue:
            return False
        while queue:
            val=queue.pop()
            if val in dictionary.keys():
                
                print(dictionary[val])
                for j in dictionary[val]:
                    print(indegree[j])
                    indegree[j]=indegree[j]-1
                    if indegree[j]==0:
                        queue.append(j)
                        count=count+1
                        print(queue)
        print(count)
        if count ==numCourses:
            return True
                
        
        
                
                
        