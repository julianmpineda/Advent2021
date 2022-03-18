public static void day5() {

	List<String> vents = new ArrayList<String>();
	Map<String, Integer> ventsMap = new HashMap<String, Integer>();

	try {
		File myObj = new File("advent5.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			vents.add(myReader.nextLine());
			}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
    
    //Part 1

	for (int i = vents.size() - 1; i >= 0; i--) {
		int[] range = Arrays.stream(vents.get(i).split(",| -> ")).mapToInt(Integer::parseInt).toArray();

		if (range[0] == range[2] | range[1] == range[3]) {
			vents.remove(i);
		}

		if (range[0] == range[2]) { // fixed X
			int min = Math.min(range[1], range[3]);
			int max = Math.max(range[1], range[3]);

			for (int j = min; j <= max; j++) {
				String point = "" + range[0] + "," + j;
				if (ventsMap.containsKey(point)) {
					ventsMap.put(point, ventsMap.get(point) + 1);
				} else {
					ventsMap.put(point, 1);
				}
			}

		} else if (range[1] == range[3]) { // fixed Y

			int min = Math.min(range[0], range[2]);
			int max = Math.max(range[0], range[2]);

			for (int j = min; j <= max; j++) {
				String point = "" + j + "," + range[1];
				if (ventsMap.containsKey(point)) {
					ventsMap.put(point, ventsMap.get(point) + 1);
				} else {
					ventsMap.put(point, 1);
				}
			}
		}
	}

	int count = 0;

	for (int value : ventsMap.values()) {
		if (value > 1) {
			count++;
		}
	}

	System.out.println("Part 1: " + count);
    
    //Part 2

	for (int i = vents.size() - 1; i >= 0; i--) {
			
		int[] range = Arrays.stream(vents.get(i).split(",| -> ")).mapToInt(Integer::parseInt).toArray();
		int directionX = 1, directionY = 1;
		int len = Math.abs(range[0] - range[2]);
		if (range[0] > range[2]) {
			directionX = -1;
		}

		if (range[1] > range[3]) {
			directionY = -1;
		}

		for (int j = 0; j <= len; j++) {
			String point = "" + (range[0] + (j * directionX)) + "," + (range[1] + (j * directionY));
			if (ventsMap.containsKey(point)) {
				ventsMap.put(point, ventsMap.get(point) + 1);
			} else {
				ventsMap.put(point, 1);
			}
		}
	}
		
	count = 0;
		
	for (int value : ventsMap.values()) {
		if (value > 1) {
			count++;
		}
	}

	System.out.println("Part 2: " + count);
}
