package virtualclassroom;

public class Doubts
{
	Long doubtId;
	String question;
	String answer;
	public Long getDoubtId() {
		return doubtId;
	}
	public void setDoubtId(Long doubtId) {
		this.doubtId = doubtId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("\nDoubt Id:");
		str.append( doubtId);
		str.append("\nQuestion:");
		str.append(question);
		str.append("\nAnswer:");
		str.append(answer);
		return str.toString();
	}
}
