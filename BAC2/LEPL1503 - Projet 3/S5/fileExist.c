//
// Created by nicolas on 28.02.21.
//

#include "fileExist.h"

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <unistd.h>

int file_exists(char *filename) {
    if (access(filename, F_OK) == 0) return 0;
    return -1;

}