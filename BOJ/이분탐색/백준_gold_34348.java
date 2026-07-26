import java.io.*;
import java.util.*;

public class Main {
    static int id(char ch) {
        switch (ch) {
            case 's': return 0;
            case 'n': return 1;
            case 'u': return 2;
            case 'p': return 3;
            case 'c': return 4;
            default: return -1;
        }
    }

    static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == list.size()) ? -1 : left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = id(s.charAt(i));
            if (idx != -1) {
                list.get(idx).add(i);
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = (l + r) / 2;

            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(0).size() < mid || list.get(1).size() < mid || list.get(2).size() < mid || list.get(3).size() < mid || list.get(4).size() < mid) {
                    right = mid - 1;
                    continue;
                }

                int sIdx = lowerBound(list.get(0), l);
                if (sIdx == -1 || sIdx + mid > list.get(0).size() || list.get(0).get(sIdx + mid - 1) + 1 > r) {
                    right = mid - 1;
                    continue;
                } else {
                    sIdx = list.get(0).get(sIdx + mid - 1);
                }
                int nIdx = lowerBound(list.get(1), sIdx);
                if (nIdx == -1 || nIdx + mid > list.get(1).size() || list.get(1).get(nIdx + mid - 1) + 1 > r) {
                    right = mid - 1;
                    continue;
                } else {
                    nIdx = list.get(1).get(nIdx + mid - 1);
                }
                int uIdx = lowerBound(list.get(2), nIdx);
                if (uIdx == -1 || uIdx + mid > list.get(2).size() || list.get(2).get(uIdx + mid - 1) + 1 > r) {
                    right = mid - 1;
                    continue;
                } else {
                    uIdx = list.get(2).get(uIdx + mid - 1);
                }
                int pIdx = lowerBound(list.get(3), uIdx);
                if (pIdx == -1 || pIdx + mid > list.get(3).size() || list.get(3).get(pIdx + mid - 1) + 1 > r) {
                    right = mid - 1;
                    continue;
                } else {
                    pIdx = list.get(3).get(pIdx + mid - 1);
                }
                int cIdx = lowerBound(list.get(4), pIdx);
                if (cIdx == -1 || cIdx + mid > list.get(4).size() || list.get(4).get(cIdx + mid - 1) + 1 > r) {
                    right = mid - 1;
                    continue;
                } else {
                    left = mid;
                }
            }
            sb.append(left).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}