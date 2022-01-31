//
// Created by nicolas on 09.02.21.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
    for (int i = 1; i < argc; i++) {
        if (i % 2 != 0) {
            printf("%s", argv[i]);
        } else {
            if (i != argc -1) {
                printf(" ");
            }
        }
    }
    printf("\n");
    return EXIT_SUCCESS;
}