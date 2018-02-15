package topMusic;

import java.util.ArrayList;

/**
 * Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá:
 * 
 * <li>Annadir una cancion
 * <li>
 * 
 * @author Santiago Valentin Serrano
 *
 */
public class TopMusic {
	private ArrayList<Song> list = new ArrayList<Song>();

	public TopMusic(ArrayList<Song> list) {
	}

	/**
	 * <li>Adds a song to the list
	 * <li>User chooses ArrayList's position
	 * 
	 * @param list
	 * @throws OutOfRangeException
	 */
	public void addSong(int position, Song song) throws OutOfRangeException {
		try {
			list.add(position - 1, song);
		} catch (IndexOutOfBoundsException e) {
			throw new OutOfRangeException("The list is not that long");
		}
	}

	/**
	 * <li>Removes a song from the list
	 * <li>User chooses position
	 * 
	 * @param list
	 * @throws NullPointerMusicException
	 */
	public void removeSong(int position) throws OutOfRangeException {
		try {
			list.remove(position - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new OutOfRangeException("The list is empty, Introduce some songs first");
		}
	}

	/**
	 * <li>Deletes the whole list
	 * 
	 * @param list
	 * @throws NullPointerMusicException
	 */
	public void deleteFullList() throws NullPointerMusicException {
		try {
			list.removeAll(list);
		} catch (NullPointerException e) {
			throw new NullPointerMusicException("The list is empty already");
		}
	}

	/**
	 * <li>Promotes a song
	 * <li>User chooses song to promote
	 * <li>Cannot promote if song is number 1
	 * 
	 * @param list
	 * @throws OutOfRangeException,
	 *             NullPointerMusicException
	 */
	public void promote(int position) throws OutOfRangeException, NullPointerMusicException {
		try {
			list.add(position - 2, list.get(position - 1));
			list.remove(position);
		} catch (IndexOutOfBoundsException e) {
			throw new OutOfRangeException("That position is not valid");
		} catch (NullPointerException e) {
			throw new NullPointerMusicException("The list is empty");
		}
	}

	/**
	 * <li>Demotes a song from the list
	 * <li>User chooses song to demote
	 * 
	 * @param list
	 */
	/**
	 * <li>Promotes a song
	 * <li>User chooses song to promote
	 * <li>Cannot promote if song is number 1
	 * 
	 * @param list
	 * @throws OutOfRangeException,
	 *             NullPointerMusicException
	 */
	public void demote(int position) throws OutOfRangeException, NullPointerMusicException {
		try {
			list.add(position + 1, list.get(position - 1));
			list.remove(position - 1);
		} catch (NullPointerException e) {
			throw new NullPointerMusicException("The list is empty");
		} catch (IndexOutOfBoundsException e) {
			throw new OutOfRangeException("That position is not valid");
		}
	}

	/**
	 * <li>Prints the entire list
	 * 
	 * @param list
	 * @throws OutOfRangeException
	 */
	public String showList() throws NullPointerMusicException {
		StringBuilder list1 = new StringBuilder();
		try {
			for (Song song : list) {
				list1.append("\n" + song);
			}
			return list1.toString();
		} catch (NullPointerException e) {
			throw new NullPointerMusicException("The list cannot be shown because it is empty");
		}
	}

	/**
	 * <li>Prints position 1 song
	 * 
	 * @param list
	 * @throws NullPointerMusicException
	 */
	public Song mostListened() throws OutOfRangeException {
		try {
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new OutOfRangeException("The list is empty");
		}
	}

}