import sys
input = sys.stdin.readlines

lines = input()

for i in range(len(lines)):
    l = lines[i].rstrip(".\n")
    if l == "": continue
    ps = []
    is_ps = True
    for c in l:
        if c=="(" or c=="[":
            ps.append(c)
        elif c==")":
            if not ps: 
                is_ps = False
                break
            elif ps.pop()=="(": continue
            else:
                is_ps = False
                break
        elif c=="]":
            if not ps: 
                is_ps = False
                break
            elif ps.pop()=="[": continue
            else: 
                is_ps = False
                break
    if len(ps)==0 and is_ps:
        print("yes")
    else:
        print("no")
        