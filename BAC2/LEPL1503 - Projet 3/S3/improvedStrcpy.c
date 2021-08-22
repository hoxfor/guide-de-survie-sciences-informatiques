//
// Created by nicolas on 15.02.21.
//

/*
* Creates a buffer that has the same size as src, and copies the content of src to this buffer.
*
* @src: string to be copied
* @return: return pointer. if src == NULL or in case of error, return NULL
*
* Remember that strings are terminated with '\0' and that strlen("abc") returns 3 even if 4 bytes are required to store this string.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *buf_strcpy(const char *src) {
    size_t size = strlen(src);
    char *copy_ptr;
    copy_ptr = malloc(sizeof(char)*(size+1));
    if(copy_ptr==NULL)
        return NULL;

    for (int i = 0; i < size; ++i) {
        copy_ptr[i] = src[i];
    }
    copy_ptr[size++] = '\0';

    return copy_ptr;
}
