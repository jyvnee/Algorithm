from collections import defaultdict, deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = defaultdict(list)
visited = set()

for i in range(M):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

count = 0

for node in range(1, N+1):
    if node in visited: continue

    connected = deque([node])
    visited.add(node)
    while connected:
        current = connected.popleft()
        for neighbor in graph[current]:
            if neighbor not in visited:
                connected.append(neighbor)
                visited.add(neighbor)
    count += 1

print(count)
