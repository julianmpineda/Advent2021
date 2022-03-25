private static int[][] lavaMap = new int[100][100];

public static int[] day9() {

	int sum = 0, base = 0, count = 0;
	ArrayList<int[]> zlist = new ArrayList<int[]>();
	ArrayList<Integer> size = new ArrayList<Integer>();

	try {
		File myObj = new File("advent9.txt");
		Scanner myReader = new Scanner(myObj);
		for (int i = 0; i < 100; i++) {
			String line = myReader.nextLine();
			for (int j = 0; j < 100; j++) {
				lavaMap[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

    for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			int flag = 0;
			if (lavaMap[i][j] < 9) {
				if (i == 0 || lavaMap[i][j] < lavaMap[i - 1][j]) {
					flag++;
				}
				if (i == 99 || lavaMap[i][j] < lavaMap[i + 1][j]) {
					flag++;
				}
				if (j == 99 || lavaMap[i][j] < lavaMap[i][j + 1]) {
					flag++;
				}
				if (j == 0 || lavaMap[i][j] < lavaMap[i][j - 1]) {
					flag++;
				}
				if (flag == 4) {
					sum += lavaMap[i][j] + 1;
					zlist.add(new int[] { i, j });
					j++;
				}
			}
		}
	}

	while (count < zlist.size()) {
		int basin = explore(zlist.get(count)[0], zlist.get(count)[1]);
		size.add(basin);
		count++;
	}
		Collections.sort(size, Collections.reverseOrder());
		base = size.get(0) * size.get(1) * size.get(2);
		return new int[] { sum, base };
    }

public static int explore(int x, int y) {
	if (x == -1 || y == -1 || x == 100 || y == 100) {
		return 0;
	}
	if (lavaMap[x][y] == 9) {
		return 0;
	}
	lavaMap[x][y] = 9;
		return 1 + explore(x + 1, y) + explore(x - 1, y) + explore(x, y + 1) + explore(x, y - 1);
}
