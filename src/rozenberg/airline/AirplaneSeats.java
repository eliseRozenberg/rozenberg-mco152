package rozenberg.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	Set<String> reserved;
	HashMap<Integer, Character> seat2;
	char[][] seatsArray;
	HashMap<Character, Integer> seat;
	int rows;
	int columns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
		seatsArray = new char[rows][columns];
		seat = new HashMap<Character, Integer>();
		seat.put('A', 1);
		seat.put('B', 2);
		seat.put('C', 3);
		seat.put('D', 4);
		seat.put('E', 5);
		seat.put('F', 6);
		seat.put('G', 7);
		seat.put('H', 8);
		seat.put('I', 9);
		seat.put('J', 10);
		seat.put('K', 11);
		seat.put('L', 12);
		seat.put('M', 13);
		seat.put('N', 14);
		seat.put('O', 15);
		seat.put('P', 16);
		seat.put('Q', 17);
		seat.put('R', 18);
		seat.put('S', 19);
		seat.put('T', 20);
		seat.put('U', 21);
		seat.put('V', 22);
		seat.put('W', 23);
		seat.put('X', 24);
		seat.put('Y', 25);
		seat.put('Z', 26);
		seat2.put(1, 'A');
		seat2.put(2, 'B');
		seat2.put(3, 'C');
		seat2.put(4, 'D');
		seat2.put(5, 'E');
		seat2.put(6, 'F');
		seat2.put(7, 'G');
		seat2.put(8, 'H');
		seat2.put(9, 'I');
		seat2.put(10, 'J');
		seat2.put(11, 'K');
		seat2.put(12, 'L');
		seat2.put(13, 'M');
		seat2.put(14, 'N');
		seat2.put(15, 'O');
		seat2.put(16, 'P');
		seat2.put(17, 'Q');
		seat2.put(18, 'R');
		seat2.put(19, 'S');
		seat2.put(20, 'T');
		seat2.put(21, 'U');
		seat2.put(22, 'V');
		seat2.put(23, 'W');
		seat2.put(24, 'X');
		seat2.put(25, 'Y');
		seat2.put(26, 'Z');
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
		int row;
		String rowString;
		char col = seatName.charAt(0);
		if (reserved.contains(seatName)) {
			throw new AlreadyReservedException();
		}
		if (seat.get(col) > columns) {
			throw new SeatOutOfBoundsException();
		}
		rowString = seatName.substring(1);
		row = Integer.parseInt(rowString);
		if (row > this.rows) {
			throw new SeatOutOfBoundsException();
		}
		reserved.add(seatName);
		seatsArray[row][col] = '#';
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
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < columns; i++) {
			builder.append(seat2.get(i));
		}
		builder.append("\n");
		for (int i = 1; i < rows; i++) {
			builder.append(i);
			for (int j = 0; j < columns; j++) {
				if (seatsArray[i][j] == '#') {
					builder.append("#");
				} else {
					builder.append("o");
				}
			}
			builder.append("\n");
		}

		return builder.toString().trim();
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
		char col;
		int colNum;
		boolean found;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
			}
		}
		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return (reserved.size() == (rows * columns));
	}

}
