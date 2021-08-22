//
// Created by nicolas on 17.02.21.
//
#include <stdlib.h>
#include <stdio.h>

int first(void *ptr) {
    int* value = ptr + 3 * sizeof(int); // sizeof(int) = 4
    return *value;
}

char second(void *ptr) {
    char* value = ptr + 6 * sizeof (char); // sizeof(char) = 1
    return *value;
}

int third(void *ptr) {
    int* value = ptr + 45 * sizeof(char);
    return *value;
}
