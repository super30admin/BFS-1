#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#create a adjacency list for graph. create a indegree array and caculate indegree of all nodes. Start a BFS traversal with the queue initialized with ndes who have indegree 0(this means that these courses have no prerequisites and a valid schedule will start from one of these). Once a node is processed, loop through its neighbors and decrement the indrgrees. If indegree of any neighbor becomes 0, then add it to Q. Finally when Queue has become empty, return true if indegrees of all nodes is 0 (which means all courses have been visited), else return false.
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        D={}
        indegree=[0]*numCourses
        for course in prerequisites:
            if(course[1] in D):
                D[course[1]].append(course[0])
            else:
                D[course[1]]=[course[0]]
            indegree[course[0]]+=1
        Q=[]
        for i in range(len(indegree)):
            if(indegree[i]==0):
                Q.append(i)
        
        while(Q):
            curr=Q[0]
            del(Q[0])
            if(curr not in D):
                continue
            for i in D[curr]:
                indegree[i]-=1
                if(indegree[i]==0):
                    Q.append(i)
        
        for i in indegree:
            if(i!=0):
                return False
        return True
