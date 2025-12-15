# Initialize a queue q and an indegree list with values 0 for numCourses no. of elements.
# Assign empty list for adjacency list for 0 to numCourses value. Loop through prerequisites i
# and increment indegree[i] by 1 and also append the element at [0] to the adj matrix.
# Loop through indegree and if the element is 0 add the index to the queue q. WHile q is not empty
# pop the vlaue from the left and check its key on adj matric and the indegree indexes with its's value will be 
# decremented. If any value reached 0, that index is added to the queue
# Lastly, looop through indegree array, if any value is not 0, then return false else return true

# Time: O(V+E)
# Space:O(V+E)

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        q=deque()
        indegree=[0 for i in range(numCourses)]
        adj_m={}
        for i in range(numCourses):
            adj_m[i]=[]
        # print("adj", adj_m)
        for i in prerequisites:
            indegree[i[0]] =indegree[i[0]]+1
        
            adj_m[i[1]].append(i[0])
            
        # print("ind",indegree) 
        # print("adj_m",adj_m)
        for ind, i in enumerate(indegree):
            if i ==0:
                q.append(ind)
        # print('queue===',q)
        if not q:
            return False
        while q:
            p=q.popleft()
            # print('ad',adj_m, p, q)
            x=adj_m[p]
            for i in x:

                indegree[i]=indegree[i]-1
                if indegree[i]==0:
                    q.append(i)
        # print(q,'k', indegree)
        for i in indegree:
            if i!=0:
                return False

        return True           