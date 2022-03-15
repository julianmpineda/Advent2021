	public static int day4() {
		int[] balls = new int[] { 1, 76, 38, 96, 62, 41, 27, 33, 4, 2, 94, 15, 89, 25, 66, 14, 30, 0, 71, 21, 48, 44,
				87, 73, 60, 50, 77, 45, 29, 18, 5, 99, 65, 16, 93, 95, 37, 3, 52, 32, 46, 80, 98, 63, 92, 24, 35, 55,
				12, 81, 51, 17, 70, 78, 61, 91, 54, 8, 72, 40, 74, 68, 75, 67, 39, 64, 10, 53, 9, 31, 6, 7, 47, 42, 90,
				20, 19, 36, 22, 43, 58, 28, 79, 86, 57, 49, 83, 84, 97, 11, 85, 26, 69, 23, 59, 82, 88, 34, 56, 13 };

		boolean win = false;
		boolean[][] callMap = new boolean[5][5];
		int[][] bingoBoard = new int[5][5];

		int ballNum = 4, start = 0, count = 1;

		while (!win) {

			start = 0;
			count = 1;
			ballNum++;

			while (start < 600 && !win) {

				bingoBoard = getBoard(start);
				int[] ballsCalled = Arrays.copyOfRange(balls, 0, ballNum);

				for (int i = 0; i < 5 && !win; i++) {
					win = checkWin(bingoBoard[i], ballsCalled);
					if (win) {
						System.out.print("Win on board " + count + " column " + (i + 1));
						System.out.print(" on ball " + ballNum);
						System.out.println();
					}
				}

				if (!win) {
					for (int i = 0; i < 5 && !win; i++) {
						int[] line = new int[5];
						for (int j = 0; j < 5; j++) {
							line[j] = bingoBoard[j][i];
						}
						win = checkWin(line, ballsCalled);
						if (win) {
							System.out.print("Win on board " + count + " column " + (i + 1));
							System.out.print(" on ball " + ballNum);
							System.out.println();
						}
					}
				}
				start += 6;
				count++;
			}
		}

		int sum = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < ballNum; k++) {
					if (bingoBoard[i][j] == balls[k]) {
						callMap[i][j] = true;
					}
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!callMap[i][j]) {
					sum += bingoBoard[i][j];
				}
			}
		}

		return sum * balls[ballNum - 1];
	}

	public static int day4pt2() {
		int[] balls = new int[] { 1, 76, 38, 96, 62, 41, 27, 33, 4, 2, 94, 15, 89, 25, 66, 14, 30, 0, 71, 21, 48, 44,
				87, 73, 60, 50, 77, 45, 29, 18, 5, 99, 65, 16, 93, 95, 37, 3, 52, 32, 46, 80, 98, 63, 92, 24, 35, 55,
				12, 81, 51, 17, 70, 78, 61, 91, 54, 8, 72, 40, 74, 68, 75, 67, 39, 64, 10, 53, 9, 31, 6, 7, 47, 42, 90,
				20, 19, 36, 22, 43, 58, 28, 79, 86, 57, 49, 83, 84, 97, 11, 85, 26, 69, 23, 59, 82, 88, 34, 56, 13 };

		boolean win = false;
		boolean[][] callMap = new boolean[5][5];
		int[][] bingoBoard = new int[5][5];
		boolean[] boardWin = new boolean[100];

		int ballNum = 4, start = 0, count = 1;

		while (ballNum < 100) {

			start = 0;
			count = 1;
			ballNum++;

			while (start < 600) {
				if (!boardWin[count - 1]) {
					// System.out.println("Board " + count + " being tested.");
					bingoBoard = getBoard(start);
					int[] ballsCalled = Arrays.copyOfRange(balls, 0, ballNum);

					for (int i = 0; i < 5 && !boardWin[count - 1]; i++) {
						win = checkWin(bingoBoard[i], ballsCalled);
						if (win) {
							boardWin[count - 1] = true;
						}
					}

					if (!win) {
						for (int i = 0; i < 5 && !boardWin[count - 1]; i++) {
							int[] line = new int[5];
							for (int j = 0; j < 5; j++) {
								line[j] = bingoBoard[j][i];
							}
							win = checkWin(line, ballsCalled);
							if (win) {
								boardWin[count - 1] = true;
							}
						}
					}
				}
				start += 6;
				count++;
			}
		}
		int sum = 0;

		bingoBoard = getBoard(72 * 6);
		ballNum = 86;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < ballNum; k++) {
					if (bingoBoard[i][j] == balls[k]) {
						callMap[i][j] = true;
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!callMap[i][j]) {
					sum += bingoBoard[i][j];
				}
			}
		}
		return sum * balls[ballNum - 1];
	}

	public static int[][] getBoard(int start) {

		String[][] bingoBoard = new String[5][5];
		int[][] board = new int[5][5];

		int row = 0;

		try {
			File myObj = new File("advent4sf.txt");
			Scanner myReader = new Scanner(myObj);

			for (int i = 0; i < start; i++) {
				myReader.nextLine();
			}
			while (row < 5) {
				String line = myReader.nextLine();
				bingoBoard[row] = line.split("\\s+");
				row++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(bingoBoard[i][j]);
			}
		}
		return board;
	}

	public static boolean checkWin(int[] line, int[] balls) {

		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < balls.length; j++) {
				if (line[i] == balls[j]) {
					count++;
				}
			}
		}
		if (count == 5) {
			return true;
		}
		return false;
	}
