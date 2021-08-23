//
// Created by nicolas on 16.02.21.
//

/* Wrapper to the malloc system call.
 * If malloc fails, sleep for 5 seconds, and then try again.
 * If malloc failed 10 times in a row, return NULL.
 */

#include <stdlib.h>
#include <unistd.h>
void *sleepy_malloc(size_t s) {
    size_t *ptr;
    for (int i = 0; i < 10; ++i) {
        ptr = malloc(s);
        if (ptr == NULL) {
            sleep(5);
        } else {
            return ptr;
        }
    }
    return NULL;
}