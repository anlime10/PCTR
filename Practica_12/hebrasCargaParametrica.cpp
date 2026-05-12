#include<iostream>
#include <thread>
#define nHilos 100
using namespace std;

void hola(int hola) //codigo a ejecutar por la hebras con parametros
{
    cout <<"Hola Mundo..." << this_thread::get_id()<< " ";
}

int main()
{ 
    thread hilos[nHilos];
    for(int i=0; i<nHilos; i++)hilos[i]=thread (hola, i); //las hebras se crean -y ejecutan de esta forma
    for(int i=0; i<nHilos; i++)hilos[i].join();
    cout << "Hilo main tambien saluda...";
    return(0);
}

