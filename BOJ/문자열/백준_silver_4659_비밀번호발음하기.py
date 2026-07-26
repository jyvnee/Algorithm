vowel = ['a', 'e', 'i', 'o', 'u']
consonant = ['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r','s', 't', 'v', 'w', 'x', 'y', 'z']

while True:
    password = input()
    if password == "end": break

    is_good = True
    if not any(v in password for v in vowel):
        is_good = False
    
    for i in range(2, len(password)):
        if all(char in vowel for char in (password[i], password[i-1], password[i-2])):
            is_good = False
        elif all(char in consonant for char in (password[i], password[i-1], password[i-2])):
            is_good = False

    for i in range(1, len(password)):
        if password[i] == password[i-1] and password[i] in ['e', 'o']:
            is_good = True
        elif password[i] == password[i-1]:
            is_good = False
    
    if is_good:
        print(f"<{password}> is acceptable.")
    else:
        print(f"<{password}> is not acceptable.")