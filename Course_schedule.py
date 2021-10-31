# class CList:
    
#     def __init__(self,val,pre):
#         self.course = val
#         self.next = pre
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        Hashmap = {}
        Incoming = [0 for i in range(numCourses)]
        for pre in prerequisites:
            Incoming[pre[0]] += 1
            if pre[1] in Hashmap.keys():
                Hashmap[pre[1]].append(pre[0])
            else:
                Hashmap[pre[1]] = [pre[0]]
        
        Queue = []
        for i,val in enumerate(Incoming):
            if val == 0:
                Queue.append(i)
        
        while len(Queue) != 0:
            node = Queue.pop(0)
            if node in Hashmap.keys():
                for child in Hashmap[node]:
                    Incoming[child] -= 1
                    if Incoming[child] == 0:
                        Queue.append(child)
        for i,val in enumerate(Incoming):
            if val != 0:
                return False

        return True