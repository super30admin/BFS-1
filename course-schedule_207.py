#Time Complexity O(V+E) vertices and edges
#Space Complexity O(V+E) =>O(V) for storing indegree O(V+E) for storing adjacency list
#It successfully runs on leetcode

#Approach: TOPOLOGICAL SORT: we will create adjacency list for O(1) lookup of edges
#along with that will maintain array list indegree for maintaing each course dependecy numbers
#Queue will store independent courses and explore it one by one by reducing their indegree dependency
#if we can reach 0 for all courses(there is no cycle so we can return True), 
# that means all courses will be entering queue, so by keeping track of queue count we can track that


from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites: return True
        adl=defaultdict(list)
        indeg = [0]*numCourses
        count = 0
        q = deque()
        for dep,ind in prerequisites:
            adl[ind].append(dep)
            indeg[dep]+=1
        
        for i in range(len(indeg)):
            if indeg[i]==0:
                q.append(i)
                count+=1
        
        while q:
            cur = q.popleft()
            l = adl[cur]
            if l:
                for i in l:
                    indeg[i]-=1
                    if indeg[i]==0:
                        q.append(i)
                        count +=1
                        if count==numCourses: return True
        return False