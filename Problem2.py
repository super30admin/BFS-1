class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # Create Dicttionary with courses and empty lists(prereq)
        preMap = {i: [] for i in range(numCourses)}

        for course, prereq in prerequisites:
            preMap[course].append(
                prereq)  # This dictionary contains the courses and its prerequisites as Key values pair

        # visited set
        visit = set()

        # implementing dfs
        def dfs(crs):
            if crs in visit:
                return False
            if preMap[crs] == []:
                return True

            visit.add(crs)

            for prereq in preMap[crs]:
                if not dfs(prereq):
                    return False
            preMap[crs] = []
            visit.remove(crs)
            return True

        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True




