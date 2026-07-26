#include <iostream>

using namespace std;

// 구조체 정의
struct Data
{
    int **arr;
    int size;
    int white;
    int blue;
};

// 분할 함수
Data divide(Data data)
{
    // size가 1인 경우
    if (data.size == 1)
    {
        if (data.arr[0][0] == 0)
            return {data.arr, 1, 1, 0};
        else
            return {data.arr, 1, 0, 1};
    }

    // 사각형이 만들어지지 않는 경우
    for (int i = 0; i < data.size; i++)
    {
        for (int j = 0; j < data.size; j++)
        {
            if (data.arr[i][j] != data.arr[0][0])
            {
                // 서브 배열 생성
                int subSize = data.size / 2;
                int **subArr1 = new int *[subSize];
                int **subArr2 = new int *[subSize];
                int **subArr3 = new int *[subSize];
                int **subArr4 = new int *[subSize];
                for (int k = 0; k < data.size / 2; k++)
                {
                    subArr1[k] = new int[subSize];
                    subArr2[k] = new int[subSize];
                    subArr3[k] = new int[subSize];
                    subArr4[k] = new int[subSize];
                }

                // 배열에 값 저장
                for (int p = 0; p < subSize; p++)
                {
                    for (int q = 0; q < subSize; q++)
                    {
                        subArr1[p][q] = data.arr[p][q];
                        subArr2[p][q] = data.arr[p][q + subSize];
                        subArr3[p][q] = data.arr[p + subSize][q];
                        subArr4[p][q] = data.arr[p + subSize][q + subSize];
                    }
                }

                Data sub1 = divide({subArr1, subSize, data.white, data.blue});
                Data sub2 = divide({subArr2, subSize, data.white, data.blue});
                Data sub3 = divide({subArr3, subSize, data.white, data.blue});
                Data sub4 = divide({subArr4, subSize, data.white, data.blue});

                return {data.arr, data.size, data.white + sub1.white + sub2.white + sub3.white + sub4.white, data.blue + sub1.blue + sub2.blue + sub3.blue + sub4.blue};
            }
        }
    }

    // 사각형이 만들어지는 경우
    if (data.arr[0][0] == 0)
        return {data.arr, data.size, data.white + 1, data.blue};
    else
        return {data.arr, data.size, data.white, data.blue + 1};
}

// 메인 함수수
int main()
{
    int n;
    cin >> n;

    int white = 0, blue = 0;

    // 동적 배열 선언
    int **matrix = new int *[n];
    for (int i = 0; i < n; i++)
    {
        matrix[i] = new int[n];
    }

    // 배열에 값 저장
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int v;
            cin >> v;
            matrix[i][j] = v;
        }
    }

    // 색종이 수 구하기
    Data result = divide({matrix, n, 0, 0});

    cout << result.white << "\n"
         << result.blue;

    return 0;
}