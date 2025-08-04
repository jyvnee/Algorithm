import sys
input = sys.stdin.readline

n, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr.sort()

def count(mid):
    count = 1
    last_position = arr[0]

    for i in range(1, n):
        if arr[i] - last_position >= mid:
            count += 1
            last_position = arr[i]
    return count

left, right = 1, arr[-1] - arr[0]
while left <= right:
    mid = (left + right) // 2
    if count(mid) >= c:
        left = mid + 1
    else:
        right = mid - 1

print(right)