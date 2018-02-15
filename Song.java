package topMusic;

public class Song {
	private String title;
	private String artist;
	private int year;

	public Song(String title, String artist, int year) {
		this.setTitle(title);
		this.setArtist(artist);
		this.setYear(year);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return title + " by " + artist + " released in " + year;
	}
}
