//
// Created by nicolas on 04.02.21.
//

#include <stdio.h>
#include <string.h>

size_t newStrLen(const char* s) {
    size_t i = 0;
    while (s[i] != '\0') {
        i++;
    }
    return i;
}
