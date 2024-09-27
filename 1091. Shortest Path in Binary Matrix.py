class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:

        """
        Recall that to find the shortest path in a graph, we should use Breadth-first Search (BFS).
        """
        if grid[0][0] is not 0 or grid[len(grid) - 1][len(grid[0]) - 1] is not 0:
            return -1
        q = deque()
        visited = set()
        i, j = 0, 0
        visited.add((i, j))
        q.append((i, j, 1))
        # grid[i][j]=2
        dirs = [[-1, -1], [1, 1], [-1, 1], [1, -1], [0, 1], [1, 0], [-1, 0], [0, -1]]
        while q:
            row, col, count = q.popleft()
            ###base case dont forget
            if row is len(grid) - 1 and col is len(grid[0]) - 1:
                return count
            # count+=1
            for d in dirs:
                nr = d[0] + row
                nc = d[1] + col
                if (nr, nc) in visited:
                    continue
                if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == 0 and (nr, nc) not in visited:
                    q.append((nr, nc, count + 1))
                    # grid[nr][nc]=2
                    visited.add((nr, nc))
                    if nr is len(grid) - 1 and nc is len(grid[0]) - 1:
                        return count + 1
                visited.add((nr, nc))
        return -1

#         if grid[0][0] is not 0 or grid[len(grid)-1][len(grid[0])-1] is not 0:
#             return -1
#         q=deque()
#         visited=set()
#         i,j=0,0
#         visited.add((i,j))
#         q.append((i,j, 1))
#         grid[i][j]=2
#         dirs=[[-1,-1],[1,1],[-1,1],[1,-1],[0,1],[1,0],[-1,0],[0,-1]]
#         while q:
#             row,col,count=q.popleft()
#             if row is len(grid)-1 and col is len(grid[0])-1:
#                 return count
#             # count+=1
#             for d in dirs:
#                 nr=d[0]+row
#                 nc=d[1]+col

#                 if 0<=nr<len(grid) and 0<=nc<len(grid[0]) and grid[nr][nc]==0 and (nr,nc) not in visited:
#                     q.append((nr,nc, count+1))
#                     grid[nr][nc]=2
#                     visited.add((nr,nc))
#                     if nr is len(grid)-1 and nc is len(grid[0])-1:
#                         return count+1


#         return -1


