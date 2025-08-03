from itertools import permutations

N = int(input())

candidates = list(permutations('123456789', 3))
queries = []

for i in range(N):
    queries.append(list(map(str, input().split())))

count = 0
for cand in candidates:
    valid = True
    for q_num, q_s, q_b in queries:
        s_count = 0
        b_count = 0
        # strike 확인
        for i in range(3):
            if cand[i] == q_num[i]: s_count += 1
            elif q_num[i] in cand: b_count += 1
        
        if s_count == int(q_s) and b_count == int(q_b): continue
        else: valid = False
    if valid: count += 1

print(count)