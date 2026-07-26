import sys
input = sys.stdin.readline

N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]

total = 0

for coin in coins[::-1]:
    if K >= coin:
        count = K // coin
        total += count
        K -= count * coin
        if K == 0:
            print(total)
            break