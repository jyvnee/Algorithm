import sys
input = sys.stdin.readline

n = int(input())
numbers = [int(input()) for _ in range(n)]
numbers.sort()

for num in numbers:
    print(num)