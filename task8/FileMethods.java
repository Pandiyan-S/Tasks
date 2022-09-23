package task8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	public void sampleWords(FileWriter writer,String str) throws IOException,UserException
	{
		check(writer);
		check(str);
		writer.write(str);
		writer.flush();
	}
	//ex2
	public void append(Properties prop,String key, String Value) throws UserException
	{
		check(prop);
		prop.setProperty(key, Value);
	}
	public void serial(Properties prop,File file) throws UserException
	{
		check(prop);
		check(file);
		try(FileWriter writer = new FileWriter(file))
		{
			prop.store(writer, "Properties");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	//ex3
	public void deserial(Properties prop,File file) throws UserException
	{
		check(prop);
		check(file);
		try(FileReader reader = new FileReader(file))
		{
			prop.load(reader);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	//ex4
}
