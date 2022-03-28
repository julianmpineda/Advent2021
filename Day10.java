	public static void day10new() {

		List<String> subsystem = new ArrayList<String>();

		try {
			File myObj = new File("advent10.txt");
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
		String pair = "()[]{}<>";
		String corrupted = "";
		int sum = 0;
		List<String> completed = new ArrayList<String>();

		for (int i = subsystem.size() - 1; i >= 0; i--) {
			List<Character> fakeStack = new ArrayList<Character>();
			String line = subsystem.get(i);
			boolean found = false;

			for (int j = 0; j < line.length() && !found; j++) {

				if (open.contains("" + line.charAt(j))) {
					fakeStack.add(line.charAt(j));
				} else if (close.contains("" + line.charAt(j))) {
					String test = "" + fakeStack.get(fakeStack.size() - 1) + line.charAt(j);
					if (!pair.contains(test)) {
						corrupted += line.charAt(j);
						subsystem.remove(i);
						found = true;
					} else {
						fakeStack.remove(fakeStack.size() - 1);
					}
				}
			}

			if (!found) {
				String complete = "";
				for (int k = 0; k < fakeStack.size(); k++) {
					complete += fakeStack.get(k);
				}
				completed.add(complete);
			}
		}

		//Part 1
		
		for (int i = 0; i < corrupted.length(); i++) {
			char next = corrupted.charAt(i);
			switch (next) {
			case ')':
				sum += 3;
				break;
			case ']':
				sum += 57;
				break;
			case '}':
				sum += 1197;
				break;
			case '>':
				sum += 25137;
				break;
			}
		}

		System.out.println("Part 1: " + sum);
		
		//Part 2
		
		List<Long> scores = new ArrayList<Long>();
		
		for (int i = 0; i < completed.size(); i++) {
			Long longSum = 0L;
			for (int j = completed.get(i).length()-1; j >= 0; j--) {
				longSum *= 5;
				char next = completed.get(i).charAt(j);
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

		System.out.println("Part 2: " + scores.get(scores.size()/2));
	}
