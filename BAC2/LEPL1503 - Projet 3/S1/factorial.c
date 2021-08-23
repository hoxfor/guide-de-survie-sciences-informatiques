//
// Created by nicolas on 03.02.21.
//
#include <stdio.h>

int factorial( int n) {
    if (n <= 1) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}


int main() {
    printf("%d", factorial(5));
}
