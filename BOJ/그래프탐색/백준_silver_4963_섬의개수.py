import sys
sys.setrecursionlimit(10000)    # 재귀 한도 높여주기

# 8 방향 이동 (상하좌우 + 대각선)
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

def dfs(row, col, w, h, graph):
    graph[row][col] = 0     # 방문 처리
    for i in range(8):
        nr = row + dr[i]
        nc = col + dc[i]

        if 0 <= nr < h and 0 <= nc < w and graph[nr][nc]==1:
            dfs(nr, nc, w, h, graph)

while True:
    w, h = map(int, input().split())
    if w == 0 and h ==0:
        break

    graph = []
    for _ in range(h):
        graph.append(list(map(int, input().split())))
    
    count = 0
    for r in range(h):
        for c in range(w):
            if graph[r][c] == 1:
                dfs(r, c, w, h, graph)
                count += 1
    
    print(count)