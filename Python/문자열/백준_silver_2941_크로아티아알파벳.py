word = input()

# 크로아티아 알파벳 리스트
croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

# 각 크로아티아 알파벳을 *하나의 문자*로 치환
for c in croatia:
    word = word.replace(c, "*")  # 임의의 한 글자로 바꿈

print(len(word))  # 남은 글자의 수 == 알파벳 개수