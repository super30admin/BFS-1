def __init__(self):
        self.visited = None
        self.stacker = None
        self.graph = defaultdict(list)
        
        
    # Build the dictionary 
    def BuildDict(self, prerequisites):
        for i,j in prerequisites:
            if j in self.graph.keys():
                self.graph[j].append(i)
            else:
                self.graph[j] = [i]
                
    # check for the cylic node
    def checkIscylic(self,node):
        self.visited[node] = True
        self.stacker[node] = True
        for childs in self.graph[node]:
            if self.visited[childs] == False:
                self.visited[childs] = True
                return self.checkIscylic(childs)
            else:
                if self.stacker[childs] == True:
                    return True
        self.stacker[node] = False
        return False
    
        
    def canFinish(self, numCourses, prerequisites):
        self.BuildDict(prerequisites)
        self.visited = [False] * numCourses
        self.stacker = [False] * numCourses
        for course in range(numCourses):
            if self.visited[course] == False:
                if self.checkIscylic(course):
                    return False
        return True
        