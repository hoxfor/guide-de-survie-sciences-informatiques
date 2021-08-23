//
// Created by nicolas on 22.02.21.
//

#include <stdint.h>
#include "compFunct.h"

uint8_t function1(uint8_t a) {
    return a + a;
}

uint8_t function2 (uint8_t a) {
    return a + a;
}

uint8_t function3 (uint8_t a) {
    return a * a;
}

uint8_t cmp_func(uint8_t f1(uint8_t a), uint8_t f2(uint8_t b)) {
    for (int i = 0; i < 256; ++i) {
        int result_f1 = f1(i);
        int result_f2 = f2(i);
        if (result_f1 != result_f2) return 0;
    }
    return 1;
}

