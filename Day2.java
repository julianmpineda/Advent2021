	public static int day2() {
		int depth = 0, position = 0, aim = 0;
    
		try {
			File myObj = new File("advent2.txt");
			Scanner myReader = new Scanner(myObj);
      
			while (myReader.hasNextLine()) {
				String direction = myReader.nextLine();
				int distance = Character.getNumericValue(direction.charAt(direction.length() - 1));
				if (direction.contains("forward")) {
					position += distance;
					depth += distance * aim;
				} else if (direction.contains("up")) {
					aim -= distance;
				} else if (direction.contains("down")) {
					aim += distance;
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return position * depth;
	}
