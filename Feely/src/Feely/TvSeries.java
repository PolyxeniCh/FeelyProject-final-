package Feely;
/*
 * � ����� �������� ��� ����������� ����� : ���������� �����
 */

import java.util.ArrayList;


@SuppressWarnings("serial")
public class TvSeries extends Category {


	private String IMDBLink;                                       //Link ��� ��� ���������� ����� ��� IMDB
	private ArrayList<String> genre = new ArrayList<String>();     //���� ��� ����� ������ � ���������� �����


	public TvSeries(String title, String link, String IMDBLink) {
		super(title, link);
		this.IMDBLink = IMDBLink;
	}


	// ---------- GETTERS ----------

	public String getIMDBLink() {
		return IMDBLink;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	// ------------------------------



	// ---------- SETTERS ----------

	public void setIMDBLink(String iMDBLink) {
		this.IMDBLink = iMDBLink;
	}

	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

	// ------------------------------

}
