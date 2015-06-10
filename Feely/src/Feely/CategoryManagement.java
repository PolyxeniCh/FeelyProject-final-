package Feely;
/*
 * Η κλάση αυτή περιέχει λειτουργίες που αφορούν το σύνολο των κατηγοριών των ενδιαφερόντων που υπάρχουν στο σύστημα.
 * 
 * Έχει ως σκοπό τη δημιουργία προτάσεων προς το χρήστη ανάλογα με τις προτιμήσεις και τη διάθεση του,
 * αλλά και την επεξεργασία των ίδιων των δεδομένων δίνοντας τη δυνατότητα προσθήκης νέων σε κάθε κατηγορία.
 * 
 * Όλες οι ιδιότητες και οι μέθοδοι που διαθέτει είναι στατικές.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;


public class CategoryManagement {


	private static ArrayList<Activity> activityList = new ArrayList<Activity>();           //Λίστα που περιέχει όλες τις Δραστηριότητες του συστήματος
	private static ArrayList<Book> bookList = new ArrayList<Book>();                       //Λίστα που περιέχει όλα τα Βιβλία του συστήματος
	private static ArrayList<Destination> destinationList = new ArrayList<Destination>();  //Λίστα που περιέχει όλους τους Προορισμούς του συστήματος
	private static ArrayList<Movie> movieList = new ArrayList<Movie>();                    //Λίστα που περιέχει όλες τις Ταινίες του συστήματος
	private static ArrayList<Music> musicList = new ArrayList<Music>();                    //Λιστα που περιέχει όλη τη Μουσική του συστήματος
	private static ArrayList<TvSeries> tvSeriesList = new ArrayList<TvSeries>();           //Λίστα που περιέχει όλες τις Τηλεοπτικές Σειρές του συστήματος

	private static final String tvSeries_MovieGenreMatrix[] = {"Action", "Fantasy", "Crime/Mystery", "Romance", "Comedy", "Drama", "Thriller"};                                                                                                  //Πίνακας που περιέχει όλα τα είδη Ταινιών και Τηλεοπτικών Σειρών
	private static final String musicGenreMatrix[] = {"Rock", "Metal", "Jazz", "Rap/Hip-hop", "Pop", "Electronic/Dance Music", "Classical Music", "Theme Songs", "Έντεχνα", "Λαϊκά"};                                                                                                       //Πίνακας που περιέχει όλα τα είδη Μουσικής
	private static final String bookGenreMatrix[] = {"Horror", "Suspense/Thriller", "Fantasy", "Crime/Detective", "Adventure", "YA", "Classic", "Romance", "Science Fiction", "Realistic Fiction", "Drama", "Greek Literature", "Nonfiction"};   //Πίνακας που περιέχει όλα τα είδη Βιβλίων
	private static final String destinationCategoryMatrix[] = {"Food", "Drink", "Night entertainment", "Coffee", "Internet-cafe", "Boardgame", "Theater"};                                                                                       //Πίνακας που περιέχει όλα τα είδη Προορισμών
	private static final String activityIntensityMatrix[] = {"Relaxing", "Active"};                                                                                                                                                 //Πίνακας που περιέχει όλα τα είδη Δραστηριοτήτων

	private static String currentMood;      //Τρέχουσα διάθεση του χρήστη


	public CategoryManagement() {
	}



	// ---------- SERIALIZATION ----------
	/*
	 * Αποθήκευση των αντικειμένων των κατηγοριών του συστήματος σε αρχεία ser
	 * (τα οποία θα αποτελούν βάση δεδομένων του συστήματος)
	 */
	
	public static void serialization() {

		//Δημιουργία αρχείου ser που περιέχει τη λίστα των Δραστηριοτήτων του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("Activities.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(activityList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

		//Δημιουργία αρχείου ser που περιέχει τη λίστα των Βιβλίων του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("Books.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(bookList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

		//Δημιουργία αρχείου ser που περιέχει τη λίστα των Προορισμών του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("Destinations.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(destinationList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

		//Δημιουργία αρχείου ser που περιέχει τη λίστα των Ταινιών του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("Movies.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(movieList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

		//Δημιουργία αρχείου ser που περιέχει τη λίστα της Μουσικής του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("Music.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(musicList);
			out.close();
			outStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}

		//Δημιουργία αρχείου ser που περιέχει τη λίστα των Τηλεοπτικών Σειρών του συστήματος
		try{
			FileOutputStream outStream = new FileOutputStream("TvSeries.ser");
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(tvSeriesList);
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
	 * Διάβασμα των αντικειμένων των κατηγοριών του συστήματος από αρχεία ser
	 */
	
	@SuppressWarnings("unchecked")
	public static void deserialization() {

		//Διάβασμα αρχείου ser που περιέχει τη λίστα των Δραστηριοτήτων του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("Activities.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			activityList = (ArrayList<Activity>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

		//Διάβασμα αρχείου ser που περιέχει τη λίστα των Βιβλίων του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("Books.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			bookList = (ArrayList<Book>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

		//Διάβασμα αρχείου ser που περιέχει τη λίστα των Προορισμών του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("Destinations.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			destinationList = (ArrayList<Destination>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

		//Διάβασμα αρχείου ser που περιέχει τη λίστα των Ταινιών του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("Movies.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			movieList = (ArrayList<Movie>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

		//Διάβασμα αρχείου ser που περιέχει τη λίστα της Μουσικής του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("Music.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			musicList = (ArrayList<Music>) in.readObject(); 
			in.close();
			inStream.close();
		}
		catch(IOException exc){
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}

		//Διάβασμα αρχείου ser που περιέχει τη λίστα των Τηλεοπτικών Σειρών του συστήματος
		try{
			FileInputStream inStream = new FileInputStream("TvSeries.ser");
			ObjectInputStream in = new ObjectInputStream(inStream);
			tvSeriesList = (ArrayList<TvSeries>) in.readObject(); 
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



	 // ---------- RECOMMENDATIONS ----------

	 public static ArrayList<Activity> recommendActivity(ArrayList<String> userActivityIntensityList) {
	  HashSet<Activity> preferredActivityList = new HashSet<Activity>();

	  for (Activity activityIterator: activityList)
	   for (String userIntensity: userActivityIntensityList)
	    if (activityIterator.getIntensity().contains(userIntensity))
	     for (String moodIterator : activityIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredActivityList.add(activityIterator);
	  
	  ArrayList<Activity> userActivityList = new ArrayList<Activity>();
	  
	  for (Activity act: preferredActivityList)
	   userActivityList.add(act);
	  
	  return userActivityList;
	 }

	 public static ArrayList<Book> recommendBook(ArrayList<String> userBookGenreList) {
	  HashSet<Book> preferredBookList = new HashSet<Book>();

	  for (Book bookIterator: bookList)
	   for (String userBookGenre: userBookGenreList)
	    if (bookIterator.getGenre().contains(userBookGenre))
	     for (String moodIterator : bookIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredBookList.add(bookIterator);
	  
	  ArrayList<Book> userBookList = new ArrayList<Book>();
	  
	  for (Book boo: preferredBookList)
	   userBookList.add(boo);
	  
	  return userBookList;
	 }

	 public static ArrayList<Destination> recommendDestination(ArrayList<String> userDestinationCategoryList) {
	  HashSet<Destination> preferredDestinationList = new HashSet<Destination>();

	  for (Destination destinationIterator: destinationList)
	   for (String userDestinationCategory: userDestinationCategoryList)
	    if (destinationIterator.getCategory().contains(userDestinationCategory))
	     for (String moodIterator : destinationIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredDestinationList.add(destinationIterator);
	  
	  ArrayList<Destination> userDestinationList = new ArrayList<Destination>();
	  
	  for (Destination dest: preferredDestinationList)
	   userDestinationList.add(dest);
	  
	  return userDestinationList;
	 }

	 public static ArrayList<Movie> recommendMovie(ArrayList<String> userMovieGenreList) {
	  HashSet<Movie> preferredMovieList = new HashSet<Movie>();

	  for (Movie movieIterator: movieList)
	   for (String userMovieGenre: userMovieGenreList)
	    if (movieIterator.getGenre().contains(userMovieGenre))
	     for (String moodIterator : movieIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredMovieList.add(movieIterator);

	  ArrayList<Movie> userMovieList = new ArrayList<Movie>();
	  
	  for (Movie mov: preferredMovieList)
	   userMovieList.add(mov);
	  
	  return userMovieList;
	 }

	 public static ArrayList<Music> recommendMusic(ArrayList<String> userMusicGenreList) {
	  HashSet<Music> preferredMusicList = new HashSet<Music>();

	  for (Music musicIterator: musicList)
	   for (String userMusicGenre: userMusicGenreList)
	    if (musicIterator.getGenre().contains(userMusicGenre))
	     for (String moodIterator : musicIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredMusicList.add(musicIterator);
	  
	  ArrayList<Music> userMusicList = new ArrayList<Music>();
	  
	  for (Music muse: preferredMusicList)
	   userMusicList.add(muse);
	  
	  return userMusicList;
	 }

	 public static ArrayList<TvSeries> recommendTvSeries(ArrayList<String> userTvSeriesGenreList) {
	  HashSet<TvSeries> preferredTvSeriesList = new HashSet<TvSeries>();

	  for (TvSeries tvSeriesIterator: tvSeriesList)
	   for (String userTvSeriesGenre: userTvSeriesGenreList)
	    if (tvSeriesIterator.getGenre().contains(userTvSeriesGenre))
	     for (String moodIterator : tvSeriesIterator.getMood())
	      if (currentMood.equalsIgnoreCase(moodIterator))
	       preferredTvSeriesList.add(tvSeriesIterator);
	  
	  ArrayList<TvSeries> userTvSeriesList = new ArrayList<TvSeries>();
	  
	  for (TvSeries tv: preferredTvSeriesList)
	   userTvSeriesList.add(tv);
	  
	  return userTvSeriesList;
	 }

	 // ------------------------------



	// ---------- ADD DATA ----------
	/*
	 * Προσθήκη αντικειμένων στις κατηγορίες του συστήματος
	 */

	//Προσθήκη νέας Δραστηριότητας στο σύστημα
	public static void addNewActivity(String title, String activityLink, String intensity, ArrayList<String> mood) {
		Activity newActivity = new Activity(title, activityLink, intensity);
		newActivity.setMood(mood);
		activityList.add(newActivity);
	}

	// Προσθήκη νέου Βιβλίου στο σύστημα
	public static void addNewBook(String title, String bookLink, String author, ArrayList<String> genre, ArrayList<String> mood) {
		Book newBook = new Book(title, bookLink, author);
		newBook.setGenre(genre);
		newBook.setMood(mood);
		bookList.add(newBook);
	}


	// Προσθήκη νέου Προορισμού στο σύστημα
	public static void addNewDestination(String title, String mapLink, String category, ArrayList<String> mood) {
		Destination newDestination = new Destination(title, mapLink, category);
		newDestination.setMood(mood);
		destinationList.add(newDestination);
	}

	// Προσθήκη νέας Ταινίας στο σύστημα
	public static void addNewMovie(String title, String trailerLink, String IMDBLink, ArrayList<String> genre, ArrayList<String> mood) {
		Movie newMovie = new Movie(title, trailerLink, IMDBLink);
		newMovie.setGenre(genre);
		newMovie.setMood(mood);
		movieList.add(newMovie);
	}

	// Προσθήκη νέας Μουσικής στο σύστημα
	public static void addNewMusic(String title, String songLink, String artist, ArrayList<String> genre, ArrayList<String> mood) {
		Music newMusic = new Music(title, songLink, artist);
		newMusic.setGenre(genre);
		newMusic.setMood(mood);
		musicList.add(newMusic);
	}

	// Προσθήκη νέας Τηλεοπτικής Σειράς στο σύστημα
	public static void addNewTvSeries(String title, String trailerLink, String IMDBLink, ArrayList<String> genre, ArrayList<String> mood) {
		TvSeries newTvSeries = new TvSeries(title, trailerLink, IMDBLink);
		newTvSeries.setGenre(genre);
		newTvSeries.setMood(mood);
		tvSeriesList.add(newTvSeries);
	}

	// ------------------------------



	// ---------- GETTERS ----------

	public static ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public static ArrayList<Book> getBookList() {
		return bookList;
	}

	public static ArrayList<Destination> getDestinationList() {
		return destinationList;
	}

	public static ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public static ArrayList<Music> getMusicList() {
		return musicList;
	}

	public static ArrayList<TvSeries> getTvSeriesList() {
		return tvSeriesList;
	}

	public static String[] getActivityintensitymatrix() {
		return activityIntensityMatrix;
	}

	public static String[] getBookgenrematrix() {
		return bookGenreMatrix;
	}

	public static String[] getDestinationcategorymatrix() {
		return destinationCategoryMatrix;
	}

	public static String[] getMusicgenrematrix() {
		return musicGenreMatrix;
	}

	public static String[] getTvseriesMoviegenrematrix() {
		return tvSeries_MovieGenreMatrix;
	}

	public static String getCurrentMood() {
		return currentMood;
	}

	// ------------------------------



	// ---------- SETTERS ----------

	public static void setActivityList(ArrayList<Activity> activityList) {
		CategoryManagement.activityList = activityList;
	}

	public static void setBookList(ArrayList<Book> bookList) {
		CategoryManagement.bookList = bookList;
	}

	public static void setDestinationList(ArrayList<Destination> destinationList) {
		CategoryManagement.destinationList = destinationList;
	}

	public static void setMovieList(ArrayList<Movie> movieList) {
		CategoryManagement.movieList = movieList;
	}

	public static void setMusicList(ArrayList<Music> musicList) {
		CategoryManagement.musicList = musicList;
	}

	public static void setTvSeriesList(ArrayList<TvSeries> tvSeriesList) {
		CategoryManagement.tvSeriesList = tvSeriesList;
	}

	public static void setCurrentMood(String currentMood) {
		CategoryManagement.currentMood = currentMood;
	}

	// ------------------------------

}
