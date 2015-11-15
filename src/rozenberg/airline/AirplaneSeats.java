package rozenberg.airline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	String[][] seats;
	HashSet<String> reserved;
	StringBuilder builder = new StringBuilder();

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		seats = new String[rows][columns];

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				builder.append((char) (j + 65));
				builder.append((i + 1));
				seats[i][j] = builder.toString().trim();
				builder.setLength(0);
			}
		}
		reserved = new HashSet<String>();
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		boolean found = false;
		if (reserved.contains(seatName)) {
			throw new AlreadyReservedException();
		}
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].equals(seatName)) {
					reserved.add(seatName);
					found = true;
					break;
				}
				if (found) {
					break;
				}
			}
		}
		if (!found) {
			throw new SeatOutOfBoundsException();
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return reserved.contains(seatName);
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of. ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5
	 *         #ooo\n Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		builder.setLength(0);
		builder.append("  ");
		for (int j = 1; j <= seats[0].length; j++) {
			builder.append((char) (j + 64));
		}
		for (int i = 0; i < seats.length; i++) {
			builder.append("\n");
			builder.append((i + 1));
			builder.append(" ");
			for (int j = 0; j < seats[i].length; j++) {
				if (reserved.contains(seats[i][j])) {
					builder.append('#');
				} else {
					builder.append('o');
				}
			}
		}
		builder.append("\n");
		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return (reserved.size() == (seats.length * seats[0].length));
	}

	public String[][] getseats() {
		return seats;
	}

}
