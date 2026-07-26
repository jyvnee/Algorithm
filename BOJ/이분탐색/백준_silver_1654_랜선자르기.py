import sys
input = sys.stdin.readline

K, N = map(int, input().split())

lan = []
start = 1
end = 0
answer = 0

for i in range(K):
    x = int(input())
    lan.append(x)
    if x > end: end = x

while start <= end:
    mid = (start + end) // 2
    count = 0
    for line in lan:
        count += (line // mid)
    
    if count >= N:
        answer = mid    # 가능한 경우 -> 더 큰 길이도 시도
        start = mid + 1
    else:
        end = mid - 1

print(answer)