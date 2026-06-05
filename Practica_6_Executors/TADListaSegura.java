public class TADListaSegura {
    public int[] array;
    public TADListaSegura()
    {
        array= new int[0];
    }
    public synchronized void insertar(int x){
        int[] array1= new int[array.length+1];
        for(int i=0; i<array.length;i++)
        {
            array1[i]=array[i];
        }
        array1[array.length]=x;
        array=array1;

    }
    public synchronized int ver(int y)
    {
        return array[y];
    }
    public synchronized void eliminar (int x)
    {
        int[] array1= new int[array.length-1];
        for (int i=0;i<x;i++)
        {
            array1[i]=array[i];
        }
        for (int i=x;i<array1.length;i++)
        {
            array1[i]=array[i+1];
        }
        array=array1;
    }
    public synchronized int tam() {return array.length;}
    public synchronized void imprimir_lista()
    {
        for (int i=0; i<array.length;i++)
        {
            System.out.print(" " + array[i] );
        }
    }
}
