public static long day6(int days) {

	List<Integer> fish = new ArrayList<Integer>();
	long[] fishcount = new long[9];
	long sum = 0L;
	
	try {
		File myObj = new File("advent6.txt");
		Scanner myReader = new Scanner(myObj).useDelimiter("\\D");
		while (myReader.hasNext()) {
			fish.add(myReader.nextInt());
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	for (int num : fish) {
		fishcount[num]++;
	}

	for (int i = 0; i < days; i++) {
		sum = fishcount[0];
		fishcount[0] = fishcount[1];
		fishcount[1] = fishcount[2];
		fishcount[2] = fishcount[3];
		fishcount[3] = fishcount[4];
		fishcount[4] = fishcount[5];
		fishcount[5] = fishcount[6];
		fishcount[6] = fishcount[7] + sum;
		fishcount[7] = fishcount[8];;
		fishcount[8] = sum;
	}

    sum = 0;
    
	for (long num : fishcount) {
        sum += num;
	}

	return sum;

}
