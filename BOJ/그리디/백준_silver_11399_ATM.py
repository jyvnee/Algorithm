from itertools import permutations, accumulate

N = int(input())
times = list(map(int, input().split()))

times.sort()
result = sum(accumulate(times))

print(result)