private static List<String> end = new ArrayList<String>();
private static Map<String, List<String>> paths = new HashMap<String, List<String>>();

public static int[] day12() {

	ArrayList<String> tokens = new ArrayList<String>();
	String[][] g = new String[21][2];
	int line = 0, one = 0, two = 0;

	try {
		File myObj = new File("advent12.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String edge = myReader.nextLine();
			g[line] = edge.split("-");
			if (!tokens.contains(g[line][0])) {
				tokens.add(g[line][0]);
			}
			if (!tokens.contains(g[line][1])) {
				tokens.add(g[line][1]);
			}
			line++;
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	for (int i = 0; i < tokens.size(); i++) {
		List<String> temp = new ArrayList<String>();

		for (int j = 0; j < g.length; j++) {
			if (tokens.get(i).equals(g[j][0])) {
				temp.add(g[j][1]);
			}
		}
		for (int j = 0; j < g.length; j++) {
			if (tokens.get(i).equals(g[j][1])) {
				temp.add(g[j][0]);
			}
		}
		paths.put(tokens.get(i), temp);
	}

	pathFinder1("start", "start,");
	one = end.size();

	end.clear();

	pathFinder2("start", "start", false);

	two = end.size();

	return new int[] { one, two };
}

public static void pathFinder1(String start, String previous) {

	for (String s : paths.get(start)) {
		if (s.equals("end")) {
			end.add(previous + "end");
		} else if (Character.isLowerCase(s.charAt(0)) && previous.contains(s)) {
			// throwaway, dont do anything if revisiting small cave
		} else {
			pathFinder1(s, previous + s + ",");
		}
	}
}

public static void pathFinder2(String start, String previous, boolean flag) {

	for (String s : paths.get(start)) {
		if (s.equals("end")) {
			end.add(previous + "end");
		} else if (s.equals("start")) {
			// never return to start
		} else if (Character.isLowerCase(s.charAt(0)) && previous.contains(s)) {
			// if flag == true and revisiting cave, do nothing. If flag not true, then first
			// time revisiting a cave.
			if (!flag) {
				pathFinder2(s, previous + s + ",", true);
			}
		} else {
			pathFinder2(s, previous + s + ",", flag);
		}
	}
}
