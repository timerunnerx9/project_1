package project_1_launcher;
import project_1.utils.PassHash;
import project_1_DAO.UserDAO;

public class launcher {
	public static void main(String[] args) {
		
		/* if there's issue logging in
		1.change the password in database to 294597053
		2.run UserDAO.updatePassByID(1)
		3.print it out to test if it's true
		
		*/
		UserDAO.updatePassByID(1);
		
		System.out.println(PassHash.checkPass("294597053",UserDAO.getUserByUsername("davecen9").getPassword()));
	}
}