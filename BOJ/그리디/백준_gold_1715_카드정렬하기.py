import sys
import heapq
input = sys.stdin.readline

N = int(input())
cards = []

for _ in range(N):
    card = int(input())
    heapq.heappush(cards, card)

total = 0
while len(cards) > 1:
    first = heapq.heappop(cards)
    second = heapq.heappop(cards)
    total += first + second
    heapq.heappush(cards, first + second)

print(total)