#TC:O(M+N) SC:(M+N)
#Graph problem

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        array=[]
        dic={}
        queue=[]
        count = 0
        
        for i in range(numCourses):
            array.append(0)

        for i in prerequisites:
            array[i[0]]+=1
            if i[1] in dic:
                dic[i[1]].append(i[0])
            else: 
                dic[i[1]]=[i[0]]      

        for i,val in enumerate(array):
            if val==0:
                count+=1
                queue.append(i)

        if queue==None:
            return False

        while queue!=[]:
            curr=queue.pop(0)
            if curr not in dic:
                continue
            else:
                for j in dic[curr]:
                    array[j]-=1
                    if array[j]==0:
                        count+=1
                        queue.append(j)

        return count==numCourses
