//
// Created by nicolas on 22.02.21.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "simpleStack.h"

int pop(struct node **head, char *result) {
    if (head == NULL || *head == NULL) return 1;

    struct node *popped = *head;
    strcpy(result, popped->name);

    if (result == NULL) {
        free(result);
        return 1;
    }

    *head = (*head)->next;
    free(popped->name);
    free(popped);
    return 0;
}

int push(struct node **head, const char *value) {
    if (head == NULL || *head == NULL || value == NULL) return 1;

    struct node *toAdd = malloc(sizeof(struct node));
    if (toAdd == NULL) return 1;

    char *newName = (char*) malloc(sizeof(char) * strlen(value) + 1);
    if (newName == NULL) {
        free(toAdd);
        return 1;
    }
    strcpy(newName, value);
    toAdd->name = newName;
    toAdd->next = *head;
    *head = toAdd;
    return 0;
}

struct node *init_stack(char *value) {
    struct node *head = malloc(sizeof(struct node));
    if (head == NULL) return NULL;

    size_t val_size =sizeof (char) * strlen(value)+1;
    head->name = malloc(val_size);
    if (head->name == NULL) {
        free(head);
        return NULL;
    }
    head->name = value;

    return head;
}

void run_push() {
    struct node *stack = init_stack("I'm a head");
    printf("Head : %s\n", stack->name);
    push(&stack , "value");
    printf("Head : %s\n", stack->name);
}
