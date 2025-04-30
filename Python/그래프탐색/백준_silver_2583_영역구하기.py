import sys
sys.setrecursionlimit(10000)

M, N, K = map(int, input().split())

board = [[0] * N for _ in range(M)]

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for y in range(y1, y2):
        for x in range(x1, x2):
            board[y][x] = 1

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
square = []

def dfs(x, y, n, m, idx):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and board[ny][nx]==0:
            square[idx] += 1
            board[ny][nx] = 1
            dfs(nx, ny, n, m, idx)

count = 0
for i in range(M):
    for j in range(N):
        if board[i][j] == 0:
            square.append(1)
            board[i][j] = 1
            dfs(j, i, N, M, count)
            count += 1

print(count)
square.sort()
print(" ".join(map(str, square)))