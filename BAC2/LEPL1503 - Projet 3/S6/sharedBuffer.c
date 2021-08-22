//
// Created by nicolas on 17.03.21.
//

#include "sharedBuffer.h"

#include <stdlib.h>

/**
* Function used to put a new value in the shared buffer.
*
* @buf : the shared buffer to fill in with the adresses pointing to the data_t's
* @len : the length of the shared buffer
* @first : the pointer to the array index where you can find the first inserted element that's still in the buffer
*         (or more exactly the pointer to the first element, **if any**)
* @last : the pointer to the array index where you can find the first empty space in the buffer
*         (or more exactly the first NULL pointer in the array, **if any**)
* @in : the number of data_t* pointers in the buffer
* @d : the data_t* that has to be inserted in the buffer
*
* @return 0 if no error, -1 otherwise
*/
int put(data_t **buf, int len, int *first, int *last, int *in, data_t *d) {
    if (len == *in) return -1;

    buf[*last] = d;
    (*in)++;
    *last = (*last + 1) % len;

    return 0;
}

/**
* Function used to get a value from the shared buffer.
*
* @buf : the shared buffer to fill out
* @len : the length of the shared buffer
* @first : the pointer to the array index where you can find the first element inserted that's still in the buffer
*         (or more exactly the pointer to the first element, **if any**)
* @last : the pointer to the array index where you can find the first empty space in the buffer
*         (or more exactly the first NULL pointer in the array, **if any**)
* @in : the number of data_t* pointers in the buffer
*
* @return the pointer to the element that you get if no error, NULL otherwise
*/
data_t *get(data_t **buf, int len, int *first, int *last, int *in) {
    if (*in == 0) return NULL;

    data_t *output = buf[*first];
    *first = (*first + 1) % len;
    (*in)--;

    return output;
}