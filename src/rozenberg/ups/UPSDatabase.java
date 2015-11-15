package rozenberg.ups;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;


//give a package tracking number or package, what the location is
//what packages at what location

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	HashMap<Package, Location> map;
	HashMap<Location, Set<Package>> map2;

	public UPSDatabase() {
		map = new HashMap<Package, Location>();
		map2 = new HashMap<Location, Set<Package>>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		map.put(pkg, location);
		Set<Package> set = map2.get(location);
		if (set ==null){
			set = new HashSet<Package>();
		}
		set.add(pkg);
		map2.put(location, set);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		Location oldLocation = map.get(pkg);
		Set<Package> set = map2.get(oldLocation);
		set.remove(pkg);
		map2.put(location, set);
		set = map2.get(location);
		set.add(pkg);
		map2.put(location, set);
		map.put(pkg, location);
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		return map2.get(location);
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return map.get(pkg);
	}

}
