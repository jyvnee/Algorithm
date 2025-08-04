import sys
from collections import Counter

text = sys.stdin.read().strip()
char_count = Counter(char for char in text if char.isalpha())
max_char = max(char_count.values())


result = ''.join(sorted(char for char, count in char_count.items() if count == max_char))
print(result)