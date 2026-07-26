import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    scores = [tuple(map(int, input().split())) for _ in range(N)]
    scores.sort(key=lambda x: x[0])
    count = 0
    temp_score = N+1
    for i in range(N):
        if scores[i][1] < temp_score:
            count += 1
            temp_score = scores[i][1]
    print(count)