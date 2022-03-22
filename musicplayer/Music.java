package com.TestYantra.musicplayer;

public class Music implements Comparable {
	private int Song_ID;
	private String Song_Title;
	private String Artist_Name;
	private String Album_Name;
	private String Song_Location;
	private String Description;

	public Music() {
		super();
	}

	public Music(int song_ID, String song_Title, String artist_Name, String album_Name, String song_Location,
			String description) {
		super();
		Song_ID = song_ID;
		Song_Title = song_Title;
		Artist_Name = artist_Name;
		Album_Name = album_Name;
		Song_Location = song_Location;
		Description = description;
	}

	public int getSong_ID() {
		return Song_ID;
	}

	public void setSong_ID(int song_ID) {
		Song_ID = song_ID;
	}

	public String getSong_Title() {
		return Song_Title;
	}

	public void setSong_Title(String song_Title) {
		Song_Title = song_Title;
	}

	public String getArtist_Name() {
		return Artist_Name;
	}

	public void setArtist_Name(String artist_Name) {
		Artist_Name = artist_Name;
	}

	public String getSong_Location() {
		return Song_Location;
	}

	public void setSong_Location(String song_Location) {
		Song_Location = song_Location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "music [Song_ID=" + Song_ID + ", Song_Title=" + Song_Title + ", Artist_Name=" + Artist_Name
				+ ", Album_Name=" + Album_Name + ", Song_Location=" + Song_Location + ", Description=" + Description
				+ "]";
	}

	@Override
	public int compareTo(Object o) {
		Music m = (Music) o;
		char firstele = this.Song_Title.charAt(0);
		char secondtele = m.Song_Title.charAt(0);
		if (firstele > secondtele) {
			return 1;
		} else if (firstele < secondtele) {
			return -1;
		}

		return 0;
	}

	public String getAlbum_Name() {
		return Album_Name;
	}

	public void setAlbum_Name(String album_Name) {
		Album_Name = album_Name;
	}

}
