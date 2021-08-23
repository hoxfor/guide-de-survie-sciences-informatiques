//
// Created by nicolas on 17.02.21.
//
#include <stdlib.h>
#include <stdio.h>

typedef struct node{
    int value;
    struct node* left; // to smaller values
    struct node* right; // to larger values
} node_t;

typedef struct bt{
    struct node* root;
} bt_t;

int inspectNode(node_t* node, int value) {
    if (node == NULL) return 0;
    if (node->value == value) return 1;
    else if (node->value > value) {
        return inspectNode(node->left, value);
    }
    else if (node->value < value) {
        return inspectNode(node->right, value);
    }
    return 0;
}

/**
* Return 1 if there is a node containing @value in @tree and 0 otherwise.
*/
int contains(bt_t* tree, int value){
    if (tree == NULL) return 0;
    else return inspectNode(tree->root, value);

}
