import sys
input = sys.stdin.readline

n = int(input())
arr1 = list(map(int, input().split()))
arr1.sort()

m = int(input())
arr2 = list(map(int, input().split()))

for x in arr2:
    left, right = 0, n - 1
    found = False
    while left <= right:
        mid = (left + right) // 2
        if arr1[mid] == x:
            found = True
            break
        elif arr1[mid] < x:
            left = mid + 1
        else:
            right = mid - 1
    print(1 if found else 0)