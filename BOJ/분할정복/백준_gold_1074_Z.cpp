#include <iostream>

using namespace std;

void fillMatrix(int n, int startRow, int startCol, int startNum, int row, int col)
{
    if (n == 1)
    {
        int num = startNum;
        for (int i = startRow; i < startRow + 2; i++)
        {
            for (int j = startCol; j < startCol + 2; j++)
            {
                if (i == row && j == col)
                {
                    cout << num;
                    return;
                }
                num++;
            }
        }
        return;
    }

    int size = (1 << (n - 1));
    int box = size * size;

    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            if (startRow + i * size <= row && row < startRow + (i + 1) * size && startCol + j * size <= col && col < startCol + (j + 1) * size)
            {
                fillMatrix(n - 1, startRow + i * size, startCol + j * size, startNum + box * (2 * i + j), row, col);
            }
        }
    }

    return;
}

int main()
{
    int n, r, c;
    cin >> n >> r >> c;

    fillMatrix(n, 0, 0, 0, r, c);

    return 0;
}