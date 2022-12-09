package virtualclassroom;

import java.util.List;

import check.UserException;

public class LogicalLayer
{

	public void sendRequest(String password, String name, String dob, long phNo, String type) throws UserException
	{
		StorageLayer store = new StorageLayer();
		UserInfo user = new UserInfo();
		user.setPassword(password);
		user.setName(name);
		user.setDob(dob);
		user.setPhoneNumber(phNo);
		user.setType(type);
		store.insertRequest(user);
	}

	public UserInfo findUser(int userId, String password) throws UserException
	{
		StorageLayer store = new StorageLayer();
		UserInfo user = store.findif(userId,password);
		return user;
	}

	public void updateProfile(int userId, String name, String dob, long phNo) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.updateUser(userId,name,dob,phNo);
	}

	public void deleteMaterial(Long materialId) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.deleteMaterial(materialId);
	}

	public boolean checkId(int userId, Long materialId) throws UserException
	{
		StorageLayer store = new StorageLayer();
		return store.checkUser(userId,materialId);
	}

	public void upload(int userId,String topic, String fileType, String link) throws UserException
	{
		StorageLayer store = new StorageLayer();
		StudyMaterial study = new StudyMaterial();
		study.setPostedBy(userId);
		study.setTopic(topic);
		study.setFileType(fileType);
		study.setLink(link);
		store.newMaterial(study);
	}

	public List<StudyMaterial> yourMaterial(int userId) throws UserException
	{
		StorageLayer store = new StorageLayer();
		List<StudyMaterial> study = store.findYourMaterial(userId);
		return study;
	}

	public List<StudyMaterial> thisMaterial(String topic) throws UserException
	{
		StorageLayer store = new StorageLayer();
		List<StudyMaterial> study = store.particularMaterial(topic);
		return study;
	}

	public void askQuestion(String question) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.insertDoubt(question);
	}

	public List<Doubts> allDoubts() throws UserException
	{
		StorageLayer store = new StorageLayer();
		List<Doubts> ask = store.allDoubts();
		return ask;
	}

	public void answerQuestion(long doubtId,String answer) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.upadateDoubt(doubtId,answer);
	}

	public List<UserInfo> allUsers() throws UserException
	{
		StorageLayer store = new StorageLayer();
		return store.allUsers();
	}

	public List<UserInfo> allPending() throws UserException
	{
		StorageLayer store = new StorageLayer();
		return store.allPending();
	}

	public void removeDoubt(long doubtId) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.deleteDoubt(doubtId);
	}

	public void updateStatus(int userId, String string) throws UserException
	{
		StorageLayer store = new StorageLayer();
		store.updateUserStatus(userId,string);
	}
}
