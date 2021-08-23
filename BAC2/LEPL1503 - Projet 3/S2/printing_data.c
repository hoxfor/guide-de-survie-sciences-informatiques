//
// Created by nicolas on 03.02.21.
//

#include <stdio.h>

/** print_digit
 * @n: an integer
 *
 * result: print to stdout "The magic number is NUMBER.\n"
 **/
void print_digit(int number) {
    printf("The magic number is %d.\n", number);
}

void print_foo() {
    printf("%s", "foo\n");
}

/** format_str, example:
 * format_str(buf, 42, "Olivier", 'B') will write into buf
 * the string "Mister Olivier B. has 42 eggs" (no line feed)
 * The given buffer is guaranteed to be big enough
 **/
void format_str(char *buffer, unsigned int d, char *name, char initial) {
    sprintf(buffer, "Mister %s %c. has %d eggs", name, initial, d);
}
