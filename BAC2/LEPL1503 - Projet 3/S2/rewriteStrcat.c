//
// Created by nicolas on 04.02.21.
//

#include <stdio.h>

char* strCat(char* dest, const char* src) {
    size_t src_len = 0;
    size_t dest_len = 0;
    size_t i;
    while (src[src_len] != '\0') {
        src_len++;
    }
    while (dest[dest_len] != '\0') {
        dest_len++;
    }
    for (i = 0 ; i < src_len ; i++)
        if (src[i] != '\0') {
            dest[dest_len + i] = src[i];
        }
    dest[dest_len + i] = '\0';

    return dest;

}
