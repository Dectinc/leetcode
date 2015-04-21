/**
 * 
 */
package cc.dectinc.leetcode.readme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dectinc
 * @version Apr 22, 2015 12:22:58 AM
 * 
 */
public class ReadMeFormatter {
	private final String problemFilepath = "data/problem_list.html";
	private final String resultFilepath = "data/result.md";
	private final String header = "";

	private final String pattern_problem = "<tr>.*?</tr>";
	List<Problem> problems;

	private void reformat() {
		String content = loadProblemList(problemFilepath);
		problems = parseProblemList(content);
		Collections.sort(problems);
		saveResult();
	}

	public String loadProblemList(String path) {
		File problemListFile = new File(path);
		String content = "";
		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new FileReader(problemListFile));
			while ((line = br.readLine()) != null) {
				content += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

	private List<Problem> parseProblemList(String content) {
		List<Problem> problemList = new ArrayList<Problem>();
		Pattern pattern = Pattern.compile(pattern_problem);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			Problem problem = new Problem(matcher.group());
			problems.add(problem);
		}
		return problemList;
	}

	private boolean saveResult() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File(resultFilepath)));
			bw.write(header);
			bw.newLine();
			for (Problem problem : problems) {
				bw.write(problem.toString());
				bw.newLine();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ReadMeFormatter formatter = new ReadMeFormatter();
formatter.reformat();
	}

}
