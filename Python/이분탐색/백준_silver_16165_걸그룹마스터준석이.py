from collections import defaultdict

N, M = map(int, input().split())

idols = defaultdict(list)

for _ in range(N):
    team = input()
    num = int(input())
    members = []

    for _ in range(num):
        members.append(input())
        members.sort()
    
    idols[team] = members

for _ in range(M):
    quiz = input()
    quiz_type = int(input())

    if quiz_type:
        for key, value in idols.items():
            if quiz in value:
                print(key)
                break
    else:
        for member in idols[quiz]:
            print(member)