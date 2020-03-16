package project_1_launcher;
import project_1.utils.PassHash;
import project_1_DAO.UserDAO;

public class launcher {
	public static void main(String[] args) {
		UserDAO.updatePassByID(1);
		
		System.out.println(PassHash.checkPass("294597053",UserDAO.getUserByUsername("davecen9").getPassword()));
	}
}
