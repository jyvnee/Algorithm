import sys
input = sys.stdin.readline

n = int(input())
words = [input().strip() for _ in range(n)]
words = sorted(set(words), key=lambda x: (len(x), x))

for word in words:
    print(word)