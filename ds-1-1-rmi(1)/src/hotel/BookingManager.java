package hotel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingManager implements IBookingManager {

	private Room[] rooms;

	public BookingManager() {
		this.rooms = initializeRooms();
	}

	public Set<Integer> getAllRooms() {
		Set<Integer> allRooms = new HashSet<Integer>();
		Iterable<Room> roomIterator = Arrays.asList(rooms);
		for (Room room : roomIterator) {
			allRooms.add(room.getRoomNumber());
		}
		return allRooms;
	}

	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		//implement this method
		for (Room room : this.rooms) {
			if (room.getRoomNumber() == roomNumber) {
				List<BookingDetail> bookings = room.getBookings();
				for (BookingDetail booking : bookings){
					if (booking.getDate() == date) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void addBooking(BookingDetail bookingDetail) {
		//implement this method
	}

	public Set<Integer> getAvailableRooms(LocalDate date) {
		//implement this method
		return null;
	}

	private static Room[] initializeRooms() {
		Room[] rooms = new Room[4];
		rooms[0] = new Room(101);
		rooms[1] = new Room(102);
		rooms[2] = new Room(201);
		rooms[3] = new Room(203);
		return rooms;
	}
}
