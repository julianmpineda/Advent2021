public static int stringTest(String one, String two) {

	//returns first different index, or -1 if they match fully.
	
	boolean flag = true;
	int count = 0;
	for (int i = 0; i < one.length() && flag; i++) {
		flag = two.charAt(i) == one.charAt(i);
		count = i;
	}
	
	if (!flag) {
		return count;
	} else {
		return -1;
	}
}