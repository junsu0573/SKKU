#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int n; // 배열의 크기

typedef struct _Obstacle
{
    int row, col;
    int sum;
} Obstacle;


Obstacle row_sum(char** arr) {

    Obstacle result1;
    Obstacle result2;

    result1.row = -1;
    result1.col = -1;
    result1.sum = 0;

    result2.row = -1;
    result2.col = -1;
    result2.sum = 0;

    int cnt;
    int max = 0;

    // case 1
    for(int i = 0; i < n; i += 2) {
        for(int j = 0; j < n; j++) {
            if(arr[i][j] == '.') {
                cnt = 1;
                while(j < n-1 && arr[i][j+1] == '.') {
                    cnt++;
                    j++;
                }
                if(cnt > max) {
                    max = cnt;
                    result1.row = i;
                    result1.col = j-cnt/2;
                }
                result1.sum += floor(pow(cnt, 1.5));
            }
        }
    }

    max = 0;
    // case 2
    for(int i = 1; i < n; i += 2) {
        for(int j = 0; j < n; j++) {
            if(arr[i][j] == '.') {
                cnt = 1;
                while(j < n-1 && arr[i][j+1] == '.') {
                    cnt++;
                    j++;
                }
                if(cnt > max) {
                    max = cnt;
                    result2.row = i;
                    result2.col = j-cnt/2;
                }
                result2.sum += floor(pow(cnt, 1.5));
            }
        }
    }

    if(result1.sum >= result2.sum) return result1;
    else return result2;
}

Obstacle col_sum(char** arr) {

    Obstacle result1;
    Obstacle result2;

    result1.row = -1;
    result1.col = -1;
    result1.sum = 0;

    result2.row = -1;
    result2.col = -1;
    result2.sum = 0;

    int cnt;
    int max = 0;

    // case 1
    for(int i = 0; i < n; i += 2) {
        for(int j = 0; j < n; j++) {
            if(arr[j][i] == '.') {
                cnt = 1;
                while(j < n-1 && arr[j+1][i] == '.') {
                    cnt++;
                    j++;
                }
                if(cnt > max) {
                    max = cnt;
                    result1.row = j-cnt/2;
                    result1.col = i;
                }
                result1.sum += floor(pow(cnt, 1.5));
            }
        }
    }

    max = 0;
    // case 2
    for(int i = 1; i < n; i += 2) {
        for(int j = 0; j < n; j++) {
            if(arr[j][i] == '.') {
                cnt = 1;
                while(j < n-1 && arr[j+1][i] == '.') {
                    cnt++;
                    j++;
                }
                if(cnt > max) {
                    max = cnt;
                    result2.row = j-cnt/2;
                    result2.col = i;
                }
                result2.sum += floor(pow(cnt, 1.5));
            }
        }
    }

    if(result1.sum >= result2.sum) return result1;
    else return result2;
}

int main() {

    int m; // 장애물의 개수
    scanf("%d %d", &n, &m);

    char** arr = (char**)malloc(sizeof(char*)*n);
    for(int i = 0; i < n; i++) {
        *(arr+i) = (char*)malloc(sizeof(char)*n+1);
        scanf("%s", *(arr+i));
    }

    // printf("%d %d %d\n", row_sum(arr).sum, row_sum(arr).row, row_sum(arr).col);
    // printf("%d %d %d\n", col_sum(arr).sum, col_sum(arr).row, col_sum(arr).col);

    int cnt_empty = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(arr[i][j] == '.') cnt_empty++;

        }
    }

    if(cnt_empty < m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == '.') arr[i][j] = 'V';
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'V') printf("%d %d\n", i, j);
            }
        }
        for(int i = 0; i < m-cnt_empty; i++) {
            printf("0 0\n");
        }
    }
    else {
        while(m-- > 0) {

            if(row_sum(arr).sum >= col_sum(arr).sum) {
                arr[row_sum(arr).row][row_sum(arr).col] = 'V';
            }
            else {
                arr[col_sum(arr).row][col_sum(arr).col] = 'V';
            }

        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'V') printf("%d %d\n", i, j);
            }
        }
    }
    
    
    // for(int i = 0; i < n; i++) {
    //     printf("%s\n", arr[i]);
    // }

    for(int i = 0; i < n; i++) {
        free(*(arr+i));
    }
    free(arr);

    return 0;
}