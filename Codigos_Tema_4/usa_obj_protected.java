
class Hilo implements Runnable
{
	obj_protected var;
	public Hilo (obj_protected recurso)
	{
		var = recurso;
	}
	public void run()
	{
		var.m2();
	}

}

public class usa_obj_protected {

    public static void main(String[] args)
    {
      obj_protected a = new obj_protected();
      Runnable Tarea = new Hilo (a);
      new Thread (Tarea).start();

    }
}
