//
// Created by nicolas on 25.02.21.
//

#ifndef S4_FILTERLIST_H
#define S4_FILTERLIST_H

struct node {
    struct node *next;
    int hash;
    int id;
    char name[20];
    char buffer[100];
    unsigned int timestamp;
    char acl;
    short flow;
    char *parent;
    void *fifo;
};

struct node *pair_filter(struct node *head);

#endif //S4_FILTERLIST_H

