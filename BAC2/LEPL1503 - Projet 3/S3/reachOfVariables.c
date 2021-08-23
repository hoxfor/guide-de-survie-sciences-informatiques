//
// Created by nicolas on 15.02.21.
//

#include <stdio.h>

int result;

void sum1(int a1, int b1) {
    a1 = a1 + b1;
}

void sum2(int a, int b) {
    result = a+b;
}

void sum3 (int *a, int *b, int *r) {
    *r = *a + *b;
}
