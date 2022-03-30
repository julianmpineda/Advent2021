public static void day10() {

	List<String> subsystem = new ArrayList<String>();

	try {
		File myObj = new File("10.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			subsystem.add(myReader.nextLine());
			}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	String open = "([{<";
	String close = ")]}>";
	String pairs = "()[]{}<>";
	int[] scores1 = new int[] { 3, 57, 1197, 25137 };
	int[] corrupted = new int[4]; // { ')', ']', '}', '>' }
	int sum = 0;
	List<String> incomplete = new ArrayList<String>();

    for (int i = subsystem.size() - 1; i >= 0; i--) {
			
		String fakeStack = "";
		String line = subsystem.get(i);
        boolean found = false;

		for (int j = 0; j < line.length() && !found; j++) {
			char bracket = line.charAt(j);
				
			//prompt assumes it always opens with a character from "open"
			if (open.contains("" + bracket)) {
				fakeStack += bracket;
			} else if (close.contains("" + bracket)) {
				String chunk = "" + fakeStack.charAt(fakeStack.length() - 1) + bracket;
				
    			if (!pairs.contains(chunk)) {
					switch (bracket) {
					case ')':
						corrupted[0]++;
						break;
					case ']':
						corrupted[1]++;
						break;
					case '}':
						corrupted[2]++;
						break;
					case '>':
						corrupted[3]++;
						break;
					}
					subsystem.remove(i);
					found = true;
				} else {
					fakeStack = fakeStack.substring(0, fakeStack.length() - 1);
				}
			}
		}
		if (!found) {
			incomplete.add(fakeStack);
		}
	}

	// Part 1
	for (int i = 0; i < 4; i++) {
		sum += corrupted[i] * scores1[i];
	}

	System.out.println("Part 1: " + sum);

	// Part 2

	List<Long> scores = new ArrayList<Long>();

	for (int i = 0; i < incomplete.size(); i++) {
		Long longSum = 0L;
			
		for (int j = incomplete.get(i).length() - 1; j >= 0; j--) {
			longSum *= 5;
			char next = incomplete.get(i).charAt(j);
			switch (next) {
			case '(':
				longSum += 1;
				break;
			case '[':
				longSum += 2;
				break;
			case '{':
				longSum += 3;
				break;
			case '<':
				longSum += 4;
				break;
			}
		}
		scores.add(longSum);
	}

	Collections.sort(scores);
	System.out.println("Part 2: " + scores.get(scores.size() / 2));
}
