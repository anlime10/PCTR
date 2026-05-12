
class HiloRestador
	extends Thread
{	
	private Monitor Data;
	public HiloRestador(Monitor Ref){Data=Ref;}
	public void run()
	{
		for(;;)Data.DEC();
	}	
}