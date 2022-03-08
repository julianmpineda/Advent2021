	public static long day6(int days) {

		ArrayList<Integer> fish = new ArrayList<Integer>(Arrays.asList(5, 1, 1, 4, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 4, 2, 1, 1, 1, 3, 5, 1, 1, 1, 5, 4, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 5, 2, 1, 2, 2, 3, 1, 1,
				1, 1, 1, 1, 1, 1, 5, 1, 1, 4, 1, 1, 1, 5, 4, 1, 1, 3, 3, 2, 1, 1, 1, 5, 1, 1, 4, 1, 1, 5, 1, 1, 5, 1, 2,
				3, 1, 5, 1, 3, 2, 1, 3, 1, 1, 4, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 4, 4, 1, 5, 1, 1, 3, 5, 1, 1, 5,
				1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 1,
				4, 1, 1, 1, 1, 4, 1, 1, 1, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 4, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1,
				1, 4, 1, 1, 2, 2, 1, 2, 4, 1, 1, 3, 1, 1, 1, 5, 1, 3, 1, 1, 1, 5, 5, 1, 1, 1, 1, 2, 3, 4, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 5, 1, 4, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				3, 3, 1, 2, 2, 1, 4, 1, 5, 1, 5, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 4,
				3, 1, 1, 4));

		long[] fishcount = new long[9];
		long zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0;

		long sum = 0;

		for (int num : fish) {
			fishcount[num]++;
		}

		for (int i = 0; i < days; i++) {
			zero = fishcount[0];
			one = fishcount[1];
			two = fishcount[2];
			three = fishcount[3];
			four = fishcount[4];
			five = fishcount[5];
			six = fishcount[6];
			seven = fishcount[7];
			eight = fishcount[8];

			fishcount[0] = one;
			fishcount[1] = two;
			fishcount[2] = three;
			fishcount[3] = four;
			fishcount[4] = five;
			fishcount[5] = six;
			fishcount[6] = seven + zero;
			fishcount[7] = eight;
			fishcount[8] = zero;

		}

		for (long num : fishcount) {
			sum += num;
		}

		return sum;

	}
