import sys
input = sys.stdin.readline

N = int(input())
a_arr = list(map(int, input().split()))
b_arr = list(map(int, input().split()))

a_arr.sort()
b_arr.sort(reverse=True)

total = sum(a * b for a, b in zip(a_arr, b_arr))
print(total)