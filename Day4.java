public static void day4new() {

	String[] ballList = new String[] {};
	List<int[][]> boardList = new ArrayList<int[][]>();
	List<Integer> winList = new ArrayList<Integer>();

	try {
		File myObj = new File("advent4.txt");
		Scanner myReader = new Scanner(myObj);

		ballList = myReader.nextLine().split(",");
		myReader.nextLine();

		while (myReader.hasNextLine()) {
			int[][] board = new int[6][6];
			int boardSum = 0;
			for (int i = 0; i < 5; i++) {
				board[i][5] = 0;
				board[5][i] = 0;
				for (int j = 0; j < 5; j++) {
					board[i][j] = myReader.nextInt();
					boardSum += board[i][j];
				}
			}
			board[5][5] = boardSum;
			boardList.add(board);
			myReader.nextLine();
		}

        myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	// i = ball, j = board
	int firstWin = Integer.MAX_VALUE, lastWin = Integer.MIN_VALUE;
	for (int i = 0; i < ballList.length; i++) {
		int ball = Integer.parseInt(ballList[i]);
		for (int j = 0; j < boardList.size(); j++) {
			if (!winList.contains(j)) {
				int[][] board = boardList.get(j);
				boolean found = false;

                for (int q = 0; q < 5 && !found; q++) {
					for (int r = 0; r < 5; r++) {
						if (board[q][r] == ball) {
							board[q][5]++;
							board[5][r]++;
							board[5][5] -= ball;

                            if (board[q][5] == 5 || board[5][r] == 5) {
								winList.add(j);
								firstWin = Math.min(firstWin, i);
								lastWin = Math.max(lastWin, i);
							}
							found = true;
                        }
                    }
				}
			}
        }
	}

	int boardSum = boardList.get(winList.get(0))[5][5];		
	
    System.out.println("Part 1: " + boardSum * Integer.parseInt(ballList[firstWin]));
		
	boardSum = boardList.get(winList.get(winList.size() - 1))[5][5];
		
    System.out.println("Part 2: " + boardSum * Integer.parseInt(ballList[lastWin]));
}
