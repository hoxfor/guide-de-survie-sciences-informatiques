//
// Created by nicolas on 16.02.21.
//

#include <stdlib.h>

void *calloc2(size_t nmemb, size_t size) {
    if (nmemb == 0 || size == 0) return NULL;

    int* ptr = malloc(size * nmemb);
    if (ptr == NULL) {
        return NULL;
    } else {
        for (int i = 0; i < nmemb; ++i) {
            ptr[i] = 0;
        }
    }
    return ptr;
}