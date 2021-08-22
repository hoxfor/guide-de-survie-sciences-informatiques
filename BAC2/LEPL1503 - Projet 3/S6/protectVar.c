//
// Created by nicolas on 10.03.21.
//
#include <pthread.h>
int protect(void inc(void), int nb, pthread_mutex_t* mutex) {
    while (nb != 0) {
        int lock = pthread_mutex_lock(mutex);
        if (lock != 0) return -1;
        inc();
        nb--;
        int unlock = pthread_mutex_unlock(mutex);
        if (unlock != 0) return -1;
    }
    return 0;
}
