# TC: O(V+E)
# SC: O(V+E)


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
      indegree=[0 for i in range(0,numCourses)]
      dict1={}

      for i in range(0,len(prerequisites)):
        indegree[prerequisites[i][0]]+=1
        if prerequisites[i][1] not in dict1:
          dict1[prerequisites[i][1]]=[prerequisites[i][0]]
        else:
          dict1[prerequisites[i][1]].append(prerequisites[i][0])

      q=deque()
      for i in range(0,len(indegree)):
        if indegree[i]==0:
          q.append(i)
      
      print(indegree,end=" ")
      print(dict1,end=" ")
      print(q)
      print()

      count=len(q)
      if count==numCourses:
        return True

      while q:
        h=q.popleft()
        if h in dict1:
          list1=dict1[h]
          for i in range(0,len(list1)):
            indegree[list1[i]]-=1
            if indegree[list1[i]]==0:
              q.append(list1[i])
              count+=1

      if count==numCourses:
        return True
      else:
        return False

        
      




        