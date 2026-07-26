N = int(input())
positive = []
negative = []
ones = 0
zeros = 0

for _ in range(N):
    x = int(input())
    if x > 1:
        positive.append(x)
    elif x == 1:
        ones += 1
    elif x == 0:
        zeros += 1
    else:
        negative.append(x)

positive.sort(reverse=True)
negative.sort()

total = 0

# 양수 처리
for i in range(0, len(positive)-1, 2):
    total += positive[i] * positive[i+1]
if len(positive) % 2 == 1:
    total += positive[-1]

# 음수 처리
for i in range(0, len(negative) - 1, 2):
    total += negative[i] * negative[i + 1]
if len(negative) % 2 == 1:
    if zeros > 0:
        zeros -= 1  # 음수 하나를 0으로 처리
    else:
        total += negative[-1]

# 1 처리
total += ones

print(total)