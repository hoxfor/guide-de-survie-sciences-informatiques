//
// Created by nicolas on 26.02.21.
//

#ifndef S4_ADVANCEDQUEUE_H
#define S4_ADVANCEDQUEUE_H

typedef struct node{
    struct node* next;
    int value;
} node_t;

typedef struct queue{
    struct node* tail;
    int size;
} queue_t;

int enqueue(queue_t* q, int val);

int dequeue(queue_t* q);

#endif //S4_ADVANCEDQUEUE_H
