//
// Created by nicolas on 18.02.21.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct product {
    char *name;
    double price;
} product_t;

/**
 * @ptrProd != NULL
 * @return: the price of the product ptrProd
 */
double getPtrPrice(product_t *ptrProd) {
    return ptrProd->price;
}

/**
 * @return: the price of the product prod
 */
double getPrice(product_t prod) {
    return prod.price;
}

/**
 * ptrProd != NULL
 * @name in ptrProd != NULL
 * @return: a string on the heap that contains the name of the product ptrProd or NULL if an error happens
 **/
char* getPtrName(product_t *ptrProd) {
    char* copy;
    copy = malloc(sizeof(char)*strlen(ptrProd->name)+1);
    if (copy == NULL) return NULL;
    strcpy(copy, ptrProd->name);
    return copy;
}

/**
* @name in prod != NULL
* @return: a string on the heap that contains the name of the product ptrProd or NULL if an error happens
*/
char* getName(product_t prod) {
    char* copy;
    copy = malloc(sizeof(char)*strlen(prod.name)+1);
    if (copy == NULL) return NULL;
    strcpy(copy, prod.name);
    return copy;
}

/**
 * @ptrProd != NULL
 * @name in ptrProd != NULL
 * @name in prod != NULL
 * @return: 1 if the two products are the same, i.e., they have the same price and the same name
 */
int prodEquals(product_t *ptrProd, product_t prod) {
    if (ptrProd->price == prod.price && strcmp(ptrProd->name, prod.name) == 0) return 1;
    return 0;
}