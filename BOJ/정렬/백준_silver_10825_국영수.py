import sys
input = sys.stdin.readline

n = int(input())
people = []

for _ in range(n):
    name, kor, eng, math = input().split()
    kor, eng, math = int(kor), int(eng), int(math)
    people.append((name, kor, eng, math))

people.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for person in people:
    print(person[0])