class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        #O(V+E)
        if numCourses==0:
            return True
        if not prerequisites:
            return True
        
        #prereq[courseno, prereq]
        
        #indegree array>>maintains count of precourses required for each course
        indegree=[0]*numCourses
        #indegree map>>maintains list of courses(values) that are dependent on particular prereq(key)
        indegreemap={}
        
        #maintain both structures together
        for i in range(len(prerequisites)):
            indegree[prerequisites[i][0]]+=1
            if prerequisites[i][1] not in indegreemap:
                indegreemap[prerequisites[i][1]]=[]
            indegreemap[prerequisites[i][1]].append(prerequisites[i][0])
        #bfs
        q=deque()
        #find courses that are independent and add them to queue(kind of copying tree structure with independent node as starter)
        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)
        
        while q:
            #independent course popped
            cur=q.popleft()
            #check how many courses are dependent on this as prereq
            if cur in indegreemap:
                children=indegreemap[cur]
                if children:
                    #for every dependent course, treat them now as independent for thiis prereq only and reduce count in indegree array
                    for child in children:
                        indegree[child]-=1
                        #once course becomes independent, append to queue
                        if indegree[child]==0:
                            q.append(child)
        #last check is any course still dependent?>>false
        for i in range(numCourses):
            if indegree[i]>0:
                return False
        return True
                
        