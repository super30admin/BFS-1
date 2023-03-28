#TC-O(V+E)
#SC-O(V+E)
#ran on leetcode-yes
#logic- create prerequisites array and inorder count array an decrease the count whenver,its parent node is complete
#add a node into li if its inorder is zero and increase count by 1,count which tracks no of courses completed
#should be equal to number of courses
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == []:
            return True
        inor = {}
        order ={i:0 for i in range(numCourses)}
        #create list of prereq and count
        for i in prerequisites:
            if i[1] not in inor:
                inor[i[1]]=[i[0]]
            else:
                inor[i[1]].append(i[0])
            if i[0] not in order:
                order[i[0]] = 1
            else:
                order[i[0]]+=1
            if i[1] not in order:
                order[i[1]]=0
        li = []
        count = 0
        m = 0
        for i,j in order.items():
            if j == m:
                li.append(i)
                count += 1
        while li:
            k = li.pop(0)
            if k not in inor:
                continue
            for i in inor[k]:
                order[i]-=1
                if order[i]==0:
                    li.append(i)
                    count+=1
                    if count==numCourses:
                        return True
        if count!=numCourses:
            return False
        else:
            return True


        
        