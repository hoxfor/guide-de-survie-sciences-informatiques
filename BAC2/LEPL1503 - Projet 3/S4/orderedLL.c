//
// Created by nicolas on 28.02.21.
//

#include "orderedLL.h"

#include <stdlib.h>

int compare(char a, char b) {
    if (a == b) {
        return 0;
    } else if (a > b) {
        return 1;
    } else {
        return -1;
    }
}

int insert(node_t **head, char val, int (*cmp)(char,char)) {
    if (head == NULL || *head == NULL) {
        node_t *new = (node_t *) malloc(sizeof(node_t));
        if (new == NULL) return -1;
        new->val = val;
        new->next = NULL;
        *head = new;
        return 0;
    }

    if (cmp(val, (*head)->val) == 0) return 0;
    if (cmp(val, (*head)->val) < 0) {
        node_t *new = (node_t *) malloc(sizeof(node_t));
        if (new == NULL) return -1;
        new->val = val;
        new->next = *head;
        *head = new;
        return 0;
    }
    node_t *place = *head;
    while (place->next != NULL && cmp(place->next->val, val) < 0) place = place->next;
    if (place->next != NULL) {
        if (cmp(place->next->val, val) == 0) return 0;
    }
    node_t *new = (node_t*) malloc(sizeof (node_t));
    if (new == NULL) return -1;
    new->val = val;
    new->next = place->next;
    place->next = new;
    return 0;
}