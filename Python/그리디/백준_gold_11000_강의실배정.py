import sys
import heapq
input = sys.stdin.readline

N = int(input())
classes = [tuple(map(int, input().split())) for _ in range(N)]
classes.sort()

rooms = []
heapq.heappush(rooms, classes[0][1])

for i in range(1, N):
    start, end = classes[i]
    if start >= rooms[0]:
        heapq.heappop(rooms)
    heapq.heappush(rooms, end)

print(len(rooms))