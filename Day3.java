public static int day3() {

		int[] ones = new int[12];
		int[] zeroes = new int[12];
		int[] gamma = new int[12];
		int[] epsilon = new int[12];

		try {
			File myObj = new File("advent3.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String log = myReader.nextLine();
				for (int i = 0; i < 12; i++) {
					int bin = Character.getNumericValue(log.charAt(i));

					if (bin == 0) {
						zeroes[i] += 1;
					} else {
						ones[i] += 1;
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		for (int j = 0; j < 12; j++) {
			if (ones[j] > zeroes[j]) {
				gamma[j] = 0;
				epsilon[j] = 1;
			} else {
				gamma[j] = 1;
				epsilon[j] = 0;
			}
		}

		return convertBinary(gamma) * convertBinary(epsilon);
	}

	public static int convertBinary(int[] bin) {

		int ans = 0;

		for (int i = bin.length - 1; i >= 0; i--) {
			if (bin[i] == 1) {
				ans += Math.pow(2, ((bin.length - 1) - i));
			}
		}
		return ans;
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
