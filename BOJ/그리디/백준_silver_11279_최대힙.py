import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []

for _ in range(N):
    operation = int(input())
    if operation == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -operation)