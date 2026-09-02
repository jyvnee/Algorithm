# 전력망을 둘로 나누기

## 알고리즘 분류

- 완전탐색 (Brute Force)
- 그래프 / 트리
- BFS

## 문제 정의

- `n`개의 송전탑이 `n-1`개의 전선으로 연결된 **트리**가 주어진다.
- 전선 하나를 끊으면 트리는 정확히 두 개의 연결 요소로 나뉜다.
- 모든 전선을 하나씩 끊어보고, 두 전력망의 송전탑 개수 차이(절대값)의 **최솟값**을 구한다.
- 제한: `2 ≤ n ≤ 100`, `wires.length == n-1`.

핵심 조건은 "입력이 항상 트리"라는 점이다. 따라서 어떤 전선을 끊어도 두 조각으로만 나뉘며, 한쪽의 크기를 세면 다른 쪽은 `n - count`로 바로 결정된다.

## 풀이 기록

### v1

#### 풀이 아이디어

- `wires`의 길이가 `n-1 ≤ 99`로 매우 작으므로, **모든 전선을 하나씩 끊어보는 완전탐색**이 충분하다.
- 인접 리스트를 `Map<Integer, Set<Integer>>`로 구성한다.
- 각 전선 `wires[i]`를 "끊긴 전선"으로 지정하고, 1번 노드에서 BFS를 수행하되 끊긴 전선은 건너뛴다.
- BFS로 방문한 노드 수 `count`가 한쪽 전력망의 크기이고, 나머지가 `n - count`이다.
- `|count - (n - count)|`의 최솟값이 답이다.

자료구조 선택 이유

- 인접 정보를 `Set`으로 저장해 특정 노드에 연결된 이웃을 `O(1)`에 순회한다. (트리라 중복 간선이 없어 `List`여도 무방하지만 `Set`으로 안전하게 처리)
- BFS 큐로 `ArrayDeque` 사용.

#### 알고리즘 풀이

1. **그래프 구성**
   - 모든 `wires[i] = [a, b]`에 대해 `map[a].add(b)`, `map[b].add(a)`로 양방향 인접 리스트를 만든다.
   - `computeIfAbsent(key, k -> new HashSet<>())`로 키가 없을 때만 새 `Set`을 만들어 map에 넣고, 그 `Set`에 이웃을 추가한다.

2. **전선별 완전탐색**
   - `wires`의 각 전선 `deletedWire`에 대해 `checkDiff` 호출.

3. **`checkDiff` (BFS)**
   - `visited[1] = true`, 큐에 1을 넣고 `count = 1`로 시작.
   - 큐에서 노드를 꺼내 인접 노드를 순회하며
     - 현재 간선이 `deletedWire`와 같으면 (양방향 모두 확인) 건너뛴다.
     - 이미 방문했으면 건너뛴다.
     - 아니면 방문 처리 후 큐에 넣고 `count++`.
   - 탐색이 끝나면 `|count - (n - count)|` 반환.

4. **`isDeletedWired`**
   - `(nodeA, nodeB)`가 `deletedWire`와 정방향/역방향 중 하나로 일치하면 `true`.

5. 모든 전선에 대한 결과 중 최솟값을 `answer`로 반환.

#### 시간복잡도

```
그래프 구성 : O(n)          (전선 n-1개 순회)
전선별 탐색 : (n-1) * BFS
BFS 1회     : O(V + E) = O(n + n) = O(n)   (트리라 간선 수 = n-1)

전체 : O(n) + O(n) * O(n) = O(n^2)
```

`n ≤ 100`이므로 최대 연산량은 1만 수준으로 매우 여유롭다.

#### 공간복잡도

```
인접 리스트 map : O(V + E) = O(n)
visited 배열     : O(n)
BFS 큐           : 최대 O(n)

전체 : O(n)
```

#### 개선 가능한 부분

- **`Map` 없이 풀 수 있다.** 매 탐색마다 `wires` 배열을 직접 순회하며 "끊긴 인덱스"만 건너뛰어도 되고(`O(n^2)` 동일), 인접 리스트가 필요하면 `List<Integer>[]` 배열이 `HashMap` + `HashSet`보다 상수/메모리 면에서 유리하다.
- **트리 성질을 쓰면 `O(n)`으로 개선 가능하다.** 트리를 1번 루트로 고정하고 DFS 한 번으로 각 노드의 서브트리 크기를 구한다. 간선 `(parent, child)`를 끊으면 한쪽은 `subtreeSize[child]`, 다른 쪽은 `n - subtreeSize[child]`이므로 모든 전선의 결과를 한 번의 순회로 계산할 수 있다. 다만 `n`이 작아 체감 이득은 없다.
- **`Union-Find`** 로도 풀 수 있다. 끊을 전선 하나를 제외한 나머지를 union한 뒤, 한 집합의 크기를 세는 방식. 코드량은 비슷하다.
- `isDeletedWired`는 간선 순회 중 매번 호출된다. 탐색 전에 `map`에서 해당 간선을 잠깐 제거했다가 복원하면 내부 루프의 분기를 없앨 수 있으나, 가독성/안정성 면에서 현재 방식이 낫다.

#### 시행착오

- **`getOrDefault`로 인접 리스트를 만들다 그래프가 누락됐다.**
  - 처음에는 아래처럼 작성했다.
    ```java
    map.getOrDefault(wires[i][0], new HashSet<Integer>()).add(wires[i][1]);
    ```
  - **원인**: `getOrDefault(key, default)`는 key가 없을 때 `default`를 **반환만** 할 뿐 map에 넣지 않는다. 따라서 새로 만든 `HashSet`에 이웃을 추가해도 그 `Set`은 map에 연결되지 않고 그대로 버려진다. 결과적으로 해당 key는 map에 영영 등록되지 않는다.
  - **증상**: 이후 BFS에서 `map.get(node)`가 `null`을 반환 → `for (int wiredNode : wiredNodes)`에서 `NullPointerException`.
  - **해결**: `computeIfAbsent(key, k -> new HashSet<>())`로 변경. 이 메서드는 key가 없으면 새 `Set`을 **map에 넣고 그 참조를 반환**하므로, 반환된 `Set`에 `add`하면 map에도 반영된다.
  - **이후 주의할 점**:
    - `getOrDefault`는 값을 **읽기만** 할 때 쓴다. 반환값을 그 자리에서 mutate하는 패턴(`getOrDefault(...).add(...)`)은 거의 항상 버그다.
    - 굳이 `getOrDefault`로 쓰려면 `map.computeIfAbsent` 또는 `Set<Integer> s = map.getOrDefault(k, new HashSet<>()); s.add(v); map.put(k, s);`처럼 **다시 `put`** 해야 한다.
    - 부수적으로 `getOrDefault(k, new HashSet<>())`는 key 존재 여부와 무관하게 매 호출마다 `new HashSet`을 생성한다. `computeIfAbsent`는 없을 때만 생성하므로 불필요한 객체 생성도 줄어든다.
