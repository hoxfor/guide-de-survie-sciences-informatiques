//
// Created by nicolas on 22.02.21.
//

#ifndef S4_SIMPLESTACK_H
#define S4_SIMPLESTACK_H

struct node {
    struct node *next;
    char *name;
};

int pop(struct node **head, char *result);

int push(struct node **head, const char *value);

struct node *init_stack(char *value);

void run_push();


#endif //S4_SIMPLESTACK_H
