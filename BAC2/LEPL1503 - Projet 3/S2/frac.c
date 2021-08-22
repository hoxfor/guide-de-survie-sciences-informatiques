//
// Created by nicolas on 15.02.21.
//

struct fract_t {
        int num;
        int denum;
};

void swapFract(struct fract_t *a, struct fract_t *b) {
    struct fract_t tmp = *a;
    a->num = b->num;
    a->denum = b->denum;
    b->num = tmp.num;
    b->denum = tmp.denum;
}
