package Feely;
/*
 * Η κλάση αυτή περιέχει λειτουργίες που αφορούν το σύνολο των χρηστών που υπάρχουν στο σύστημα.
 * 
 * Έχει ως σκοπό τον έλεγχο εγκυρότητας των δεδομένων ενός χρήστη που θέλει
 * να εισέρθει ή και να εγγραφεί στο σύστημα.
 * 
 * Όλες οι ιδιότητες και οι μέθοδοι που διαθέτει είναι στατικές.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class UserManagement {


	private static ArrayList<User> userList = new  ArrayList<User>();   //Λίστα που περιέχει όλους τους χρήστες του συστήματος
	private static String currentUsername;                              //Όνομα του τρέχοντα χρήστη


	public  UserManagement() {
	}



	// ---------- LOG IN ----------
	/*
	 * Ελέγχει αν ένας χρήστης επιτρέπεται να εισέλθει στο λογαριασμό που επιθυμεί.
	 * Ανάλογα με την εγκυρότητα των στοιχείων που έχουν εισαχθεί επιστρέφεται μια ακέραια τιμή.
	 */

	public static int logInVerification(String username, String password) {

		Boolean wrongPassword = false;
		Boolean wrongUsername = true;

		deserialization();
		CategoryManagement.deserialization();

		if(username.equals("") || password.equals("")) {
			return 3;                               //Ύπαρξη άδειου πεδίου
		}

		for (User u : userList) {
			if (u.getUsername().equals(username)) {
				wrongUsername = false;
				if (u.getPassword().equals(password)) {

					currentUsername = username;
					return 0;                       //Γίνεται το Log In

				}
				else wrongPassword = true;
			}
			else wrongUsername = true;
		}

		if (wrongUsername) return 1;               //Δεν υπάρχει ο λογαριασμός στον οποίο θέλει να συνδεθεί ο χρήστης
		if (wrongPassword) return 2;               //Ο κωδικός που έβαλε ο χρήστης δεν συμφωνεί με τον κωδικό του λογαριασμού

		return 0;

	}

	// ------------------------------



	// ---------- SIGN UP ----------
	/*
	 * Ελέγχει αν ένας χρήστης επιτρέπεται να δημιουργήσει νέο λογαριασμό με τα στοιχεία που έχει εισάγει.
	 * Ανάλογα με την εγκυρότητα των στοιχείων που έχουν εισαχθεί επιστρέφεται μια ακέραια τιμή.
	 */

	public static int signUpVerification(String username, String password, String repeatPassword) {

		deserialization();
		CategoryManagement.deserialization();

		if(username.equals("") || password.equals("") || repeatPassword.equals("")) {
			return 4;                                   //Κάποιο από τα πεδία είναι κενό
		}

		//Έλεγχος για το username
		for (User u : UserManagement.getUserList()) {
			if (u.getUsername().equals(username)) {
				return 1;                               //To username χρησιμοποιείται από κάποιον άλλο χρήστη
			}
		}

		//Έλεγχος για τα password.
		if (!password.equals(repeatPassword)) {
			return 2;                                   //Τα password δεν συμφωνούν
		}

		if (username.equalsIgnoreCase(password)) {
			return 3;                                   //Το password είναι ίδιο με το username και γι' αυτό θεωρείται εύκολος κωδικός
		}

		//Δημιουργία αντικειμένου σε περίπτωση που τα στοιχεία ειναι σωστά.
		userList.add(new User(username, password));
		serialization();
		return 0;                                       //Γίνεται το Sign Up

	}

	// ------------------------------



	// ---------- SERIALIZATION ----------
	/*
	 * Αποθήκευση της λίστας με τους χρήστες του συστήματος σε ένα αρχείο ser
	 * (το οποίο θα αποτελεί βάση δεδομένων του συστήματος)
	 */

	public static void serialization() {

		try{
			FileOutputStream outStream = new FileOutputStream("Users.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(userList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

	}

	// ------------------------------



	// ---------- DESERIALIZATION ----------
	/*
	 * Διάβασμα της λίστας των χρηστών του συστήματος από αρχείο ser
	 */

	@SuppressWarnings("unchecked")
	public static void deserialization() {

		try{
			FileInputStream inStream = new FileInputStream("Users.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			userList = (ArrayList<User>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

	}

	// ------------------------------



	// ---------- GETTERS ----------

	public static ArrayList<User> getUserList() {
		return userList;
	}

	public static String getCurrentUsername() {
		return currentUsername;
	}

	// ------------------------------


	public static User getCurrentUser(){
		for(User u : userList){
			if(u.getUsername().equals(currentUsername)){
				return u;
			}
		}
		return null;
	}


	// ---------- SETTERS ----------

	public static void setUserList(ArrayList<User> userList) {
		UserManagement.userList = userList;
	}

	public static void setCurrentUsername(String currentUsername) {
		UserManagement.currentUsername = currentUsername;
	}

	// ------------------------------

}