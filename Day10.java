public static long[] day10() {

	int ans1 = 0;
	long ans2 = 0;
	ArrayList<Character> bracket = new ArrayList<Character>();
	ArrayList<String> incompletes = new ArrayList<String>();
	ArrayList<Long> scores2 = new ArrayList<Long>();
	int[] scores1 = new int[] { 3, 57, 1197, 25137 };
	int[] close = new int[4]; // { ')', ']', '}', '>' }

	// Part 1 code - also builds part 2 data

	try {
		File myObj = new File("advent10.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			boolean flag = true;
			String line = myReader.nextLine();
			for (int i = 0; i < line.length() && flag; i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					bracket.add(c);
				} else {
					int end = bracket.size() - 1;
					char p = bracket.get(end);
					if (c == ')') {
						if (p != '(') {
							close[0]++;
							flag = false;
						} else {
							bracket.remove(end);
						}
					} else if (c == ']') {
						if (p != '[') {
							close[1]++;
							flag = false;
						} else {
							bracket.remove(end);
						}
					} else if (c == '}') {
						if (p != '{') {
							close[2]++;
							flag = false;
						} else {
							bracket.remove(end);
						}
					} else if (c == '>') {
						if (p != '<') {
							close[3]++;
							flag = false;
						} else {
							bracket.remove(end);
						}
					}
				}
			}
			if (!bracket.isEmpty() && flag) {
				incompletes.add(line);
			}
			bracket.clear();
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	for (int i = 0; i < 4; i++) {
		ans1 += close[i] * scores1[i];
	}

    // Part 2 Code

	for (int i = 0; i < incompletes.size(); i++) {

		char[] line = incompletes.get(i).toCharArray();
		for (int j = 0; j < line.length; j++) {
			if (line[j] == '(' || line[j] == '[' || line[j] == '{' || line[j] == '<') {
				bracket.add(line[j]);
			} else {
				bracket.remove(bracket.size() - 1);
			}
		}
			long sum = 0;
		for (int k = bracket.size() - 1; k >= 0; k--) {
			if (bracket.get(k) == '(') {
				sum = sum * 5 + 1;
			} else if (bracket.get(k) == '[') {
				sum = sum * 5 + 2;
			} else if (bracket.get(k) == '{') {
				sum = sum * 5 + 3;
			} else if (bracket.get(k) == '<') {
				sum = sum * 5 + 4;
			}
		}
		bracket.clear();
		scores2.add(sum);

	}

	Collections.sort(scores2);
	ans2 = scores2.get((scores2.size() / 2));

    return new long[] { ans1, ans2 };
}
