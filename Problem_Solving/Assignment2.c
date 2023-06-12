#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

int result[10001];

int n;

int get_value(char** array) {

    int k;
    int sum = 0;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {

            k = 1;

            if(array[i][j] == '*') {
                if(j+k < n && array[i][j+k] == '*') { // right
                    
                    while(j+k < n && array[i][j+k] == '*') {
                        array[i][j+k] = 'V';
                        k++;
                    }
                }
                else if(i+k < n && array[i+k][j] == '*') { // down
                   while(i+k < n && array[i+k][j] == '*') {
                        array[i+k][j] = 'V';
                        k++;
                    }
                }
                sum += (int)floor(pow(k, 1.5));
            }
            
        }
    }

    return sum;
}

void print_result(char** array) {

    int k;
    int idx = 0;
    int d;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {

            k = 1;
            d = 0;

            if(array[i][j] == '*') {
                if(j+k < n && array[i][j+k] == 'V') { // right
                    d = 0;
                    while(j+k < n && array[i][j+k] == 'V') {
                        array[i][j+k] = 'X';
                        k++;
                    }
                }
                else if(i+k < n && array[i+k][j] == 'V') { // down
                    d = 1;
                    while(i+k < n && array[i+k][j] == 'V') {
                        array[i+k][j] = 'X';
                        k++;
                    }
                }
                result[idx++] = i;
                result[idx++] = j;
                result[idx++] = k;
                result[idx++] = d;
            }
        }
    }

    printf("%d\n", idx/4);

    for(int i = 0; i < idx; i += 4) {
        printf("%d %d %d %d\n", result[i], result[i+1], result[i+2], result[i+3]);
    }

}

int main() {

    scanf("%d", &n);

    char** arr = (char**)malloc(sizeof(char*)*n);
    char** row = (char**)malloc(sizeof(char*)*n);
    char** col = (char**)malloc(sizeof(char*)*n);

    for(int i = 0; i < n; i++) {
        *(arr+i) = (char*)malloc(sizeof(char)*n+1);
        *(row+i) = (char*)malloc(sizeof(char)*n+1);
        *(col+i) = (char*)malloc(sizeof(char)*n+1);
        scanf("%s", *(arr+i));
        strcpy(*(row+i), *(arr+i));
        strcpy(*(col+i), *(arr+i));
    }

    if(n == 1) {
        if(arr[0][0] == 'X') printf("0\n");
        else printf("1\n0 0 1 0\n");

        free(arr);
        free(row);
        free(col);

        return 0;
    }

    if(n%2) { // odd

        //row
        for(int i = 0; i < n; i += 2) {
            for(int j = 0; j < n; j++) {
                if(row[i][j] == '.') {
                    row[i][j] = '*';
                    if(i < n-1) row[i+1][j] = 'X';
                    if(i > 0) row[i-1][j] = 'X';
                }
            }
        }

        // col
        for(int i = 0; i < n; i += 2) {
            for(int j = 0; j < n; j++) {
                if(col[j][i] == '.') {
                    col[j][i] = '*';
                    if(j < n-1) col[j][i+1] = 'X';
                    if(j > 0) col[j][i-1] = 'X';
                }
            }
        }

        if(get_value(row) >= get_value(col)) {
            print_result(row);
        }
        else {
            print_result(col);
        }

    }
    else { // even

        // row
        int* row_value = (int*)malloc(sizeof(int)*n);
        for(int i = 0; i < n; i++) {
            row_value[i] = 0;
        }

        int k;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i][j] == '.') {
                    k = 1;
                    j++;
                    if(j < n && row[i][j] == '.') { 
                        while(j < n && row[i][j] == '.') {
                            k++;
                            j++;
                        }
                    }
                    row_value[i] += (int)floor(pow(k, 1.5));
                }
            }
        }

        int sum = 0;
        int max = -1;
        int a;

        for(int i = 0; i < n-3; i += 2) {
            sum += row_value[i];
        }
        if(sum+row_value[n-1] > max) {
            max = sum+row_value[n-1];
            a = 1;
        }
        if(sum+row_value[n-2] > max) {
            max = sum+row_value[n-2];
            a = 2;
        }
        sum = 0;
        for(int i = 1; i < n; i += 2) {
            sum += row_value[i];
        }
        if(sum > max) {
            max = sum;
            a = 3;
        }

        if(a == 3) { // 1, 3, ... , n-1
            for(int i = 1; i < n; i += 2) {
                for(int j = 0; j < n; j++) {
                    if(row[i][j] == '.') {
                        row[i][j] = '*';
                        row[i-1][j] = 'X';
                        if(i < n-1) row[i+1][j] = 'X';
                    }
                }
            }
        }
        else { // 0, 2, ... , n-2 or n-1
            for(int i = 0; i < n-3; i += 2) {
                for(int j = 0; j < n; j++) {
                    if(row[i][j] == '.') {
                        row[i][j] = '*';
                        if(i != 0) row[i-1][j] = 'X';
                        if(i < n-1) row[i+1][j] = 'X';
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                if(row[n-a][j] == '.') {
                    row[n-a][j] = '*';
                    row[n-a-1][j] = 'X';
                    if(n-a < n-1) row[n-a+1][j] = 'X';
                }
            }
        }
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < n; j++) {
                if(row[i][j] == '.') row[i][j] = '*';
            }
        }

        // row end


        // col
        int* col_value = (int*)malloc(sizeof(int)*n);
        for(int i = 0; i < n; i++) {
            col_value[i] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(col[j][i] == '.') {
                    k = 1;
                    j++;
                    if(j < n && col[j][i] == '.') { 
                        while(j < n && col[j][i] == '.') {
                            k++;
                            j++;
                        }
                    }
                    col_value[i] += (int)floor(pow(k, 1.5));
                }
            }
        }

        sum = 0;
        max = -1;

        for(int i = 0; i < n-3; i += 2) {
            sum += col_value[i];
        }
        if(sum+col_value[n-1] > max) {
            max = sum+col_value[n-1];
            a = 1;
        }
        if(sum+col_value[n-2] > max) {
            max = sum+col_value[n-2];
            a = 2;
        }
        sum = 0;
        for(int i = 1; i < n; i += 2) {
            sum += col_value[i];
        }
        if(sum > max) {
            max = sum;
            a = 3;
        }

        if(a == 3) { // 1, 3, ... , n-1
            for(int i = 1; i < n; i += 2) {
                for(int j = 0; j < n; j++) {
                    if(col[j][i] == '.') {
                        col[j][i] = '*';
                        col[j][i-1] = 'X';
                        if(i < n-1) col[j][i+1] = 'X';
                    }
                }
            }
        }
        else { // 0, 2, ... , n-2 or n-1
            for(int i = 0; i < n-3; i += 2) {
                for(int j = 0; j < n; j++) {
                    if(col[j][i] == '.') {
                        col[j][i] = '*';
                        if(i != 0) col[j][i-1] = 'X';
                        if(i < n-1) col[j][i+1] = 'X';
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                if(col[j][n-a] == '.') {
                    col[j][n-a] = '*';
                    col[j][n-a-1] = 'X';
                    if(n-a < n-1) col[j][n-a+1] = 'X';
                }
            }
        }
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < n; j++) {
                if(col[i][j] == '.') col[i][j] = '*';
            }
        }

        // col end
        free(row_value);
        free(col_value);
        if(get_value(row) >= get_value(col)) {
            print_result(row);
        }
        else {
            print_result(col);
        }

    }

    free(arr);
    free(row);
    free(col);
    

    return 0;
}