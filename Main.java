import java.util.Scanner;

class Main {
    static class Node {
        String name;
        String gen;
        int age;
        Node link;

        Node(String name, String gen, int age) {
            this.name = name;
            this.gen = gen;
            this.age = age;
            this.link = null;
        }
    }

    static Node start = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, d;
        String source, des, Bus, stop, cla;
        int time1, time2;

        System.out.print("Enter Number Of Passengers: ");
        j = scanner.nextInt();
        details(j);

        System.out.print("Enter The Source Place: ");
        source = scanner.next();

        System.out.print("Enter The Destination Place: ");
        des = scanner.next();

        System.out.println("\t\tThe Following buses Are Available.....");
        System.out.println("\t\t1. Kmbt........10:00 a.m........Sealdah Stop");
        System.out.println("\t\t2. Amaravathi...05:00 p.m........Amaravathi Stop");
        System.out.println("\t\t3. Humsafer.....11:00 p.m........Kolkata Chitpur Stop");
        System.out.println("\t\t4. Orange.......05:00 p.m........Nagpur Stop");
        System.out.println("\t\t5. Morning star.07:00 a.m........Santraganchi Stop");

        i = scanner.nextInt();

        do {
            switch (i) {
                case 1: {
                    Bus = "Kmbt";
                    stop = "Sealdah Stop";
                    time1 = 10;
                    time2 = 0;
                    d = cal(2099, 1560, j);
                    System.out.println("Total Bill Amount: " + d);
                    break;
                }
                case 2: {
                    Bus = "Amaravathi";
                    stop = "Amaravathi Stop";
                    time1 = 17;
                    time2 = 0;
                    d = cal(1801, 981, j);
                    System.out.println("Total Bill Amount: " + d);
                    break;
                }
                case 3: {
                    Bus = "Humsafar";
                    stop = "Kolkata Chitpur Stop";
                    time1 = 23;
                    time2 = 0;
                    d = cal(2199, 1780, j);
                    System.out.println("Total Bill Amount: " + d);
                    break;
                }
                case 4: {
                    Bus = "Orange";
                    stop = "Nagpur Stop";
                    time1 = 17;
                    time2 = 0;
                    d = cal(1759, 1200, j);
                    System.out.println("Total Bill Amount: " + d);
                    break;
                }
                case 5: {
                    Bus = "Morning star";
                    stop = "Santraganchi Stop";
                    time1 = 7;
                    time2 = 0;
                    d = cal(2205, 1905, j);
                    System.out.println("Total Bill Amount: " + d);
                    break;
                }
                default:
                    System.out.println("Enter Correct choice.....");
                    return;
            }
        } while (false);

        System.out.println("Now Book Your Seats......");
        seat(j);
        bill(d, j);
    }

    static void details(int k) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= k; i++) {
            System.out.print("Enter The " + i + "th Passenger Name: ");
            String name = scanner.next();

            System.out.print("Enter The " + i + "th Passenger Gender: ");
            String gen = scanner.next();

            System.out.print("Enter The " + i + "th Passenger Age: ");
            int age = scanner.nextInt();

            addNode(name, gen, age);
        }
    }

    static void addNode(String name, String gen, int age) {
        Node newPtr = new Node(name, gen, age);
        if (start == null)
            start = newPtr;
        else {
            Node ptr = start;
            while (ptr.link != null)
                ptr = ptr.link;
            ptr.link = newPtr;
        }
    }

    static int cal(int y1, int y2, int h) {
        Scanner scanner = new Scanner(System.in);
        int b, c, n;

        System.out.println("\t\tEnter Your Choice......");
        System.out.println("\t\t1. Sleeper Class....");
        System.out.println("\t\t2. A.C Class.......");

        int i = scanner.nextInt();

        switch (i) {
            case 1: {
                b = y2 * h;
                c = b + (b * 18 / 100);
                break;
            }
            case 2: {
                System.out.println("\t\tEnter Your Choice....");
                System.out.println("\t\t1. 3A Class....");
                System.out.println("\t\t2. 2A Class....");
                System.out.println("\t\t3. 1st Class A.C.....");
                n = scanner.nextInt();

                switch (n) {
                    case 1: {
                        b = y1 * h;
                        c = b + (b * 18 / 100);
                        break;
                    }
                    case 2: {
                        b = (y1 + 1000) * h;
                        c = b + (b * 18 / 100);
                        break;
                    }
                    case 3: {
                        b = (y1 + 5000) * h;
                        c = b + (b * 18 / 100);
                        break;
                    }
                    default: {
                        System.out.println("\t\tEnter Right Choice......");
                        return 0;
                    }
                }
                break;
            }
            default: {
                System.out.println("\t\tEnter Right Choice......");
                return 0;
            }
        }

        return c;
    }

    static void seat(int p) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[55];

        System.out.println("\t\t\t -:SEAT MATRIX:-	 ");
        // Printing Seat Matrix
        // Assuming you have the seat matrix printing logic here

        System.out.println("Enter Seat Numbers: ");
        for (int i = 0; i < p; i++)
            a[i] = scanner.nextInt();
    }

    static void bill(int y, int j) {
        Node ptr = start;
        for (int i = 1; i <= j; i++) {
            System.out.print("\t\t" + i + "st Passenger Name: " + ptr.name + "\n");
            System.out.print("\t\t" + i + "st Passenger Gender: " + ptr.gen + "\n");
            System.out.print("\t\t" + i + "st Passenger Age: " + ptr.age + "\n\n");
            ptr = ptr.link;
        }
        // Printing other bill details
        // Assuming you have the bill printing logic here
    }
}
