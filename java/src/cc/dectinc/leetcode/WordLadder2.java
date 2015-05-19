/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.*;

/**
 * @author Dectinc
 * @version Apr 9, 2015 10:52:36 PM
 * 
 */
public class WordLadder2 {
	class WordNode {
		String word;
		List<String> path;
		int distance;
		WordNode from;

		public WordNode(String word, WordNode from, int distance) {
			this.word = word;
			this.from = from;
			this.distance = distance;
			this.path = new ArrayList<String>();
			if (from != null) {
				this.path.addAll(from.path);
			}
			this.path.add(word);
		}

		@Override
		public String toString() {
			return word;
		}
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return null;
		}
		List<List<String>> result = new ArrayList<List<String>>();

		LinkedList<WordNode> wordNodes = new LinkedList<WordNode>();
		wordNodes.add(new WordNode(start, null, 1));
		dict.remove(start);
		int wordLength = start.length();

		int foundLength = Integer.MAX_VALUE;
		while (!wordNodes.isEmpty()) {
			WordNode node = wordNodes.poll();
			String word = node.word;
			int distance = node.distance + 1;
			List<String> path = node.path;
			if (distance > foundLength) {
				continue;
			}
			for (int i = 0; i < wordLength; i++) {
				char[] chars = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String curWord = new String(chars);
					if (!dict.contains(curWord)) {
						continue;
					}
					if (curWord.equals(end)) {
						foundLength = distance;
						path.add(end);
						result.add(path);
						System.out.println(foundLength);
						System.out.println(path);
						continue;
					}
					if (!path.contains(curWord)) {
						wordNodes.add(new WordNode(curWord, node, distance));
					}
				}
			}
		}

		return result;
	}

	public List<String> getSequence(WordNode node) {
		List<String> sequence = new LinkedList<String>();
		while (node != null) {
			sequence.add(0, node.word);
			node = node.from;
		}
		return sequence;
	}

	public static void main(String args[]) {
		// String start = "hit";
		// String end = "cog";
		// String[] strings = new String[] { "hot", "cog", "dot", "dog", "hit",
		// "lot", "log" };
		String start = "cet";
		String end = "ism";
		String[] strings = new String[] { "kid", "tag", "pup", "ail", "tun",
				"woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val",
				"mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war",
				"hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan",
				"cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won",
				"dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has",
				"zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out",
				"btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig",
				"fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam",
				"flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too",
				"tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non",
				"wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb",
				"chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for",
				"joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus",
				"sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot",
				"tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk",
				"far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask",
				"wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug",
				"fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb",
				"fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod",
				"yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob",
				"gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era",
				"cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam",
				"pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx",
				"tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog",
				"nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set",
				"qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila",
				"lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash",
				"oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim",
				"fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den",
				"fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd",
				"you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see",
				"zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog",
				"eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham",
				"sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe",
				"bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem",
				"who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due",
				"sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia",
				"ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax",
				"mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito",
				"woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip",
				"hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep",
				"bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe",
				"dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd",
				"nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon",
				"dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit",
				"bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel",
				"dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub",
				"sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea",
				"bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get",
				"gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo",
				"nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con",
				"ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun",
				"fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp",
				"cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err",
				"him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego",
				"mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina",
				"big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top",
				"gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she",
				"sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut",
				"ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel",
				"awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho",
				"her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao",
				"coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup",
				"jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft",
				"alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe",
				"amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob" };
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(strings));
		System.out.println(new WordLadder2().findLadders(start, end, dict));
	}
}
