package virtualclassroom;

public class StudyMaterial
{
	long materialId;
	int postedBy;
	String topic;
	String fileType;
	String link;
	public long getMaterialId()
	{
		return materialId;
	}
	public void setMaterialId(long materialId)
	{
		this.materialId = materialId;
	}
	public int getPostedBy()
	{
		return postedBy;
	}
	public void setPostedBy(int postedBy)
	{
		this.postedBy = postedBy;
	}
	public String getTopic()
	{
		return topic;
	}
	public void setTopic(String topic)
	{
		this.topic = topic;
	}
	public String getFileType()
	{
		return fileType;
	}
	public void setFileType(String type)
	{
		this.fileType = type;
	}
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("\nMaterial Id:");
		str.append( materialId);
		str.append("\nPosted by:");
		str.append(postedBy);
		str.append("\nTopic:");
		str.append(topic);
		str.append("\nFile Type:");
		str.append(fileType);
		str.append("\nLink:");
		str.append( link);
		return str.toString();
	}
}
