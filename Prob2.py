# Time complexity : O(E + V), number of edges and vertices
# Space complexity : O(E + V), number of edges and vertices
# Method 1 - BFS+Adjacency list+Topological sort
# Build a adjacency list of independent to dependent courses and indegree array (topological sort)
#first, add all independent nodes and visit them all
# Then, go to arr[dependent] (get dependents from the adjacenecy lsit) and decrease by 1.
# If arr[dependent]==0, add to q and iterate next round.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if not prerequisites or len(prerequisites)==0: return True #if no prereqs, no cycle - all courses can be done
        indegree=[0 for _ in range(numCourses)] #topological sorting
        adjacency_list={} #using a hasmap instead of list of list for O(1) search

        for x,y in prerequisites: #build adjacency list and indegree array
            indegree[x]+=1
            if y in adjacency_list:
                adjacency_list[y].append(x)
            else:
                adjacency_list[y]=[x]
        
        q=deque()
        c=0
        for i in range(numCourses): #first, add all independent nodes and visit them all
            if indegree[i]==0:
                q.append(i)
                c+=1
        if c==0: return False #if no independent, can't take finsih all courses - cycle
        if c==numCourses: return True # if all courses are independent, can take all courses - no cycle
        
        while q:
            size=len(q) 
            for _ in range(size): #go over current size of queue
                cur=q.popleft()
                if cur in adjacency_list: #if cur is independent, decrease val in the indegree array for dependent
                    for i in adjacency_list[cur]:
                        indegree[i]-=1
                        if indegree[i]==0: #if the dependent becomes independent, add to q and visit it in the next iteration
                            q.append(i)
                            c+=1
                            if c==numCourses: return True # if all courses are independent, can take all courses - no cycle          
        return False

