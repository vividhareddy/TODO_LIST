package dao;

import java.util.List;

import beans.Register;
import beans.Task;

public class ToDoDAOImpl implements ToDoDAO {

	@Override
	public int register(Register register) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int login(String email, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Task> findTasksByRegId(int regId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTask(Task task, int regId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean markTaskCompleted(int taskId, int regId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFLNameByRegID(int regId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ToDoDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
