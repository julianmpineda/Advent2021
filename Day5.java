	public static int day5() {

		int[][] map = new int[1000][1000];
		int[] range = new int[4];
		int answer = 0;

		try {
			File myObj = new File("advent5.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String vent = myReader.nextLine();
				range = getRange(vent);

				int count = 0;
				while (count < 4) {
					System.out.print(range[count] + " ");
					count++;
				}
				System.out.println();

				// y = 0: fixed x
				if (range[1] == 0) {
					for (int i = range[2]; i <= range[3]; i++) {
						map[range[0]][i]++;
					}
					// x = 0: fixed y
				} else if (range[0] == 0) {
					for (int i = range[2]; i <= range[3]; i++) {
						map[i][range[1]]++;
					}
				} else {

					int x = range[0], y = range[1], run = range[0] - range[2], points = 0;
					while (points <= run) {
						if (range[1] > range[3]) {
							map[x][y]++;
							x--;
							y--;
							points++;
						} else {
							map[x][y]++;
							x--;
							y++;
							points++;
						}
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		printMap(map);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > 1) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static int[] getRange(String coor) {

		int[] ret = new int[4];
		String[] splitstr = coor.split(",| -> ");
		int[] split = new int[4];

		for (int i = 0; i < 4; i++) {
			split[i] = Integer.parseInt(splitstr[i]);
		}

		if (split[0] == split[2]) {
			ret[0] = split[0];
			ret[1] = 0;
			ret[2] = Math.min(split[1], split[3]);
			ret[3] = Math.max(split[1], split[3]);
		} else if (split[1] == split[3]) {
			ret[0] = 0;
			ret[1] = split[1];
			ret[2] = Math.min(split[0], split[2]);
			ret[3] = Math.max(split[0], split[2]);
		} else {
			int xchange = split[0] - split[2];
			int ychange = split[1] - split[3];

			if (Math.abs(ychange) == Math.abs(xchange)) {

				int index = 0, index2 = 2;

				if (split[2] < split[0]) {
					index = 2;
					index2 = 0;
				}

				ret[0] = split[index2];
				ret[1] = split[index2 + 1];
				ret[2] = split[index];
				ret[3] = split[index + 1];
			} else {
				return new int[] { 0, 0, 0, 0 };
			}
		}

		return ret;

	}

	public static void printMap(int[][] map) {

		File myObj2 = new File("map.txt");
		myObj2.delete();

		try {
			File myObj = new File("map.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter("map.txt");
			for (int i = 0; i < map.length; i++) {
				myWriter.write(i + ": ");
				for (int j = 0; j < map.length; j++) {
					myWriter.write(map[i][j] + " ");
				}
				myWriter.write("\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
