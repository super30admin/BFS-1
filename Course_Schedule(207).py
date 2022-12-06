# Time Complexity: O(V+E) since it is a graph
# Space Complexity: O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses==1 or len(prerequisites)==0:
            return True
        # to store the incoming edges of each course indicated by the index
        inbound = [0]*numCourses
        # To store the outgoing edges of each course, we would store a list as the values
        # since a course can be prereq for multiple courses
        hashmap = dict()

        for elem in prerequisites:
            dep = elem[0] #courses that have a prereq
            indep = elem[1] #courses that are a prereq for others
            inbound[dep]+=1 #dep is the element with an incoming edge from indep so we increment the inbound array
            # the indep element is a prereq for the dep
            # so we store it in a hashmap with indep as key and a list of deps as values
            if indep in hashmap:
                hashmap[indep].append(dep)
            else:
                hashmap[indep] = [dep]

        # we use a queue to maintain the list of elements that have their prereq condition satisfied
        # the idea is to use independent courses that might be prereqs for others
        # since they can be taken and completed, lifting the prereqs from the courses that depend on them
        queue = list()
        # if an element has no more incoming edges or has 0 prepreq then it is considered a completed course
        completedCourses = 0
        for i in range(numCourses):
            if inbound[i]==0:
                queue.append(i)
                completedCourses+=1

        # we pop the element in the queue
        # check if it has any outgoing edges in the hashmap
        # if it has any outgoing edges, we resolve those and decrement the incoming edges in the inbound array
        # and after updating the inbound array, the incoming edges are 0=> that the course can now be taken
        # making it a completed course
        while len(queue)!=0:
            curr = queue.pop(0)
            if curr in hashmap:
                for dep in hashmap[curr]:
                    inbound[dep]-=1
                    if inbound[dep]==0:
                        queue.append(dep)
                        completedCourses+=1

        # if the number of completed courses match the total number of courses then the schdedule is a valid one
        return completedCourses==numCourses

        # for elem in inbound:
        #     if elem!=0:
        #         return False
        # return True