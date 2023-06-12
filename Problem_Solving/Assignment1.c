#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 500

#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable: 4996)

int* users[N];
int* items[N];
int empty;
int T[N][N];

void add_user(int k, int id, int* vector) {
    int* temp = (int*)malloc(sizeof(int)*k);
    for(int i = 0 ; i < k; i++) {
        *(temp+i) = *(vector+i);
    }
    users[id] = temp;
}

void add_item(int k, int id, int* vector) {
    int* temp = (int*)malloc(sizeof(int)*k);
    for(int i = 0 ; i < k; i++) {
        *(temp+i) = *(vector+i);
    }
    items[id] = temp;
}

void del_user(int id) {
    int* temp;
    temp = users[id];
    users[id] = &empty;
    free(temp);
}

void del_item(int id) {
    int* temp;
    temp = items[id];
    items[id] = &empty;
    free(temp);
}

void recommand(int k, int id) {
    int preference;
    int max = -1000001;
    int max_id;
    for(int i = 0; i < N; i++) {
        if(items[i] != &empty) {
            preference = 0;
            for(int j = 0; j < k; j++) {
                preference += (*(users[id]+j))*(*(items[i]+j));
            }
            if(preference > max) {
                max = preference;
                max_id = i;
            }
        }
    }
    if(max == -3000001) printf("Error\n");
    else printf("%d\n", max_id);
}

void find_similar(int k, int id) {
    int distance;
    int min = 12000001;
    int min_id;
    for(int i = 0; i < N; i++) {
        if(users[i] != &empty && i != id) {
            distance = 0;
            for(int j = 0; j < k; j++) {
                distance += ((*(users[id]+j))-(*(users[i]+j)))*((*(users[id]+j))-(*(users[i]+j)));
            }
            if(distance < min) {
                min = distance;
                min_id = i;
            }
        }
    }
    if(min == 12000001) printf("Error\n");
    else printf("%d\n", min_id);
}

void transform(int k) {
    int sum;
    int* new_v = (int*)malloc(sizeof(int)*k);
    for(int i = 0; i < N; i++) {
        if(users[i] != &empty) {
            for(int j = 0; j < k; j++) {
                sum = 0;
                for(int p = 0; p < k; p++) {
                    sum += T[j][p]*(*(users[i]+p));
                }
                *(new_v+j) = sum;
            }
            for(int j = 0; j < k; j++) {
                *(users[i]+j) = *(new_v+j);
            }
        }
    }
    free(new_v);
}

int main() {

    for(int i = 0; i < N; i++) {
        users[i] = &empty;
        items[i] = &empty;
    }

    char cmd_type[15];
    int k, id;
    int* v;

	while (1) {
		scanf("%s", cmd_type);

		if (!strcmp(cmd_type, "set_k")) {
			scanf("%d", &k);
            v = (int*)malloc(sizeof(int)*k);
		}
		else if (!strcmp(cmd_type, "add_user")) {
            scanf("%d", &id);
            for(int i = 0; i < k; i++) {
                scanf("%d", (v+i));
            }
            if(users[id] != &empty) printf("Error\n");
            else add_user(k, id, v);
		}
		else if (!strcmp(cmd_type, "del_user")) {
            scanf("%d", &id);
            if(users[id] == &empty) printf("Error\n");
            else del_user(id);
		}
		else if (!strcmp(cmd_type, "add_item")) {
            scanf("%d", &id);
            for(int i = 0; i < k; i++) {
                scanf("%d", (v+i));
            }
            if(items[id] != &empty) printf("Error\n");
            else add_item(k, id, v);
		}
		else if (!strcmp(cmd_type, "del_item")) {
            scanf("%d", &id);
            if(items[id] == &empty) printf("Error\n");
            else del_item(id);
		}
		else if (!strcmp(cmd_type, "recommend")) {
            scanf("%d", &id);
            if(users[id] == &empty) printf("Error\n");
            else recommand(k, id);
		}
		else if (!strcmp(cmd_type, "find_similar")) {
            scanf("%d", &id);
            if(users[id] == &empty) printf("Error\n");
            else find_similar(k, id);
		}
		else if (!strcmp(cmd_type, "transform")) {
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < k; j++) {
                    scanf("%d", &T[i][j]);
                }
            }
            transform(k);
		}
		else if (!strcmp(cmd_type, "exit")) {
			break;
		}
	}

    return 0;

}