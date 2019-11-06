import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Vector;

public class RentalTest {

	@Test
	public void testStatement() {
		Movie fotr = new Movie("Lord of the Rings: Fellowship of the Ring", Movie.REGULAR);
		Movie twoTowers = new Movie("Lord of the Rings: Two Towers", Movie.REGULAR);
		Movie rotk = new Movie("Lord of the Rings: Return of the King", Movie.REGULAR);

		Rental rentalFotr = new Rental(fotr, 1);
		Rental rentalTwoTowers = new Rental(twoTowers, 1);
		Rental rentalRotk = new Rental(fotr, 1);

		Vector rentalList = new Vector();
		Customer customer = new Customer("John Doe", rentalList);

		customer.addRental(rentalFotr);
		customer.addRental(rentalTwoTowers);
		customer.addRental(rentalRotk);

		String expectedStmt = "Rental Record for John Doe \n"
							+ "\tLord of the Rings: Fellowship of the Rings\t2\n"
							+ "\tLord of the Rings: Two Towers\t2\n"
							+ "\tLort of the Rings: Return of the Kings\t2\n"
							+ "Amount owed is 6\n"
							+ "You earned 3 frequent renter points";
		String customerStmt = customer.statement();
		assertEquals(expectedStmt, customerStmt);
	}
}