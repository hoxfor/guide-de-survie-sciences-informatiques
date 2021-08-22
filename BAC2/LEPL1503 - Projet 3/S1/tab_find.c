//
// Created by nicolas on 03.02.21.
//

#include <stdio.h>

int tab_find(int tab[], int len, int elem) {
    for (int i = 0; i < len; ++i) {
        if (tab[i] == elem) {
            return i;
        }
    }
    return -1;
}

int main() {
    int array[] = { 1, 2, 3, 4};
    printf("%d", tab_find(array, 5, 4));
}