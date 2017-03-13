package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentFileDAO implements PresidentDAO {
	private static final String filename = "WEB-INF/presidents.txt";
	private ServletContext servletContext;
	private List<President> presidents;

	public PresidentFileDAO(ServletContext context) {
		servletContext = context;
		presidents = new ArrayList<>();
		loadFile();
	}

	private void loadFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		System.out.println("test");
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				String[] words = line.split("/ ");
				String term = words[0];
				String firstName = words[1];
				String middleName = words[2];
				String lastName = words[3];
				String[] years = words[4].split("-");
				String startYear = years[0];
				String endYear = years[1];
				String party = words[5];
				String fact = words[6];
				String picture = words[7];
				presidents.add(new President(term, firstName, middleName, lastName, startYear, endYear, party, fact, picture));
System.out.print("help");
			}
		}

		catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public President getName(String name) {
		President pres = null;
		for (President p : presidents) {
			if (p.getName().equals(name)) {
				pres = p;
				break;
			}
		}
		return pres;
	}

	@Override
	public President getNames(String fName, String mName, String lName) {
		President pres = null;
		for (President p : presidents) {
			if (p.getLastName().equals(lName)) {
				if (p.getMiddleName().equals(mName)) {
					if (p.getFirstName().equals(fName)) {
						pres = p;
						break;
					}
				}
			}

		}
		return pres;
	}

	@Override
	public President getTerm(String term) {
		System.out.println(term);
		President pres = null;
		for (President p : presidents) {
			if (p.getTermNumber().equals(term)) {
				pres = p;
				break;
			}
		}
		return pres;
	}

	@Override
	public List<President> getParty(String party) {
		List<President> presList = new ArrayList<>();
		for (President pres : presidents) {
			if (pres.getParty().equals(party)) {
				presList.add(pres);
			}
		}
		return presList;
	}

	@Override
	public List<President> getAllPresidents() {
		List<President> tempPres = presidents;
		return tempPres;
	}
}
