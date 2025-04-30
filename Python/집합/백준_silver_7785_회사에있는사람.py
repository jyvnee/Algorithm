import sys
input = sys.stdin.readlines

lines = input()
n = int(lines[0])

stack = set()
for s in range(1, n+1):
    name, work = map(str, lines[s].strip().split(" "))
    if work=="enter":
        stack.add(name)
    elif work=="leave":
        stack.discard(name)

for name in sorted(stack, reverse=True):
    print(name)