//
// Created by nicolas on 28.02.21.
//

#ifndef S5_SAVEFILE_H
#define S5_SAVEFILE_H

typedef struct point {
    int x;
    int y;
    int z;
} point_t;

int save(point_t *pt, int size, char *filename);

#endif //S5_SAVEFILE_H
