package data;

public class President {

	private String termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private String startYear;
	private String endYear;
	private String party;
	private String fact;
	private String picture;

	public President(String termNumber, String firstName, String middleName, String lastName, String startYear,
			String endYear, String party, String fact, String picture) {

		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.party = party;
		this.fact = fact;
		this.name = (firstName + " " + middleName + " " + lastName);
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(String termNumber) {
		this.termNumber = termNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	

	@Override
	public String toString() {
		return "President [termNumber=" + termNumber + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", name=" + name + ", startYear=" + startYear + ", endYear=" + endYear
				+ ", party=" + party + ", fact=" + fact + ", picture=" + picture + "]";
	}

	public President(String firstName, String lastName, String party) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.party = party;
	}
}
