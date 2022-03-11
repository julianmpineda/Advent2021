public static int day3() {

    List<String> diagnostic = new ArrayList<String>();
	int[] zeroes = new int[12];
    String gamma = "", epsilon = "";

	try {
		File myObj = new File("advent3.txt");
		Scanner myReader = new Scanner(myObj);

		while (myReader.hasNextLine()) {
			diagnostic.add(myReader.nextLine());
		}
		
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
    
    int middle = diagnostic.size()/2;
    
    //Part 1
    
    for (int i = 0; i < diagnostic.size(); i++) {
        for (int j = 0; j < 12; j++) {
            if (diagnostic.get(i).charAt(j) == '0') {
                zeroes[j] += 1;
            }
	    }
    }
    
    for (int k = 0; k < 12; k++) {
        if (zeroes[k] > middle) {
            gamma += "0";
            epsilon += "1";
		} else {
            gamma += "1";
            epsilon += "0";
		}
	}

		return Integer.parseInt(gamma, 2) * Intger.parseInt(epsilon, 2);
	}

	public static int day3pt2() {

		ArrayList<String> file = new ArrayList<String>();

		try {
			File myObj = new File("advent3.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String log = myReader.nextLine();
				file.add(log);
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		ArrayList<String> oxygen = new ArrayList<String>(file);
		ArrayList<String> co2 = new ArrayList<String>(file);

		int column = 0;
		while (oxygen.size() > 1 && column < 12) {

			int ones = 0, zeroes = 0, max = 0;

			for (int j = 0; j < oxygen.size(); j++) {
				if (Character.getNumericValue(oxygen.get(j).charAt(column)) == 1) {
					ones++;
				} else {
					zeroes++;
				}
			}
			if (ones >= zeroes) {
				max = 1;
			}
			for (int j = oxygen.size() - 1; j >= 0; j--) {
				if (Character.getNumericValue(oxygen.get(j).charAt(column)) != max) {
					oxygen.remove(j);
				}
			}
			column++;
		}
		column = 0;

		while (co2.size() > 1 && column < 12) {

			int ones = 0, zeroes = 0, min = 1;

			for (int j = 0; j < co2.size(); j++) {
				if (Character.getNumericValue(co2.get(j).charAt(column)) == 1) {
					ones++;
				} else {
					zeroes++;
				}
			}
			if (zeroes <= ones) {
				min = 0;
			}
			for (int j = co2.size() - 1; j >= 0; j--) {
				if (Character.getNumericValue(co2.get(j).charAt(column)) != min) {
					co2.remove(j);
				}
			}
			column++;
		}

		return Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2);
	}
