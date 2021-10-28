'''
Time: O(n)
Space: O(n)
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree=[0]*numCourses
        hashMap={}
        que=deque()
        for x in prerequisites:
            inDegree[x[0]]+=1
            if x[1] not in hashMap:
                hashMap[x[1]]=[]
            hashMap[x[1]].append(x[0])
        for x in range(numCourses):
            if inDegree[x]==0:
                que.append(x)
        while que:
            front=que.popleft()
            if hashMap.get(front):
                for children in hashMap.get(front):
                    inDegree[children]-=1
                    if inDegree[children]==0:
                        que.append(children)
        for x in inDegree:
            if x!=0:
                return False
        return True