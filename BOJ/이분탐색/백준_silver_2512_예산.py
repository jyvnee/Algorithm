import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
M = int(input())

if sum(arr) <= M:
    print(max(arr))
    exit()

left, right = 0, max(arr)
answer = 0

while left <= right:
    mid = (left + right) // 2
    current_sum = sum(min(x, mid) for x in arr)

    if current_sum <= M:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)