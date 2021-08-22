//
// Created by nicolas on 10.03.21.
//

#ifndef S6_SORTMYPOINTS_H
#define S6_SORTMYPOINTS_H
typedef struct points {
    int NOMA;
    float LEPL1103;
    float LEPL1203;
    float LEPL1108;
    float LEPL1302;
    float LEPL1402;
    float average;
} points_t;

int compar(const void* s1, const void* s2);

int sort(char* filename);

#endif //S6_SORTMYPOINTS_H
