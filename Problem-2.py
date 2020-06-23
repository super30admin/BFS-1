# Time Complexity :O(m*n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        #create an array with number of courses all set to zero
        count = 0
        numofpre = [0]* numCourses
        #for each course add the number of its prerequisets
        for i in prerequisites:
            numofpre[i[0]] +=1
        
        stack = []
        #if a course doesn't have pre reqs add to the stack iterator
        for i in range(len(numofpre)):
            if numofpre[i] == 0:
                stack.append(i)
                count +=1
                
        sol = []
        #while stack
        while stack:
            #check one of the courses that has been done
            curr = stack.pop()
            #delete 1 for the number of pre reques of all courses that depend on current
            for i in prerequisites:
                if i[1] == curr:
                    numofpre[i[0]] -=1
                    #if this was the last pre recks append to stack
                    if numofpre[i[0]] == 0:
                        stack.append(i[0])
                        count +=1
                #if you did all courses return true
        return count == numCourses