import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(N)]

queue = deque([(0, 0, 1)])
visited = [[False] * M for _ in range(N)]
visited[0][0] = True

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

while queue:
    x, y, depth = queue.popleft()
    if (x + 1) == N and (y + 1) == M:
        print(depth)
        break

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and graph[nx][ny] == 1:
            visited[nx][ny] = True
            queue.append((nx, ny, depth + 1))