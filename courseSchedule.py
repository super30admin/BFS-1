# // Time Complexity : O(V+E)
# // Space Complexity : O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## we basically have to make sure that we are able to do all courses. so we create an adjacency list of independent nodes to 
## a list of dependent nodes. now we also find out all independent nodes and put them in a queue to be processed. 
## aand also keep a count of them. if we are able to process all the nodes then we return True. 
## now we proces all elements in queue such that we get the children of dependents and reduce their dependency count 
## in the indegree array. and if they dependency = 0 we add it to the queue and increase the count of processed courses.
## we also check at any given stage if count == numCOurses then return True
class solution:
    def courseSchedule(self, numCourses, prerequisites):

        adjList = defaultdict(list)
        indegree = []*numCourses
        for i in prerequisites:
            adjList[i[1]].append(i[0])
            indegree[i[0]]+=1
        count = 0
        queue = collections.deque()
        for i in range(len(indegree)):
            if indegree[i]==0:
                queue.append(i)
                count+=1
        

        while queue:

            for i in range(len(queue)):
                curr = queue.pop()

                if adjList[curr]:
                    for child in adjList[curr]:
                        indegree[child]-=1
                        if indegree[child]==0:
                            queue.append(child)
                            count+=1

                            if count == numCourses: return True
        
        return numCourses == count
        
        