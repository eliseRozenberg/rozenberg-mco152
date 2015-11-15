package rozenberg.ups;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/**
	 * Add a Package to a Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		Package pkg = new Package("1234");
		Location location = new Location(1234, 5678);
		UPSDatabase database = new UPSDatabase();
		database.addPackageToLocation(location, pkg);
		Assert.assertEquals(database.getLocation(pkg), location);
		int amount = database.getPackages(location).size();
		Assert.assertEquals(amount, 1);
	}

	@Test
	/**
	 * Add a Package to a Location then update the Package Location to a
	 * different Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with
	 * the first Location.
	 */
	public void testUpdatePackageLocation() {
		Package pkg = new Package("1234");
		Location location = new Location(1234, 5678);
		UPSDatabase database = new UPSDatabase();
		database.addPackageToLocation(location, pkg);
		Location location2 = new Location(5678, 1234);
		database.updatePackageLocation(pkg, location2);
		Assert.assertEquals(database.getLocation(pkg), location2);
		Assert.assertNotEquals(database.getLocation(pkg), location);
		int amount = database.getPackages(location2).size();
		Assert.assertEquals(amount, 1);
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with a
	 * Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase database = new UPSDatabase();
		Assert.assertEquals(database.getPackages(new Location(1234, 5678)), null);
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase database = new UPSDatabase();
		Assert.assertEquals(database.getLocation(new Package("1234")), null);
	}

}
