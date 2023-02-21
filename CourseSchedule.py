#All TC passed on leetcode


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        #Here we use BFS approach. We use dictionay to keep track of each course's dependent courses. 
        #we use indegree array to keep track of indegree of each course. If course indegree is 0 then 
        #its independent hence we add it to queue. For each element poped from the queue we process 
        #its children using the dictionary. The indegree of its children is reduced by 1 and if any of 
        #the children reach indegree 0 then we add it to queue. At the end we check if count of courses 
        #added to queue is same as numCourses. If yes we return true else false.
        #time complexity - O(V+E) because it is the adjacenecy matrix we process
        #space compelxity - O(V+E) because it is the adjacenecy matrix we process
        dict = collections.defaultdict(list)
        indegree = [0]*numCourses
        count = 0

        for crs, pre in prerequisites:
            dict[pre].append(crs)
            indegree[crs]+=1
        
        queue = collections.deque()
        for i in range(len(indegree)):
            if indegree[i]==0:
                queue.append(i)
                count+=1

        while queue:
            node = queue.popleft()
            for child in dict[node]:
                indegree[child]-=1
                if indegree[child]==0:
                    queue.append(child)
                    count+=1
        
        return numCourses==count
            


        
        