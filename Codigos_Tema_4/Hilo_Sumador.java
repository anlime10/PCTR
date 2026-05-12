

class HiloSumador
	extends Thread
{	
	private Monitor Data;
	public HiloSumador(Monitor Ref){Data=Ref;}
	public void run()
	{
		for(;;)Data.INC();
	}	
}

