//
// Created by nicolas on 17.03.21.
//

#ifndef S6_SHAREDBUFFER_H
#define S6_SHAREDBUFFER_H
typedef struct data {
    int longitude;
    int latitude;
    float avg_temp;
} data_t;


int put(data_t** buf, int len, int* first, int* last, int* in, data_t* d);

data_t* get(data_t** buf, int len, int* first, int* last, int* in);
#endif //S6_SHAREDBUFFER_H
