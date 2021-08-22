//
// Created by nicolas on 10.03.21.
//

#include "sortMyPoints.h"

#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/mman.h>

/**
* Function used to compare two structures based on their averages.
*
* @s1 : a pointer to the first structure
* @s2 : a pointer to the second structure
*
* @return an integer less than, equal to, or greater than zero if the first argument is considered to be
*        respectively less than, equal to, or greater than the second
*/
int compar(const void* s1, const void* s2){
    points_t *student1 = (points_t*) s1;
    points_t *student2 = (points_t*) s2;

    if (student1->average == student2->average) {
        return 0;
    } else if (student1->average < student2->average) {
        return -1;
    }
    return 1;
}

/**
* Function used to update the file with the structures stored in it
*
* @filename : the path indicating where to find the file (!= NULL)
*
* @return 0 if no error
*        -1 if open failed
*        -2 if mmap failed
*        -3 if munmap failed
*        -4 if msync failed
*        -5 if fstat failed
*        -6 if close failed
*/
int sort(char* filename){
    int fd = open(filename, O_RDWR);
    if (fd == -1) return -1;

    struct stat *file_stat = (struct stat*) malloc(sizeof (struct stat));
    if (file_stat == NULL) return -1;
    if (fstat(fd, file_stat) == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -6;
        return -5;
    }

    size_t file_size = file_stat->st_size;

    int *dest = mmap(NULL, file_size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    if (dest == (void*) -1) {
        int close_file = close(fd);
        if (close_file == -1) return -6;
        return -2;
    }

    int sync = msync(dest, file_size, MS_SYNC);
    if (sync == -1) {
        int unmap = munmap(dest, file_size);
        if (unmap == -1) return -3;
        int close_file = close(fd);
        if (close_file == -1) return -6;
        return -4;
    }

    size_t i = 0;
    size_t frac = file_size / sizeof (points_t);
    points_t *ptrToStruct = (points_t*) dest;
    while (i < frac) {
        ptrToStruct->average = (ptrToStruct->LEPL1402 + ptrToStruct->LEPL1302 + ptrToStruct->LEPL1203
                + ptrToStruct->LEPL1108 + ptrToStruct->LEPL1103) / (float) 5.0;
        i++;
        ptrToStruct++;
    }

    qsort(dest, frac, sizeof(points_t), &compar);

    int unmap = munmap(dest, file_size);
    if (unmap == -1) {
        int close_file = close(fd);
        if (close_file == -1) return -6;
        return -3;
    }

    int close_file = close(fd);
    if (close_file == -1) return -6;
    return 0;
}