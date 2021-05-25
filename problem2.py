from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites)==0:
            return True

        self.hashmap = dict()
        for i in range(len(prerequisites)):
            out = prerequisites[i][1]
            inc = prerequisites[i][0]
            if out in self.hashmap:
                self.hashmap[out].append(inc)
                print(out)
            else:
                self.hashmap[out] = [inc]
        self.visited = [False]*numCourses
        self.path = [False]*numCourses

        for i in range((numCourses)):
            if((self.visited[i] != True) and self.dfs(i)==True):
                return False

        return True
    def dfs(self,i):
        if self.path[i]==True:
            return True

        if self.visited[i]==True:
            return False

        self.path[i] = True
        self.visited[i] = True
        if i in self.hashmap.keys():
            neighbours = self.hashmap[i]
            for k in neighbours:
                if self.dfs(k)==True:
                    return True

        self.path[i]=False
        return False




        
