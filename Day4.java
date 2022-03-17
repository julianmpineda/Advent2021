public static void day4() {
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
        for (int i = 0; i < 5; i++) {
			board[i][5] = 0;
            board[5][i] = 0;
			for (int j = 0; j < 5; j++) {
                board[i][j] = myReader.nextInt();
            }
        }
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

		int[][] board = boardList.get(winList.get(0));
		int count = 0, boardSum = 0;

		while (count <= firstWin) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == Integer.parseInt(ballList[count])) {
						board[i][j] = 0;
					}
				}
			}
			count++;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				boardSum += board[i][j];
			}
		}
		
		System.out.println("Part 1: " + boardSum * Integer.parseInt(ballList[firstWin]));

		board = boardList.get(winList.get(winList.size() - 1));
		count = 0;
		boardSum = 0;

		while (count <= lastWin) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == Integer.parseInt(ballList[count])) {
						board[i][j] = 0;
					}
				}
			}
			count++;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				boardSum += board[i][j];
			}
		}

	
		System.out.println("Part 2: " + boardSum * Integer.parseInt(ballList[lastWin]));
    }
