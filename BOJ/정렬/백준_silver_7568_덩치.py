people = int(input())

weight = []
height = []
for i in range(people):
    x, y = map(int, input().split())
    weight.append(x)
    height.append(y)

for i in range(people):
    count = 1
    for j in range(people):
        if i != j:
            if weight[i] < weight[j] and height[i] < height[j]:
                count += 1
    print(count, end=" ")