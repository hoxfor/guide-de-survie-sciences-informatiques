//
// Created by nicolas on 26.02.21.
//

#include "advancedQueue.h"
#include <stdlib.h>

int enqueue(queue_t* q, int val) {
    node_t *new = (node_t *) malloc(sizeof(node_t));
    if (new == NULL) return -1;

    new->value = val;

    if (q->size == 0) {
        q->tail = new;
        q->tail->next = new;
    }
    new->next = q->tail->next;
    q->tail->next = new;

    q->size++;
    return 0;
}

int dequeue(queue_t* q) {
    q->size--;

    if (q->size == 0) {
        node_t *old_node =q->tail;
        int val = q->tail->value;
        free(old_node);
        q->tail = NULL;
        return val;
    }

    node_t *old_head = q->tail->next;
    int val = q->tail->value;
    for (int i = 0; i < q->size-2; ++i) {
        old_head = old_head->next;
    }
    old_head->next = q->tail->next;
    free(q->tail);
    q->tail = old_head;
    
    return val;
}