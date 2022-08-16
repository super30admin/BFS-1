# Time complexity : O(V + E)
# Space complexity : O(V + E)
# Leetcode : Solved and submitted

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
      
        # create an indegree array to keep track of required courses
        ind = [0]*numCourses
        
        # haspmap to know the dependent courses
        edges = { i : [] for i in range(numCourses) }

        # return true if the list is empty
        if not prerequisites or len(prerequisites) == 0:
            return True
          
        #   Update indegrees Array and children HashMap in parallel
        for edge in prerequisites:
            ind[edge[0]] += 1
            edges[edge[1]].append(edge[0])
            
        # making a queue and keeping track of the count
        q = deque()
        count = 0
        
        # append the independent courses into the queue and increment the count
        for i in range(numCourses):
            if ind[i] == 0:
                q.append(i)
                count += 1
        
        # if queue is empty, such that there are no independent courses, or there is no dependency, then we can return False
        if len(q) == 0:
            return False
        if count == numCourses:
            return False
        
        # we traverse over the queue, for each dependent course in hasmap, we reduce the indegree and append the ones with 0 indegree and continue
        # at the end, if there are elements, then return False, else return True
        while q:
            curr = q.popleft()
            for course in edges[curr]:
                ind[course] -= 1
                
                if ind[course] == 0:
                    q.append(course)
                    count += 1
                if count == numCourses:
                    return True
        return False
        
