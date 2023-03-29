# Time Complexity: O(O + V) O being the numCourses and V being the length of prerequisites array
# Space Complexity: O(O + V)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # Create Indegrees list
        in_degrees = [0] * numCourses
        hmap = defaultdict(list)
        for i, v in prerequisites:
            in_degrees[i] += 1
            # Creating a hashmap of prerequisites
            hmap[v].append(i)
        # print(in_degrees)
        # print(hmap)
        # Creating a Queue storing nodes that are independent, ie with value 0
        Q = collections.deque()
        count = 0  # To keep track of nodes processed
        for i in range(len(in_degrees)):
            if in_degrees[i] == 0:
                Q.append(i)
                count += 1

        # Traverse through indegree and start with nodes that are independent, ie nodes with value 0 in in_degrees list
        p1 = 0
        while Q:
            p1 = Q.popleft()
            if in_degrees[p1] == 0:
                # Subtract their dependency after traversing each node with value 0
                for i in hmap[p1]:
                    in_degrees[i] -= 1
                    if in_degrees[i] == 0:
                        Q.append(i)
                        count += 1

        return True if count == numCourses else False
