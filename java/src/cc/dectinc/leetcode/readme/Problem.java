/**
 * 
 */
package cc.dectinc.leetcode.readme;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dectinc
 * @version Apr 22, 2015 12:23:23 AM
 * 
 */
/**
 * @author Dectinc
 * @version Apr 22, 2015 12:35:45 AM
 * 
 */
public class Problem implements Comparable<Problem> {
	private static Map<Integer, String> difficultyMap;
	static {
		difficultyMap = new HashMap<Integer, String>();
		difficultyMap.put(1, "Easy");
		difficultyMap.put(2, "Medium");
		difficultyMap.put(3, "Hard");
	}

	// patterns
	private final String pattern_id = "(?<=<td>)\\d+?(?=</td>)";
	private final String pattern_title = "(?<=/\">).+?(?=</a>)";
	private final String pattern_link = "(?<=<a href=\").+?(?=\")";
	private final String pattern_acceptance = "(?<=<td>)[\\d\\.]+?(?=%</td>)";
	private final String pattern_difficulty_level = "(?<=<td value=\")\\d+?(?=\")";

	private final static String URL_PREFIX = "https://leetcode.com";
	private final static String LINE_FORMAT = "|| %d || %s [ [link]("
			+ URL_PREFIX
			+ "%s) | [Solution](%s) ] || %f%% || %s || %s || %s ||";

	private int id;
	private String title;
	private String link;
	private float acceptance;
	private int difficultyLevel;
	private String srcJava;
	private String srcPython;

	public Problem(int id, String title, String link, float acceptance,
			int difficultyLevel) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.acceptance = acceptance;
		this.difficultyLevel = difficultyLevel;
		this.srcJava = null;
		this.srcPython = null;
	}

	/**
	 * @param group
	 */
	public Problem(String group) {
		try {
			Pattern pattern = Pattern.compile(pattern_id);
			Matcher m = pattern.matcher(group);
			this.id = Integer.parseInt(m.group());

			pattern = Pattern.compile(pattern_title);
			m = pattern.matcher(group);
			this.title = m.group();

			pattern = Pattern.compile(pattern_link);
			m = pattern.matcher(group);
			this.title = m.group();

			pattern = Pattern.compile(pattern_acceptance);
			m = pattern.matcher(group);
			this.acceptance = Float.parseFloat(m.group());

			pattern = Pattern.compile(pattern_difficulty_level);
			m = pattern.matcher(group);
			this.difficultyLevel = Integer.parseInt(m.group());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Problem o) {
		return this.id - o.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * || %d || %s [ [link](%s) | [Solution](%s) ] || %f || %s || %s ||
	 */
	@Override
	public String toString() {
		String sJava = "", sPython = "";
		if (srcJava != null && !srcJava.isEmpty()) {
			sJava = "[Java](" + srcJava + ")";
		}
		if (sPython != null && !srcPython.isEmpty()) {
			sPython = "[Python](" + srcPython + ")";
		}
		String source = null;
		if (!sJava.isEmpty() && !sPython.isEmpty()) {
			source = sJava + " | " + sPython;
		} else if (sJava.isEmpty()) {
			source = sPython;
		} else if (sPython.isEmpty()) {
			source = sJava;
		} else {
			source = "";
		}

		return String
				.format(LINE_FORMAT, id, title, link, "md/" + title + ".md",
						acceptance, difficultyMap.get(difficultyLevel), source);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the acceptance
	 */
	public float getAcceptance() {
		return acceptance;
	}

	/**
	 * @param acceptance
	 *            the acceptance to set
	 */
	public void setAcceptance(float acceptance) {
		this.acceptance = acceptance;
	}

	/**
	 * @return the difficultyLevel
	 */
	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel
	 *            the difficultyLevel to set
	 */
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the srcJava
	 */
	public String getSrcJava() {
		return srcJava;
	}

	/**
	 * @param srcJava
	 *            the srcJava to set
	 */
	public void setSrcJava(String srcJava) {
		this.srcJava = srcJava;
	}

	/**
	 * @return the srcPython
	 */
	public String getSrcPython() {
		return srcPython;
	}

	/**
	 * @param srcPython
	 *            the srcPython to set
	 */
	public void setSrcPython(String srcPython) {
		this.srcPython = srcPython;
	}

}
