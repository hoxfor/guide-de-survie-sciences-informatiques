//
// Created by nicolas on 16.02.21.
//
#include <stdlib.h>
#include <stdio.h>

struct vector_t {
    int size;
    float *v;
};
// initialise le vecteur à la valeur du réel
struct vector_t * init(int size, float value) {
    struct vector_t *vector = malloc(sizeof (struct vector_t));
    if (vector == NULL) return NULL;

    vector->v = malloc(sizeof (float)*size);
    if (vector->v == NULL) {
        free(vector);
        return NULL;
    }
    *(vector->v) = value;

    return vector;
}

// récupère le nième élément
float get(struct vector_t *, int);
// fixe la valeur du nième élément

void set(struct vector_t *, int , float);

// supprime un vecteur
void destroy(struct vector_t *);