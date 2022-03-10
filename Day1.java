	public static void day1() {

		List<Integer> sweepReport = new ArrayList<Integer>();
		int count = 0, line = 1;
		
		try {
			File myObj = new File("advent1.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String nextLine = myReader.nextLine();
				sweepReport.add(Integer.valueOf(nextLine));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		//Part 1
		while (line < sweepReport.size()) {
			if (sweepReport.get(line - 1) < sweepReport.get(line)) {
				count++;
			}
			line++;
		}
		System.out.println("Part 1: " + count);			
		
		//Part 2
		line = 3;
		count = 0;
		
		while (line < sweepReport.size()) {
			if (sweepReport.get(line - 3) < sweepReport.get(line)) {
				count++;
			}
			line++;
		}
		System.out.println("Part 2: " + count);	
	}
