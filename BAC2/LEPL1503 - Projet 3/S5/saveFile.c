//
// Created by nicolas on 28.02.21.
//

#include "saveFile.h"

#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/mman.h>

/**
 * @pre pt != NULL, pointer to the first point_t in the array
 *      size > 0, the length of the array.
 *      filename != NULL
 * @post writes the array of point_t in the file.
 *       return 0 is everything worked correctly
 *       -1 if open() failed.
 *       -2 if close() failed.
 *       -3 if mmap() failed.
 *       -4 if munmap() failed.
 *       -5 if msync() failed.
 *       -6 if ftruncate() failed.
 *
 */
int save(point_t *pt, int size, char *filename) {
    int fd = open(filename, O_RDWR | O_CREAT | O_TRUNC , S_IRWXU);
    if (fd == -1) return -1;

    int ftr = ftruncate(fd, size * sizeof (point_t));
    if (ftr == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return  -6;
    }

    int *dest = mmap(NULL, size * sizeof (point_t), PROT_WRITE, MAP_SHARED, fd, 0);
    if (dest == (void *) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -3;
    }

    memcpy(dest, pt, size * sizeof (point_t));

    int sync = msync(dest, size * sizeof (point_t), MS_SYNC);
    if (sync == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -5;
    }

    int unmap = munmap(dest, size * sizeof (point_t));
    if (unmap == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -2;
        return -4;
    }

    int close_file = close(fd);
    if (close_file == -1) return -2;

    return 0;
}