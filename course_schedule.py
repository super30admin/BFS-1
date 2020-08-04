class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites==None or len(prerequisites)==0:
            return True
        Hashmap=collections.defaultdict(list)
        for i in prerequisites:
            Hashmap[i[0]].append(i[1])
        checked=[False]*numCourses
        path=[False]*numCourses
        
        for curr in range(numCourses):
            if self.isCyclic(curr,Hashmap,checked,path):
                return False
        return True
    def isCyclic(self, curr, Hashmap, checked, path):
        if checked[curr]:
            return False
        if path[curr]:
            return True
        path[curr]=True
        ret=False
        for child in Hashmap[curr]:
            ret=self.isCyclic(child,Hashmap,checked,path)
            if ret:
                break
        path[curr]=False
        checked[curr]=True
        return ret
#Time-Complexity:O(M+N) where M is number of dependencies and N is number of courses
#Space-Complexity:O(M+N) where M is number of dependencies and N is number of courses