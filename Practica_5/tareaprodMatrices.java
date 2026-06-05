public class tareaprodMatrices implements Runnable{
    public int ini,fin;
    public int[][] m1,m2,mr;
    public tareaprodMatrices(int inicio, int fina, int[][]m11,int[][]m22,int[][] mr1)
    {
        ini=inicio;
        fin=fina;
        m1 = m11;
        m2 = m22;
        mr = mr1;
    }
    @Override
    public void run()
    {
        for(int i=ini; i<fin;i++)
        {
            for (int j=0;j<m1.length;j++)
            {
                int mult=0;
                for (int k=0;k<m1.length;k++)
                {
                    mult=(m1[i][k]*m2[k][j])+mult;
                }
                mr[i][j]=mult;
            }
        }
    }
}
