class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0]*numCourses
        hashmap ={}
        count =0

        if not prerequisites:
            return True

        for i in prerequisites:
            indegrees[i[0]]+=1
            if i[1] not in hashmap.keys():
                hashmap[i[1]] = []
            hashmap[i[1]].append(i[0]) 

        q=[]
        for i,n in enumerate(indegrees):
          if n==0:
            q.append(i)
            count+=1

        if count== numCourses:
          return True
          
        while q:
          temp = q.pop(0)
          if temp in hashmap:
            if hashmap[temp]:
              temp1=hashmap[temp]
              for i in temp1:
                indegrees[i]-=1
                if indegrees[i]==0:
                  count+=1
                  q.append(i)

              if count==numCourses:
                return True

        return False


        