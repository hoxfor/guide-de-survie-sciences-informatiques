//
// Created by nicolas on 06.02.21.
//

#include <stdio.h>
#include <string.h>

int strCaseCmp(const char *s1, const char *s2) {
    size_t s1_len = 0;
    size_t s2_len = 0;
    while (s1[s1_len] != '\0') s1_len++;
    while (s2[s2_len] != '\0') s2_len++;

    if (s1_len < s2_len) {
        return -2;
    } else if (s1_len > s2_len) {
        return 1;
    } else {
        for (int i = 0; i < s1_len; ++i) {
            if ((int) s1[i] != (int) s2[i] && (int) s1[i] + 32 != (int) s2[i] && (int) s1[i] - 32 != (int) s2[i]) {
                return -1;
            }
        }
        return 0;
    }

}

int correct(const char *s1, const char *s2) {
    int i = 0;
    for (i = 0; s1[i] != '\0' || s2[i] != '\0'; ++i) {
        int i1 = (int) s1[i];
        int i2 = (int) s2[i];
        if (i1 <= 90 && i1 >= 65) {
            i1 += 32;
        }
        if (i2 <=90 && i2 >= 65) {
            i2 += 32;
        }
        if (i2 != i1) {
            return (i1 - i2);
        }
    }
    return 0;
}
