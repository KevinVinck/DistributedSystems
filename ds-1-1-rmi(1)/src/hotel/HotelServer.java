package hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelServer {


    private static Logger logger = Logger.getLogger(HotelServer.class.getName());

    public static void main(String[] args) throws NumberFormatException, Exception {

        // set security manager if non existent
        if(System.getSecurityManager() != null)
            System.setSecurityManager(null);

        // create BookingManager
        IBookingManager bookingManager = new BookingManager();

        // locate registry
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry();
        } catch(RemoteException e) {
            logger.log(Level.SEVERE, "Could not locate RMI registry.");
            System.exit(-1);
        }

        // register booking manager
        IBookingManager stub;
        try {
            stub = (IBookingManager) UnicastRemoteObject.exportObject(bookingManager, 0);
            registry.rebind("Hilton", stub);
            logger.log(Level.INFO, "<{0}> hotel {0} is registered.", "Hilton");
        } catch(RemoteException e) {
            logger.log(Level.SEVERE, "<{0}> Could not get stub bound of hotel {0}.", "Hilton");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
