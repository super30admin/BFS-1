# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites)==0: return True
        lis=[0 for i in range(numCourses)]
        a_list={}
        for l in (prerequisites):
            lis[l[0]]+=1
            if l[1] not in a_list:
                a_list[l[1]]=[]
            a_list[l[1]].append(l[0])
        from collections import deque
        q=deque()
        count=0
        for i in range(len(lis)):
            if lis[i]==0:
                q.append(i)
                count+=1
        # print(lis,a_list)
        while len(q)!=0:
            curr=q.popleft()
            # print(curr)
            if curr in a_list:
                for i in a_list[curr]:
                    lis[i]-=1
                    if lis[i]==0:
                        q.append(i)
                        count+=1
                        # print("count",count)
                        if count==numCourses: return True
        # for i in lis:
        #     if i !=0:
        #         return False
        return False