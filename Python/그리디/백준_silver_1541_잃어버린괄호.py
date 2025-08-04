import sys

line = sys.stdin.readline().strip()
nums = line.split('-')

result = 0
for i in range(len(nums)):
    temp = 0
    if '+' in nums[i]:
        sub_nums = nums[i].split('+')
        temp += sum(int(n) for n in sub_nums)
    else:
        temp += int(nums[i])
    if i != 0:
        result -= temp
    else:
        result += temp

print(result)