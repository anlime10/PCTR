#include <stdio.h>
#include <threads.h>

// motor de ejecución
int hilo_calculador(void* arg) {
    int id = *(int*)arg;
    long resultado = 0;
    
    printf("Hilo %d: iniciando cálculos\n", id);
    for (long i = 0; i < 100000000; i++) {
        resultado += i * i;
    }
    printf("Hilo %d: terminado (resultado: %ld)\n", id, resultado);
    return 0;
}

int main(void) {
    thrd_t hilos[3];
    int ids[3] = {1, 2, 3};
    
    printf("Main: creando hilos de cálculo...\n");
    for (int i = 0; i < 3; i++) {
        thrd_create(&hilos[i], hilo_calculador, &ids[i]);
        printf("Hilo %d creado\n", ids[i]);
    }
    printf("Main: todos los hilos en ejecución concurrente\n");
    return 0;
}