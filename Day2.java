public static void day2() {
    List<String> heading = new ArrayList<String>();
    int depth = 0, position = 0, aim = 0;

    try {
        File myObj = new File("advent2.txt");
        Scanner myReader = new Scanner(myObj);
        
        while (myReader.hasNextLine()) {
            heading.add(myReader.nextLine());
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    //Part 1
    for (int i = 0; i < heading.size(); i++) {
        String[] direction = heading.get(i).toCharArray();
        int distance = Integer.parseInt(direction[1]);
        if (direction[0].contains("forward")) {
            position += distance;
        } else if (direction[0].contains("up")) {
            depth -= distance;
        } else if (direction[0].contains("down")) {
            depth += distance;
        }
    }
    System.out.println("Part 1: " + (position * depth));
    
    //Part 2
    for (int j = 0; j < heading.size(); j++) {
        String[] direction = heading.get(i).split(" ");
        int distance = Integer.parseInt(direction[1]);
        if (direction[0].contains("forward")) {
            position += distance;
            depth += distance * aim;
        } else if (direction[0].contains("up")) {
            aim -= distance;
        } else if (direction[0].contains("down")) {
            aim += distance;
        }
    }
    System.out.println("Part 2: " + (position * depth));
    
}
