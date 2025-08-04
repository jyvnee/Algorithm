import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))
trees.sort()

left, right = 0, max(trees)
while left <= right:
    mid = (left + right) // 2
    total = sum(max(0, tree - mid) for tree in trees)

    if total >= m:
        left = mid + 1
    else:
        right = mid - 1

print(right)