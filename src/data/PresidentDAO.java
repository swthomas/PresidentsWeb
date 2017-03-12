package data;

import java.util.List;

public interface PresidentDAO {

	President getName(String  name) ;
	President getNames(String fName, String mName, String lName);
	President getTerm(String term);
	List<President> getParty(String party);
	List<President> getAllPresidents();

}
