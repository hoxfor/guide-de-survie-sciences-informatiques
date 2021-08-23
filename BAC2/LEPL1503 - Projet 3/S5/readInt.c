//
// Created by nicolas on 03.03.21.
//

#include "readInt.h"

#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/mman.h>

int sum_file(char *filename) {
    int fd = open(filename, O_RDONLY);
    if (fd == -1) return -1;

    struct stat *file_stat = (struct stat *) malloc(sizeof(struct stat));
    if (file_stat == NULL) return -1;
    if (fstat(fd, file_stat) == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -5;
    }

    size_t file_size = file_stat->st_size;
    if (file_size ==0) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return 0;
    }

    int *dest = mmap(NULL, file_size, PROT_READ, MAP_SHARED, fd, 0);
    if (dest ==  (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -3;
    }

    int sum = 0;
    for (int i = 0; i < (file_size/sizeof (int)); ++i) {
        sum += dest[i];
    }

    int unmap = munmap(dest, file_size);
    if (unmap == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -4;
    }

    int close_file = close(fd);
    if (close_file == -1) return -2;
    return sum;
}