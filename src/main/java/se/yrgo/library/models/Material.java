package se.yrgo.library.models;

/**
 * <p>Abstract Material class.</p>
 *
 * @author Svendsén
 * @version $Id: $Id
 */
public abstract class Material {

	private int id;
	private String title;
	private String branch;
	private Customer borrower;
	
	/**
	 * <p>Constructor for Material.</p>
	 *
	 * @param id a int
	 * @param title a {@link java.lang.String} object
	 * @param branch a {@link java.lang.String} object
	 */
	public Material(int id, String title, String branch) {
		this.id = id;
		this.title = title;
		this.branch = branch;
	}

	/**
	 * <p>Getter for the field <code>title</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * <p>getID.</p>
	 *
	 * @return a int
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * <p>relocate.</p>
	 *
	 * @param newBranch a {@link java.lang.String} object
	 */
	public void relocate (String newBranch) {
		this.branch = newBranch;
	}
	
	/**
	 * <p>lend.</p>
	 *
	 * @param customer a {@link se.yrgo.library.models.Customer} object
	 * @return a boolean
	 */
	public boolean lend(Customer customer) {
		if (borrower == null) {
			borrower = customer;
			return true;
		}
		else {
			return false;
		}
	}
	
	//must be overridden
	/**
	 * <p>getLoanPeriod.</p>
	 *
	 * @return a int
	 */
	public abstract int getLoanPeriod();
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return title;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() == obj.getClass())
		{
			Material otherClass = (Material)obj;
			if (id == otherClass.id) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
}
