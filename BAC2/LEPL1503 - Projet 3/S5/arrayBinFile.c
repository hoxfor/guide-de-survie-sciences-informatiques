//
// Created by nicolas on 02.03.21.
//

#include "arrayBinFile.h"

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/mman.h>

/**
 * @pre filename != NULL, index >= 0
 * @post return the integer at the index {index}
 *       of the array in the file {filename}.
 *       return -1 in case of error.
 *       return -2 if index >= length of array.
 */
int get(char *filename, int index) {
    int fd = open(filename, O_RDONLY, S_IRUSR);
    if (fd == -1) return -1;

    struct stat *file_stat = (struct stat*) malloc(sizeof (struct stat));
    if (file_stat == NULL) return -1;
    if (fstat(fd, file_stat) == -1) return -1;

    size_t file_size = file_stat->st_size;
    if (index * sizeof(int) >= file_size) {
        int close_file = close(fd);
        if (close_file == -1) return -1;
        return -2;
    }

    int *dest = mmap(NULL, file_size, PROT_READ, MAP_SHARED, fd, 0);
    if (dest == (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;
        return -1;
    }
    int value = *(dest + index);

    int unmap = munmap(dest, file_size);
    if (unmap == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;
        return -1;
    }

    int close_file = close(fd);
    if (close_file == -1) return -1;
    return value;
}

/**
 * @pre filename != NULL, index >= 0
 * @post set the element in the file {filename}
 *       at index {index} at value {value}.
 *       do nothing in case of errors
 */
void set(char *filename, int index, int value) {
    int fd = open(filename, O_RDWR);
    if (fd == -1) return;

    struct stat *file_stat = (struct stat*) malloc(sizeof (struct stat));
    if (file_stat == NULL) return;
    if (fstat(fd, file_stat) == -1) return;

    size_t file_size = file_stat->st_size;
    if (index > file_size / sizeof(int)) {
        int close_file = close(fd);
        if (close_file == -1) return;
        return;
    }
    int *dest = mmap(NULL, file_size, PROT_READ| PROT_WRITE, MAP_SHARED, fd, 0);
    if (dest == (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return;
        return;
    }

    *(dest + index) = value;

    int sync = msync(dest, file_size, MS_SYNC);
    if (sync == -1) {
        int close_file = close(fd);
        if (close_file == -1) return;
        return;
    }

    int unmap = munmap(dest, file_size);
    if (unmap == -1) {
        int close_file = close(fd);
        if (close_file == -1) return;
        return;
    }

    int close_file = close(fd);
    if (close_file == -1) return;
}