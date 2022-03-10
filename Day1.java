	public static int day1() {

		int count = 0;
		try {
			File myObj = new File("advent1.txt");
			File myObj2 = new File("advent1.5.txt");
			Scanner myReader = new Scanner(myObj);
			Scanner myReader2 = new Scanner(myObj2);
      
			while (myReader2.hasNextLine()) {
				String nextLine = myReader.nextLine();
				String winEnd = myReader2.nextLine();
				int data = Integer.valueOf(nextLine);
				int data2 = Integer.valueOf(winEnd);
				if (data2 > data) {
					count++;
				}
			}
      
			myReader.close();
			myReader2.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return count;
	}
