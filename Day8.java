public static int day8pt2() {

	String[] code = new String[10];
	String[] split = new String[2];
	int sum = 0;

	try {
		File myObj = new File("advent8.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String output = "";
			String signal = myReader.nextLine();
			split = signal.split(" \\| ");
			String[] pattern = split[0].split(" ");
			String[] out = split[1].split(" ");

            Arrays.sort(pattern, Comparator.comparingInt(String::length));

			for (int i = 0; i < 10; i++) {
				String str = stringSort(pattern[i]);
				if (str.length() == 2) {
					code[1] = str;
				} else if (str.length() == 4) {
					code[4] = str;
				} else if (str.length() == 3) {
					code[7] = str;
				} else if (str.length() == 7) {
					code[8] = str;
				} else if (str.length() == 5) {
					if (stringCompare(str, code[1]) == 2) {
						code[3] = str;
					} else if (stringCompare(str, code[4]) == 2) {
						code[2] = str;
					} else if (stringCompare(str, code[4]) == 3) {
						code[5] = str;
					}
				} else if (str.length() == 6) {
					if (stringCompare(str, code[5]) == 4) {
						code[0] = str;
					} else if (stringCompare(str, code[5]) == 5) {
						if (stringCompare(str, code[1]) == 1) {
							code[6] = str;
						} else {
							code[9] = str;
						}
					}
				}
			}
            for (int i = 0; i < 4; i++) {
			    String num = stringSort(out[i]);
				if (num.equals(code[0])) {
					output += "0";
				} else if (num.equals(code[1])) {
					output += "1";
				} else if (num.equals(code[2])) {
					output += "2";
				} else if (num.equals(code[3])) {
					output += "3";
				} else if (num.equals(code[4])) {
					output += "4";
				} else if (num.equals(code[5])) {
					output += "5";
				} else if (num.equals(code[6])) {
					output += "6";
				} else if (num.equals(code[7])) {
					output += "7";
				} else if (num.equals(code[8])) {
					output += "8";
				} else if (num.equals(code[9])) {
					output += "9";
				}
			}

			sum += Integer.parseInt(output);
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
		return sum;
	}

public static int stringCompare(String a, String b) {

	char[] arr = a.toCharArray();
	char[] brr = b.toCharArray();
	int count = 0;
	for (int i = 0; i < a.length(); i++) {
    	for (int j = 0; j < b.length(); j++) {
			if (arr[i] == brr[j]) {
				count++;
			}
		}
	}

	return count;
}

public static String stringSort(String str) {

	char[] arr = str.toCharArray();
	Arrays.sort(arr);
	String ret = "";

	for (char s : arr) {
		ret += s;
	}
	return ret;
}

public static int day8() {

	int ans = 0;
	String[] fsplit = new String[2];
	String[] ssplit = new String[4];

    try {
		File myObj = new File("advent8.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String signal = myReader.nextLine();
			fsplit = signal.split(" \\| ");
			ssplit = fsplit[1].split(" ");
    		for (String str : ssplit) {
				if (str.length() == 2 || str.length() == 4 || str.length() == 3 || str.length() == 7) {
					ans++;
				}
			}
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}

	return ans;
}
