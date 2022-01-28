class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def helper( prerequisites ):
            sorted_order = []
            courses_list = set([])
            indegree = collections.defaultdict(int)
            for i , j in prerequisites:
                courses_list.add(i)
                courses_list.add(j)
                indegree[j] += 1
                if i not in indegree:
                    indegree[i] = 0 
            q = []
            for key in indegree:
                if indegree[key] == 0 :
                    q.append(key)
            while q:
                curr = q.pop(0)
                sorted_order.append(curr)
                for i , j in prerequisites:
                    if i == curr:
                        indegree[j] -= 1
                        if indegree[j] == 0 :
                            q.append(j)
            return len(sorted_order) == len(courses_list)
        return helper( prerequisites )
                            
                        
                        
                        
                        
                        
                        
                
