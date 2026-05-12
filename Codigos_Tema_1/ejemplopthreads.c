#include <pthread.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define NUM_THREADS 3

int I = 0;

void *threadEngine (void *id){
   int i;
   for(i = 0; i < 50; i++)
      printf("Hilo %d: i = %d, I = %d\n", *(int *)id, i, I++);
   pthread_exit (id);
}

int main(){
   int h;
   pthread_t hilos[NUM_THREADS];
   int id[NUM_THREADS] = {1, 2, 3};
   int error;
   int *salida;

   for(h = 0; h < NUM_THREADS; h++){
      error = pthread_create( &hilos[h], NULL, threadEngine, &id[h]);
      if (error){
        fprintf (stderr, "Error: %d: %s\n", error, strerror (error));
        exit(-1);
      }
   }
   for(h =0; h < NUM_THREADS; h++){
      error = pthread_join(hilos[h], (void **)&salida);
      if (error)
         fprintf (stderr, "Error: %d: %s\n", error, strerror (error));
      else
         printf ("Hilo %d terminado\n", *salida);
   }
}