#include<iostream>
#include <thread>


void hola()
{
  std::cout <<"Hola Mundo..." << std::this_thread::get_id()<< " ";;

}

int main()
{

  std::thread h(hola);

  h.join();
  std::cout << "Hilo main tambien saluda...";
  return(0);
}
