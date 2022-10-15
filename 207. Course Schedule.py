#BFS
# TC - O(V+E) V=courses ,E=Prereqs
# SC - O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
                
        base_dict = defaultdict(set) # Collect base course for advance course
        adv_dict = defaultdict(set) # Collect advanced course for base course
        
        for a, b in prerequisites:
            base_dict[a].add(b)
            adv_dict[b].add(a)
        
        learning = collections.deque()
        for course in range(numCourses):
            if not base_dict[course]:
                learning.append(course)
        
        learned_count = 0
        while learning:
            base = learning.popleft()
            learned_count += 1
            
            for adv in adv_dict[base]:
                base_dict[adv].remove(base)
                if not base_dict[adv]:
                    learning.append(adv)
        
        return learned_count == numCourses


#DFS
# TC - O(V+E) V=courses ,E=Prereqs
# SC - O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
# 0: unlearned, 1: learning, 2: learned
        self.course_status = [0] * numCourses
        
        # Collect advanced course for base course
        self.course_dict = collections.defaultdict(set)
        for a, b in prerequisites:
            self.course_dict[b].add(a)
        
        for course in range(numCourses):
            if self.dfs_is_cycle(course): return False
        return True
                
    def dfs_is_cycle(self, course):
        if self.course_status[course] == 1:
            return True
        if self.course_status[course] == 2:
            return False
        
        self.course_status[course] = 1
        for adv in self.course_dict[course]:
            if self.dfs_is_cycle(adv): return True
        self.course_status[course] = 2
        return False