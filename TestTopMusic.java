package topMusic;

import java.util.*;

import utiles.*;

/**
 * 
 * @author Santiago Valentin Serrano
 *
 */

public class TestTopMusic {
	public static void main(String[] args) {
		String[] options = { "1-Add Song", "2-Remove Song", "3-Delete Full List", "4-Promote a song", "5-Demote a song",
				"6-Show List", "7-Most Listened Song", "8-Music Packages", "9-Exit" };
		Menu menu = new Menu("\nTOP MUSIC", options);

		ArrayList<Song> list = new ArrayList<Song>();
		TopMusic music = new TopMusic(list);

		int option;
		do {
			option = menu.manageMenu();
			switch (option) {
			case 1:
				addSong(music, list);
				break;
			case 2:
				removeSong(music, list);
				break;
			case 3:
				deleteFullList(music, list);
				break;
			case 4:
				promote(music, list);
				break;
			case 5:
				demote(music, list);
				break;
			case 6:
				showList(music, list);
				break;
			case 7:
				mostListened(music, list);
				break;
			case 8:
				songPackages(music, list);
				break;
			case 9:
				System.out.println("\nBYE");
				break;
			default:
				System.err.println("\nEnter a valid option: ");
				break;
			}
		} while (option != 9);
	}

	/**
	 * Promotes a song by 1 position
	 * 
	 * @param music
	 * @param list
	 */
	private static void promote(TopMusic music, ArrayList<Song> list) {
		try {
			System.out.println(music.showList());
			int position = Teclado.leerEntero("\nIntroduce position to promote: ");
			music.promote(position);
		} catch (NullPointerMusicException e) {
			System.err.println(e.getMessage());
		} catch (OutOfRangeException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Demotes a song by 1 position
	 * 
	 * @param music
	 * @param list
	 */
	private static void demote(TopMusic music, ArrayList<Song> list) {
		try {
			System.out.println(music.showList());
			int position = Teclado.leerEntero("\nIntroduce position to demote: ");
			music.demote(position);
		} catch (NullPointerMusicException e) {
			System.err.println(e.getMessage());
		} catch (OutOfRangeException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Shows the first song in the list
	 * 
	 * @param music
	 * @param list
	 */
	private static void mostListened(TopMusic music, ArrayList<Song> list) {
		try {
			System.out.println("\nMost Listened Song: " + music.mostListened());
		} catch (OutOfRangeException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Prints the entire list
	 * 
	 * @param music
	 * @param list
	 */
	private static void showList(TopMusic music, ArrayList<Song> list) {
		try {
			System.out.println(music.showList());
		} catch (NullPointerMusicException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Deletes the full list
	 * 
	 * @param music
	 * @param list
	 */
	private static void deleteFullList(TopMusic music, ArrayList<Song> list) {
		char option = Teclado.leerCaracter("You are about to delete the full list, are you sure?(y/n): ");
		if (option == 'n' || option == 'N') {
			System.out.println("Ok nevermind");
		} else if (option == 'y' || option == 'Y') {
			try {
				music.deleteFullList();
			} catch (NullPointerMusicException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.err.println("That's not a valid option");
		}
	}

	/**
	 * Deletes a song from the list
	 * 
	 * @param music
	 * @param list
	 */
	private static void removeSong(TopMusic music, ArrayList<Song> list) {
		char option = Teclado.leerCaracter("Do you want to delete a song?(y/n): ");
		if (option == 'n' || option == 'N') {
			System.out.println("Ok nevermind");
		} else if (option == 'y' || option == 'Y') {
			try {
				int position = Teclado.leerEntero("INtroduce position to delete: ");
				music.removeSong(position);
			} catch (OutOfRangeException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.err.println("That's not a valid option");
		}
	}

	/**
	 * Adds a song to the list manually
	 * 
	 * @param music
	 * @param list
	 */
	private static void addSong(TopMusic music, ArrayList<Song> list) {
		try {
			int position = Teclado.leerEntero("Introduce position to add: ");
			String title = Teclado.leerCadena("Introduce song title: ");
			String artist = Teclado.leerCadena("Introduce song artist: ");
			int year = Teclado.leerEntero("Introduce release year: ");
			music.addSong(position, new Song(title, artist, year));
		} catch (OutOfRangeException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Adds 3 songs per music genre
	 * 
	 * @param list
	 */
	private static void songPackages(TopMusic music, ArrayList<Song> list) {
		int option;
		String[] options = { "1-Heavy Metal", "2-Punk Rock", "3-Classic Rock", "4-New Wave", "5-Pop", "6-Blues",
				"7-Electronic", "8-EXIT" };
		Menu menu2 = new Menu("\nDEFAULT PACKAGES", options);
		do {
			option = menu2.manageMenu();
			switch (option) {
			case 1:
				try {
					music.addSong(1, new Song("2 Minutes to Midnight", "Iron Maiden", 1984));
					music.addSong(1, new Song("Paranoid", "Black Sabbath", 1970));
					music.addSong(1, new Song("Ich Will", "Rammstein", 2001));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 2:
				try {
					music.addSong(1, new Song("When I come Around", "Green Day", 1995));
					music.addSong(1, new Song("God Save the Queen", "Sex Pistols", 1977));
					music.addSong(1, new Song("Blitzkrieg Bop", "The Ramones", 1976));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 3:
				try {
					music.addSong(1, new Song("Another One Bites the Dust", "Queen", 1980));
					music.addSong(1, new Song("Saturday Night's Alright for Fighting", "Elton John", 1973));
					music.addSong(1, new Song("Hollywood Nights", "Bob Seger", 1978));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 4:
				try {
					music.addSong(1, new Song("How to Be a Millionaire", "A-HA", 1985));
					music.addSong(1, new Song("Everything Counts", "Depeche Mode", 1983));
					music.addSong(1, new Song("Don't Go", "Yazoo", 1982));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 5:
				try {
					music.addSong(1, new Song("Payphone", "Maroon 5", 2012));
					music.addSong(1, new Song("Bad Romance", "Lady Ga Ga", 2009));
					music.addSong(1, new Song("Come", "Jain", 2015));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 6:
				try {
					music.addSong(1, new Song("Sweet Home Chicago", "Blues Brothers", 1980));
					music.addSong(1, new Song("BellBottoms", "The Jon Spencer Blues Explotion", 1995));
					music.addSong(1, new Song("I Got a Woman", "Ray Charles", 1954));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 7:
				try {
					music.addSong(1, new Song("Technologic", "Daft Punk", 2005));
					music.addSong(1, new Song("Love Don't let me Go", "David Guetta", 2002));
					music.addSong(1, new Song("Bullet Rain", "Carl Noren", 2017));
				} catch (OutOfRangeException e) {
					System.err.println(e.getMessage());
				}

				System.out.println("\nPackage Added");
				break;

			case 8:
				System.out.println("\nReturning to main menu...");
				break;

			default:
				System.err.println("\nIntroduce valid option");
				break;
			}
		} while (option != 8);
	}
}
