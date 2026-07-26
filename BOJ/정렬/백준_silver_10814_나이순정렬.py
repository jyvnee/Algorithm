import sys
input = sys.stdin.readline

n = int(input())
people = [input().split() for _ in range(n)]
people.sort(key=lambda x: int(x[0]))

for person in people:
    print(person[0], person[1])