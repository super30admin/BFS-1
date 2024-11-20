from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indeg = [0] * numCourses
        map = {}
        for prereq in prerequisites:
            dependent = prereq[0]
            independent = prereq[1]
            if independent not in map.keys():
                map[independent] = [dependent]
            else:
                map[independent].append(dependent)
            
            indeg[dependent] += 1
        
        print(map)
        print(indeg)

        q = Queue(maxsize = numCourses)
        count = 0

        for i in range(len(indeg)):
            if indeg[i] == 0:
                q.put(i)
                count += 1
        
        if count == numCourses:
            return True
        if q.empty():
            return False
        
        while not q.empty():
            curr = q.get()
            dependencies = []
            if curr in map.keys():
                dependencies = map[curr]

            if len(dependencies) != 0:
                for dependency in dependencies:
                    indeg[dependency] -= 1
                    if indeg[dependency] == 0:
                        q.put(dependency)
                        count += 1
                        if count == numCourses:
                            return True
        return False
