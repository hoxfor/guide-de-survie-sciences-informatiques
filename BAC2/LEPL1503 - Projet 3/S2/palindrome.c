//
// Created by nicolas on 06.02.21.
//

#include <string.h>
/*
* @return: returns true (1) if str is a palindrome, -1 if str is NULL, otherwise false (0).
*/
int pal(char *str) {
    if (str == NULL) return -1;
    size_t length = strlen(str);
    if (length < 2) return 1;

    size_t first = 0;
    size_t last = length-1;
    
    while (first < last) {
        if (str[first] == ' ') {
            first++;
        }
        if (str[last] == ' ') {
            last--;
        }

        if (str[first] != ' ' && str[last] != ' ') {
            if (str[first] != str[last]) {
                return 0;
            }
            first++;
            last--;
        }

    }
    return 1;
}
