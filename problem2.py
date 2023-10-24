# Time Complexity : O(V+E)
# Space Complexity :O(V+E)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we are first creatign an indegree list and then an adjacency list for the graph with a mapping from independant node to dependant nodes
# npw we add the nodes with an indegee of 0 to the queue (independnt nodes). when we pop the queue, we decrese the indgeree of those popped nodes
# from the indegree list. and add nods with 0 indegree.meanwhile keep a count of courses we take by adding count++ whenever a cours eis added to the queue. 
# at te end if this count==numcourses, then return true else false

    class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        mydict = {i: [] for i in range(numCourses)}
        indegree=[0]*numCourses
        for prereq in prerequisites:
            inn=prereq[0]
            outt=prereq[1]
            indegree[inn]+=1
            # if(outt not in mydict):
            #     mydict[outt]=[]
            mydict[outt].append(inn)
        print(mydict)
        myq=[]
        count=0
        for i in range(numCourses):
            if(indegree[i]==0):
                myq.append(i)
                count+=1
        print(indegree)
        if(count==numCourses):
            return True
        if(len(myq)==0):
            return False
        while(len(myq)>0):
            curr=myq.pop(0)
            print(curr)
            babies=mydict[curr]
            for baby in babies:
                indegree[baby]-=1
                if(indegree[baby]==0):
                    myq.append(baby)
                    count+=1
        return count==numCourses