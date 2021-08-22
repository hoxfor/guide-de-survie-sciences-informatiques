//
// Created by nicolas on 28.02.21.
//

#ifndef S4_ORDEREDLL_H
#define S4_ORDEREDLL_H

typedef struct node{
    char val;
    struct node *next;
} node_t;


int compare(char a, char b);

#endif //S4_ORDEREDLL_H
