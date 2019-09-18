from collections import defaultdict
class Solution(object):
    def __init__(self):
        self.adj_list = defaultdict(list)
        self.visited_course_list = []
        
    def detect_cycle_using_DFS(self, value, white, black, gray):

        for neighbor in self.adj_list.get(value, []):
            if neighbor in black:
                continue
            elif neighbor in gray:
                return False
            else:
                white.remove(neighbor)
                gray.append(neighbor)
                if not (self.detect_cycle_using_DFS(neighbor,  white, black, gray)):
                    return False

        gray.remove(value)
        black.append(value)
       
        return True
                
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        white = set()
        for pre_req in prerequisites:
            if len(pre_req) > 1:
                self.adj_list[pre_req[0]].append(pre_req[1])
                white.add(pre_req[0])
                white.add(pre_req[1])

        #white = self.adj_list.keys()
        white = list(white)
        black = []
        gray = []

        while len(white) != 0:
            value = white.pop()
            gray.append(value)
            
            if not self.detect_cycle_using_DFS(value, white, black, gray):
                return False
       
        return True
            
                                         
 # Time complexity: O(n)
 # Space complexity: O(n)