package hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public interface IBookingManager extends Remote {


    public boolean isRoomAvailable(Integer roomNumber, LocalDate date) throws RemoteException;

    public Set<Integer> getAvailableRooms(LocalDate date) throws RemoteException;

    public Set<Integer> getAllRooms() throws RemoteException;

}
