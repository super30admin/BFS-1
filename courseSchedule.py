#Time complexity : O(V+E) i.e. number of vertex and edges of the graph as each vertex and edge gets visited
#Space complexity : O(V+E) i.e. hashmap stores V+E and indegree uses V storage i.e. 2V + E
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=UWwsFlt_xuo&ab_channel=%7BS30%7D
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0 or len(prerequisites) ==0:
            return True
        #creating hashmap for adjacency
        hashmap = {}
        #creating indegree array for each numCourses
        indegree= [0]*numCourses
        #putting the elements in hashmap and put values in indegree
        #edge1 is dependent 
        #edge2 is independent
        for edge1, edge2 in prerequisites:
            #increasing the indegree of the dependent edges
            indegree[edge1] +=1
            #adding the edge1 i.e dependent edge to the list of edge2
            #if edge1 ia already present then directly appending the value in the list
            if edge2 in hashmap:
                hashmap[edge2].append(edge1)
            #if independent node is not present then directly create list and add the edge 
            else:
                hashmap[edge2] = [edge1]
            
        
        queue = deque()
        #managing the count for the edges added in the list
        count = 0
        #putting elements in the queue which have indegree 0
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
                count +=1
        #processing till the queue gets empty
        while queue:
            #removing the first element of the queue
            course = queue.popleft()
            #if the element queue is in the hashmap then decreasing the indegree elements of the dependent edges and further checking if any indegree gets 0 after decrement then add to the queue
            if course in hashmap:
                for edge1 in hashmap[course]:
                    indegree[edge1] -= 1
                    if indegree[edge1] == 0:
                        queue.append(edge1)
                        count+=1
        #if the count gets equal to the numCourses then it get finish
        return count == numCourses
