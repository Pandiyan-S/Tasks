package basictask;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Properties;
import check.UserException;

public class FileMethods
{
	public void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	//ex1
	public void sampleWords(String fileName,String[] array) throws UserException,IOException
	{
		check(fileName);
		check(array);
		File folder = new File(fileName);
		try(FileWriter writer = new FileWriter(folder))
		{
			for(int i=0; i<array.length; i++)
			{
				writer.write(array[i]);
				//swami - resolved
			}
			writer.flush();
		}
	}
	//ex2
	public Properties append(Properties prop,String key, String value) throws UserException
	{
		check(key);
		check(value);
		prop.setProperty(key, value);//swami - resolved
		return prop;
	}
	public void serial(Properties prop,String fileName) throws UserException, IOException
	{
		check(prop);
		check(fileName);
		File file = new File(fileName);
		try(FileWriter writer = new FileWriter(file))
		{
			prop.store(writer, "Properties");
		}//swami - resolved
	}
	//ex3
	public void deSerial(Properties prop,String fileName) throws UserException,IOException
	{
		check(fileName);
		check(prop);
		File file = new File(fileName);
		try(FileReader reader = new FileReader(file))
		{
			prop.load(reader);
		}
		
	}
	//ex4
	public void createDirectory(String directoryName)
	{
		File directory = new File(directoryName);
		directory.mkdir();
	}
	//ex8
	public Class<?> findClass(String pojoPath) throws ClassNotFoundException
	{
		Class<?> c = Class.forName(pojoPath);
		return c;
	}
	public Constructor<?> defaultConstructor(Class<?> c) throws ReflectiveOperationException
	{
		Constructor<?> ctor = c.getDeclaredConstructor();
		return ctor;
	}
	public Object createDefaultObj(Constructor<?> ctor) throws ReflectiveOperationException
	{
		Object obj = ctor.newInstance();
		return obj;
	}
	public Constructor<?> argsConstructor(Class<?> c,Class<?> str,Class<?> no) throws ReflectiveOperationException
	{
		Constructor<?> ctor = c.getDeclaredConstructor(str,no);
		return ctor;
	}
	public Object createOverObj(Constructor<?> ctor,String str,int no) throws ReflectiveOperationException
	{
		Object obj = ctor.newInstance(str,no);
		return obj;
	}
	public Method methodCall(Class<?> c,String str,Class<?>... no) throws ReflectiveOperationException
	{
		Method meth = c.getDeclaredMethod(str,no);
		return meth;
	}
	public void setterInvoke(Method meth,Object c,Object... str) throws ReflectiveOperationException
	{
		meth.invoke(c, str);
	}
	public Object getterInvoke(Method meth,Object c) throws ReflectiveOperationException
	{
		return meth.invoke(c);
	}
	//ex11
	public LocalDateTime getDateTime()
	{
		return LocalDateTime.now();
	}
	public long milliTime()
	{
		return System.currentTimeMillis();//swami - millies() from java.time.Clock
	}
	public ZonedDateTime worldTime(ZoneId zone) throws UserException
	{
		return ZonedDateTime.now(zone);
	}
	public DayOfWeek weekDay(LocalDateTime day) throws UserException
	{
		check(day);
		return day.getDayOfWeek();
	}
	public Month month(LocalDateTime day) throws UserException
	{
		check(day);
		return day.getMonth();
	}
	public int years(LocalDateTime day) throws UserException
	{
		check(day);
		return day.getYear();
	}
}
