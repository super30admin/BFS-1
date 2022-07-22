# Time complexity: O(n)
# Space complexity: O(n)
# Approach : 
# while traversing the list of lists-prerequisites,
# create a hashmap with keys as a prereq course and array of dependencies as value 
# create an array with index numbers denoting the course and value denoting number of courses it depends on
# go through the array and push indexes in queues that have 0 dependencies
# or every course in queue, get all the dependencies from the hashmaop and reduce their value by 1 in the array, if the value becomes 0, add the course to the queue
# if all the values in array are 0 , return True else return false







class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses==1 or numCourses==0:
            return True

        #create hashmap and array
        hashmap={}
        indegrees=[0 for i in range(numCourses)]
        queue=[]

        for dependency in prerequisites:
            if dependency[1] not in hashmap:
                hashmap[dependency[1]]=[]
            hashmap[dependency[1]].append(dependency[0])
            indegrees[dependency[0]]+=1

        for i in range(numCourses):
            if indegrees[i]==0:
                queue.append(i)

        while(len(queue)!=0):
            course=queue.pop(0)

            if course in hashmap:
                for i in hashmap[course]:
                    indegrees[i]-=1
                    if indegrees[i]==0:
                        queue.append(i)
        for i in indegrees:
            if i!=0:
                return False
        return True
            
            
        
        