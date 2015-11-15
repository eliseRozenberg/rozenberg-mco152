package rozenberg.airline;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	HashSet<String> reserved;
	StringBuilder builder;
	int rows;
	int cols;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.cols = columns;
		builder = new StringBuilder();
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
		if (reserved.contains(seatName)) {
			throw new AlreadyReservedException();
		}
		int letter = (seatName.charAt(0) - 64);
		int number = Integer.parseInt(seatName.substring(1, seatName.length()));
		if ((letter > cols) || (number > rows)) {
			throw new SeatOutOfBoundsException();
		}
		reserved.add(seatName);
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
		StringBuilder seat = new StringBuilder();
		builder.setLength(0);
		builder.append("  ");
		for (int j = 1; j <= cols; j++) {
			builder.append((char) (j + 64));
		}
		for (int i = 0; i < rows; i++) {
			builder.append("\n");
			builder.append((i + 1));
			builder.append(" ");
			for (int j = 0; j < cols; j++) {
				seat.setLength(0);
				seat.append((char) (j + 65));
				seat.append((i + 1));
				if (reserved.contains(seat.toString())) {
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
		ArrayList<String> reserveGroup = new ArrayList<String>();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (j + (numberOfSeatsTogether - 1) > cols) {
					break;
				}
				for (int h = 0; h < numberOfSeatsTogether; h++) {
					builder.setLength(0);
					builder.append((char) ((j + h) + 64));
					builder.append(i);
					if (reserved.contains(builder.toString().trim())) {
						reserveGroup.clear();
						break;
					} else {
						reserveGroup.add(builder.toString());
					}
					if (reserveGroup.size() == numberOfSeatsTogether) {
						for (String element : reserveGroup) {
							reserved.add(element);
						}
						return reserveGroup;
					}
				}
			}
		}
		throw new NotEnoughSeatsException();
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return (reserved.size() == (rows * cols));
	}
}
