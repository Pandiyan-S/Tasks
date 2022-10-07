import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorld
{
	public static void main(String[] args)
	{
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(3,2);
        hm.put(2,8);
        Logger logger = Logger.getLogger("sample");
        logger.log(Level.INFO,"Hello, World!",hm);
    }
}