//
// Created by nicolas on 18.02.21.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Note : N'oubliez pas qu'en C, l'entier qui représente le booléen "faux" est 0 et tous les autres entiers
// représentent le booléen "vrai". C'est donc l'inverse par rapport à la commande test(1) qui est en fait une
// fonction bash (shell).

int eq(const char* a, const char* b) {
    if (atoi(a) == atoi(b)) return 0;
    else return 1;
}

int ge(const char* a, const char* b) {
    if (atoi(a) >= atoi(b)) return 0;
    else return 1;
}

int gt(const char* a, const char* b) {
    if (atoi(a) > atoi(b)) return 0;
    else return 1;
}

int le(const char* a, const char* b) {
    if (atoi(a) <= atoi(b)) return 0;
    else return 1;
}

int lt(const char* a, const char* b) {
    if (atoi(a) < atoi(b)) return 0;
    else return 1;
}

int ne(const char* a, const char* b) {
    if (atoi(a) != atoi(b)) return 0;
    else return 1;
}


int main(int argc, char *argv[]) {

    if (strcmp(argv[2], "-eq") == 0) {
        return eq(argv[1], argv[3]);
    }
    else if (strcmp(argv[2], "-ge") == 0) {
        return ge(argv[1], argv[3]);
    }
    else if (strcmp(argv[2], "-gt") == 0) {
        return gt(argv[1], argv[3]);
    }
    else if (strcmp(argv[2], "-le") == 0) {
        return le(argv[1], argv[3]);
    }
    else if (strcmp(argv[2], "-lt") == 0) {
        return lt(argv[1], argv[3]);
    }
    else if (strcmp(argv[2], "-ne") == 0) {
        return ne(argv[1], argv[3]);
    }
    else {
        printf("Command does not exist\n");
        return 123456789;
    }

}
