//
// Created by nicolas on 10.03.21.
//

#include "fileCopy.h"

#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/mman.h>
/**
 * @pre file_name != NULL, name of the original file
 *      new_file_name != NULL, name of the new file (the copy)
 *
 * @post copy the contents of {file_name} to {new_file_name}.
 *       return 0 if the function terminates with success, -1 in case of errors.
 */
int copy(char *file_name, char *new_file_name) {
    int fd = open(file_name, O_RDONLY);
    if (fd == -1) return -1;

    int new_fd = open(new_file_name, O_RDWR | O_CREAT | O_TRUNC);
    if (new_fd == -1) return -1;

    struct stat *file_stat = (struct stat *) malloc(sizeof(struct stat));
    if (file_stat == NULL) return -1;
    if (fstat(fd, file_stat) == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;
        return -1;
    }

    size_t file_size = file_stat->st_size;

    int ftr = ftruncate(new_fd, file_size);
    if (ftr == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    struct stat *new_file_stat = (struct stat *) malloc(sizeof(struct stat));
    if (new_file_stat == NULL) return -1;
    if (fstat(new_fd, new_file_stat) == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }
    size_t new_file_size = new_file_stat->st_size;

    if (file_stat->st_mode != new_file_stat->st_mode) chmod(new_file_name, file_stat->st_mode);

    int *src = mmap(NULL, file_size, PROT_READ, MAP_SHARED, fd, 0);
    if (src == (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    int *dest = mmap(NULL, new_file_size, PROT_WRITE, MAP_SHARED, new_fd, 0);
    if (dest == (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    memcpy(dest, src, file_size);

    int sync = msync(dest, file_size, MS_SYNC);
    if (sync == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    int unmap_old = munmap(src, file_size);
    if (unmap_old == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    int unmap_new = munmap(dest, new_file_size);
    if (unmap_new == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -1;

        int close_new_file = close(new_fd);
        if (close_new_file == -1) return -1;
        return -1;
    }

    int close_file = close(fd);
    if (close_file == -1) return -1;

    int close_new_file = close(new_fd);
    if (close_new_file == -1) return -1;
    return 0;
}