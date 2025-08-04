import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, end, weight):
    visited = [False] * (N + 1)
    queue = deque([start])
    visited[start] = True

    while queue:
        node = queue.popleft()
        if node == end:
            return True
        for neighbor, w in graph[node]:
            if not visited[neighbor] and w >= weight:
                visited[neighbor] = True
                queue.append(neighbor)
    return False

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
max_limit = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))
    max_limit = max(max_limit, c)

start, end = map(int, input().split())

left, right = 1, max_limit
answer = left

while left <= right:
    mid = (left + right) // 2
    if bfs(start, end, mid):
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)