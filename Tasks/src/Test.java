
public class Test {
	
	int isTwistedPrime(int N)
    {
        int temp = N;
        int rev = 0;
        while(temp !=0)
        {
            rev *= 10;
            rev += temp%10;
            temp /= 10;
        }
        
        int l=2;
        int r=N;
        while(l<r)
        {
            if(N%l == 0)
            {
                return -1;
            }
        }
        l=2;
        r=rev;
        while(l<r)
        {
            if(rev%l == 0)
            {
                return -1;
            }
        }
        return 1;
    }
	
	
	
		public static void main(String args[])
		{
			Test test = new Test();
			test.isTwistedPrime(97);
//			for(int no:)
//			{
//				System.out.print(no + " ");
//			}
		}
}
