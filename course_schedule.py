class Solution:
    #time complexity:O(V+E)
    #space complexity:O(V+E)
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        array=[0]*numCourses
        res=defaultdict(list)
        for i in prerequisites:
            array[i[0]]+=1
            res[i[1]].append(i[0])
        queue=deque()
        for i in range(len(array)):
            if array[i]==0:
                queue.append(i)
        while queue:
            popped=queue.popleft()
            l=res[popped]
            for i in l:
                if array[i]>0:
                    array[i]-=1
                if array[i]==0:
                    queue.append(i)
        for i in range(len(array)):
            if array[i]!=0:
                return False
        return True