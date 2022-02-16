public static int stringTest(String one, String two) {

	//returns first different index, or -1 if they match fully, -2 if they are different lengths.
	
	if (one.length() != two.length()) {
		return -2;
	}
	
	int count = 0;
	
	while (count < one.length && two.charAt(count) == one.charAt(count)) {
		count++;
	}
	
	if (count != one.length()) {
		return count;
	} else {
		return -1;
	}
}
