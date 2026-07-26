import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(start, visited):
    visited[start] = True
    print(start, end=' ')
    for neighbor in sorted(graph[start]):
        if not visited[neighbor]:
            dfs(neighbor, visited)

visited = [False] * (N + 1)
dfs(V, visited)
print()

def bfs(start):
    queue = deque([start])
    visited = [False] * (N + 1)
    visited[start] = True
    while queue:
        node = queue.popleft()
        print(node, end=' ')
        for neighbor in sorted(graph[node]):
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)

bfs(V)