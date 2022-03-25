private static int[][] octo = new int[][] { { 4, 8, 3, 6, 4, 8, 4, 5, 5, 5 }, { 4, 6, 6, 3, 8, 4, 1, 7, 7, 2 },
		{ 3, 5, 1, 2, 4, 8, 4, 5, 5, 6 }, { 1, 4, 8, 1, 5, 4, 7, 5, 7, 2 }, { 7, 7, 4, 1, 1, 8, 3, 4, 2, 2 },
		{ 8, 6, 8, 3, 2, 2, 2, 8, 8, 2 }, { 4, 2, 1, 5, 2, 4, 4, 2, 3, 3 }, { 1, 5, 4, 4, 7, 1, 2, 1, 7, 1 },
		{ 5, 7, 2, 5, 8, 5, 5, 7, 8, 6 }, { 1, 7, 1, 7, 3, 8, 2, 2, 8, 1 } };

public static int[] day11() {

	int sum = 0, days = 0, count = 0, save = 0;

    while (save == 0) {
		days++; // Part 2
		// for (int d = 0; d < 100; d++) { //- Part 1

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				octo[i][j]++;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				sum += octoFlash(i, j);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (octo[i][j] < 0) {
					octo[i][j] = 0;
					count++;
			    }
            }	
		}
		if (count == 100) {
			save = days;
		}
		count = 0;
	}

	return new int[] { sum, save };
}

public static int octoFlash(int x, int y) {

	if (x == -1 || x == 10 || y == -1 || y == 10) {
		return 0;
	}

	int sum = 0;
		if (octo[x][y] > 9) {
			octo[x][y] = -9;
		sum++;
			if (x > 0) {
			if (y > 0) {
				octo[x - 1][y - 1]++;
			}
			if (y < 9) {
				octo[x - 1][y + 1]++;
			}
			octo[x - 1][y]++;
		}
		if (x < 9) {
			if (y > 0) {
				octo[x + 1][y - 1]++;
			}
			if (y < 9) {
				octo[x + 1][y + 1]++;
			}
			octo[x + 1][y]++;
		}
		if (y > 0) {
			octo[x][y - 1]++;
		}
		if (y < 9) {
			octo[x][y + 1]++;
		}
		sum += octoFlash(x - 1, y - 1);
		sum += octoFlash(x - 1, y + 1);
		sum += octoFlash(x - 1, y);
		sum += octoFlash(x + 1, y - 1);
		sum += octoFlash(x + 1, y + 1);
		sum += octoFlash(x + 1, y);
		sum += octoFlash(x, y - 1);
		sum += octoFlash(x, y + 1);
	}
	return sum;
}
