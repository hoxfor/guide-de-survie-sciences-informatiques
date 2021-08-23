//
// Created by nicolas on 25.02.21.
//

#include "filterList.h"
#include <stdlib.h>
#include <string.h>



struct node *pair_filter(struct node *head) {
    if (head == NULL) return NULL;

    size_t list_size = sizeof (*head);
    struct node *copy = malloc(list_size);

    if (copy == NULL) return NULL;

    memcpy(copy, head, list_size);

    if (head->next != NULL) {
        copy->next = pair_filter(head->next->next);
    }
    return copy;
}