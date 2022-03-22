package com.TestYantra.musicplayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MusicPlayer {

	public static void main(String[] args) throws InterruptedException {

		ArrayList<Music> arraylist = new ArrayList<Music>();
		arraylist.add(new Music(01, "Anbe Peranbe", "Shreya Ghoshal, Sid Sriram", "Tamil Love Songs", "Movie:NGK",
				"Song: Full of Romantic Love Songs..."));
		arraylist.add(new Music(02, "Munbe Vaa", "Shreya Ghoshal, Naresh Iyer", "Tamil Love Songs",
				"Movie:Sillunu Oru Kaadhal",
				"Song: Full of Romantic Love Songs and Awards:Filmfare Award for Best Female Playback Singer..."));
		arraylist.add(new Music(03, "Ava Ena", "Karthik, Harris Jayaraj,V.V.Prasanna", "Tamil Sad Songs",
				"Movie:Vaaranam Aayiram", "Song: Sad Songs..."));
		arraylist.add(new Music(04, "Malare", "Vijay Yesudas", "Malayalam Love Song", "Movie:Premam",
				"Song: Romantic Love Songs..."));
		arraylist.add(new Music(05, "Mizhiyoram", "K.J. Yesudas", "Malayalam Sad Songs", "Movie:Manjil Virinja Pookal",
				"Song: Sad Song..."));

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" ");
			System.out.println("----****** Music Player *****-----");
			System.out.println("..Press 1 to Play a Song");
			System.out.println("..Press 2 to Search A Song");
			System.out.println("..Press 3 to Show all Songs");
			System.out.println("..Press 4 to Operate on Songs Database");
			int input = sc.nextInt();
			switch (input) {
			case 1:

				System.out.println("..Press A to Play all Song");
				System.out.println("..Press B to Play Songs Randomly");
				System.out.println("..Press C to Play a Particular Song");
				String option = sc.next();

				switch (option) {

				case "A":
					Comparator c1 = (o1, o2) -> {
						Music v = (Music) o1;
						Music m = (Music) o2;
						char firstele = v.getSong_Title().charAt(0);
						char secondtele = m.getSong_Title().charAt(0);
						char firstele1 = v.getSong_Title().charAt(1);
						char secondtele1 = m.getSong_Title().charAt(1);

						if (firstele > secondtele) {
							return 1;
						} else if (firstele < secondtele) {
							return -1;
						} else if (firstele1 > secondtele1) {
							return 1;
						} else if (firstele1 < secondtele1) {
							return -1;
						}

						return 0;
					};

//					System.out.println("Play all the songs sequentially order by song title.");
					System.out.println("-------------");
					System.out.println("Song Title");
					System.out.println("----------");
					List<Music> result = new ArrayList<Music>();
					result = arraylist.stream().sorted().collect(Collectors.toList());
					result.sort(c1);
					for (Music music : result) {
						System.out.println(music.getSong_Title());
					}
					Thread.sleep(1000);
					System.out.println("-------------");
					
					break;
				case "B":

					System.out.println("==========================");
					Random rand = new Random();
					int randnumber = rand.nextInt(arraylist.size());
					System.out.println(arraylist.get(randnumber).getSong_Title());
					System.out.println(" ");
					System.out.println("==========================");
					break;
				case "C":
					// Song Title & Play the Particular Song.
					System.out.println("Enter the Song:");
					ArrayList<Music> array1 = new ArrayList<Music>();
					String str = sc.next();
					str = str.substring(0, 3).toLowerCase();
					int c = 0;
					for (Music music : arraylist) {
						if ((music.getSong_Title().toLowerCase()).substring(0, 3).equalsIgnoreCase(str)) {
							array1.add(music);
							System.out.println("Play List");
							System.out.println("-------------");
							System.out.println("Song Name:" + music.getSong_Title());
							System.out.println("Song Location" + music.getSong_Location());
							System.out.println("Song Description:" + music.getDescription());
							System.out.println("-------------");
							c = 1;
						}
					}
					if (c == 0) {
						System.out.println("No Songs Founded......");
					}

					break;
				default:
					System.out.println("Invalid input please enter the valid Input......");
				}

				break;
			case 2:
				System.out.println("Enter the Song:");
				ArrayList<Music> array2 = new ArrayList<Music>();
				String str1 = sc.next();
				str1 = str1.substring(0, 3).toLowerCase();
				int d = 0;
				for (Music music : arraylist) {
					if ((music.getSong_Title().toLowerCase()).substring(0, 3).equalsIgnoreCase(str1)) {
						array2.add(music);
						System.out.println("-------------");
						System.out.println("Search List:");
						System.out.println("-------------");
						System.out.println("Song Title:/t" + music.getSong_Title());
						System.out.println("Artist:/t" + music.getArtist_Name());
						System.out.println("Album:/t" + music.getAlbum_Name());
						System.out.println("-------------");
						d = 1;
					}
				}
				if (d == 0) {
					System.out.println("No Songs Founded......");
				}

				break;
			case 3:

//				System.out.println("Display the all Songs Order by the Title");
				System.out.println("------------------------------------------------------");
				System.out.println("Song_Title \t  Artist \t\t Album");
				System.out.println("---------------- --------------------- -------------");
				for (Music music : arraylist) {

					System.out.println(music.getSong_Title()+" \t"+music.getArtist_Name()+" \t"+music.getAlbum_Name());
				}
				System.out.println("------------------------------------------------------");
				break;
			case 4:
				System.out.println("Press A to Add Song to Songs Repository");
				System.out.println("Press B to Edit an existing Song info");
				System.out.println("Press C to Delete an existing Song");
				String option2 = sc.next();
				switch (option2) {
				case "A":
					int Song_ID;
					String songTitle, artistName, albumName, songLocation, description;

					Song_ID = arraylist.size() + 1;
					System.out.println("Enter the Song Title:");
					songTitle = sc.nextLine();
					System.out.println("Enter the Artist Name:");
					artistName = sc.nextLine();
					System.out.println("Enter the Album Name:");
					albumName = sc.nextLine();
					System.out.println("Enter the Song Location:");
					songLocation = sc.nextLine();
					System.out.println("Enter the Song Description:");
					description = sc.nextLine();

					arraylist.add(new Music(Song_ID, songTitle, artistName, albumName, songLocation, description));
					System.out.println("New Song is Added as " + arraylist.get(arraylist.size() - 1));

					System.out.println("collect all the info & insert that data into a song to repository");
					break;
				case "B":
					int g, h;
					System.out.println("Enter the Editing Song ID:");
					g = sc.nextInt();

					System.out.println("1. Edit a Song Name:");
					System.out.println("2. Edit a Artist Name:");
					System.out.println("3. Edit a Album Name:");
					System.out.println("4. Edit a Song Location:");
					System.out.println("5. Edit a Description:");

					h = sc.nextInt();

					switch (h) {
					case 1: {
						String name;

						System.out.println("Enter the Song Title");
						sc.nextLine();
						name = sc.nextLine();
						arraylist.get(g - 1).setSong_Title(name);
						break;
					}

					case 2: {
						String name;

						System.out.println("Enter the Artist Name");
						sc.nextLine();
						name = sc.nextLine();
						arraylist.get(g - 1).setArtist_Name(name);
						break;
					}

					case 3: {
						String name;

						System.out.println("Enter the Album Name");
						sc.nextLine();
						name = sc.nextLine();
						arraylist.get(g - 1).setAlbum_Name(name);
						break;
					}

					case 4: {
						String name;

						System.out.println("Enter the Song Location");
						sc.nextLine();
						name = sc.nextLine();
						arraylist.get(g - 1).setSong_Location(name);
						break;
					}
					case 5: {
						String name;

						System.out.println("Enter the Description");
						sc.nextLine();
						name = sc.nextLine();
						arraylist.get(g - 1).setDescription(name);
						break;
					}
					default:
						System.out.println("Invalid Input");

					}
					break;
				case "C":
					int f;

					System.out.println("collect the song info & delete that song from DB");
					f = sc.nextInt();
					int flag = 0;
					for (int i = 0; i < arraylist.size(); i++) {
						if (arraylist.get(i).getSong_ID() == f) {
							arraylist.remove(i);
							flag = 1;
						}

					}
					if (flag == 0) {
						System.out.println("There is no Song ID" + f);
					} else
						System.out.println("The Song ID" + f + "is Successfully removed.");

					for (Music music : arraylist) {
						System.out.println(music);
					}
					break;
				default:
					System.out.println("Invalid Option Please enter the valid Option.");
				}

			}

		} while (true);
	}

}
