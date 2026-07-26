import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    operator = input().rstrip()
    n = int(input())
    string = input().strip()[1:-1]

    if string:
        array = deque(map(int, string.split(',')))
    else:
        array = deque()

    is_error = False
    is_reversed = False

    for op in operator:
        if op == "R":
            is_reversed = not is_reversed
        elif op == "D":
            if not array:
                is_error = True
                break
            if is_reversed:
                array.pop()
            else:
                array.popleft()
    
    if is_error:
        print("error")
    else:
        if is_reversed:
            array.reverse()
        print("[" + ",".join(map(str, array))+ "]")