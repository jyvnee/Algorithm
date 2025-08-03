import sys
input = sys.stdin.readline

n = int(input())
positions = [tuple(map(int, input().split())) for _ in range(n)]
positions.sort(key=lambda x: (x[0], x[1]))

for position in positions:
    print(position[0], position[1])