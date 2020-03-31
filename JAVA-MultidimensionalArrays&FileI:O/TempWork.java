//package Tickets2;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class TempWork {
//    TheatreSeat First; // Head of the linked list poinying to the first seat in the auditorium
//    protected int size;
//
//    // Overloaded Auditorium-Building constrcutor:
//
//    public TempWork() throws FileNotFoundException {
//        Scanner inputFile = new Scanner(new File("src/Tickets2/A1base.txt"));
//        int Row = 0;
//        char Seat = 0;
//        char TicketType = 0;
//        int seat_count = 0;
//        char temp;
//        String inputLine;
//        Auditorium newAuditoriumList = new Auditorium();
//        while (inputFile.hasNextLine()) {
//            inputLine = inputFile.nextLine();
//            int position = 0; // Parsing the string called line into single elements
//
//            Row++;
//            for (int i = 0; i < inputLine.length(); i++) {
//                temp = inputLine.charAt(position);
//                System.out.println("Seat Reservation: " + temp);
//                Seat = convert_to_seatLetter(seat_count); // Seat Letter or the Column starting from 'A' to as many seats in the row
//                TicketType = temp; // Assign the Seat that was read into the memory to the TicketType
//                if (temp == 'A' || temp == 'S' || temp == 'C') // is the seat is occupied by one of the following, then
//                {
//                    newAuditoriumList.addAsLast(Row, Seat, true, TicketType);
//
//                } else { // if the seat hasn't been reserved, and is represented by a '.'  then,
//                    newAuditoriumList.addAsLast(Row, Seat, false, TicketType);
//                } // end if else
//                position++;
//            }
//
//        } // end while loop
//        inputFile.close();
//    }
//
//    public TempWork(TheatreSeat first) {
//        First = first;
//    }
//
//    public void addAsLast(int Row, char Seat, boolean Reserved, char TicketType) {
//        TheatreSeat newNode = new TheatreSeat(Row, Seat, Reserved, TicketType);
//        if (First == null) // list is empty
//        {
//            First = newNode; // chained assignment statement
//            System.out.println("Hey I added the first Node");
//
//        } else {
//            First.right = newNode;
//            //System.out.println("I added a new Node");
//
//        }
//        size++;
//    }
//
//    public void display() {
//        System.out.println("The number of nodes in this singly linked list: " + size);
//        TheatreSeat temp = First;
//        if (First == null) {
//            System.out.println("List is empty");
//        } else {
//            while (temp != null) {
//                //PrintInfo(temp);
//                System.out.println("There is a node here ");
//                temp = temp.right;
//            }
//
//        }
//    }
//
//    public void PrintInfo(TheatreSeat temp) {
//        System.out.println("Seat (" + temp.getRow() + ", " + temp.getSeat() + ") is booked for a "
//                + temp.getTicket_type() + "\n"); // seat(x,y) = seat(row, column);
//    }
//
//    public static char convert_to_seatLetter(int i) { //FUNCTION TO CONVERT THE INDEX IN THE ARRAY TO A SEAT LETTER
//        char seatLetter = (char) ('A' + i); // index i + the value of A gives the seat letter, if index is 0, then the user is at 'A'
//        return seatLetter;
//    } // convert_to_seatLetter defined
//
//
//    //Accessor:
//    public TheatreSeat getFirst() {
//        return First;
//    }
//
//    //Mutator:
//    public void setFirst(TheatreSeat first) {
//        First = first;
//    }


//    public void display()
//    {
//        //System.out.println("The number of nodes in this singly linked list: " + size);
//        TheatreSeat tempRow = First;
//        TheatreSeat tempCol = First;
//        if(tempRow == null)
//        {
//            System.out.println("Auditorium is empty");
//        } else {
//            while(tempRow != null) {
//                tempCol = tempRow;
//                //System.out.println("Hola");
//                while(tempCol != null){
//                    PrintInfo(tempCol);
//                    tempCol = tempCol.down;
//                }
//                //PrintInfo(tempRow);
//                tempRow = tempRow.right;
//            }
//
//        }
//    }
//
//    public void displayRaw()
//    {
//        //System.out.println("The number of nodes in this singly linked list: " + size);
//        TheatreSeat tempRow = First;
//        TheatreSeat tempCol = First;
//        if(tempCol == null)
//        {
//            System.out.println("Auditorium is empty");
//        } else {
//            System.out.printf("  ");
//            while(tempRow != null)
//            {
//                System.out.print(tempRow.getSeat() + " ");
//                tempRow = tempRow.right;
//            } // end nested-while
//            System.out.printf("\n");
//            tempRow = First;
//            while(tempCol != null)
//            {
//                System.out.print(tempCol.getRow() + " ");
//                tempRow = tempCol;
//                while(tempRow != null)
//                {
//                    PrintRaw(tempRow);
//                    tempRow = tempRow.right;
//                } // end nested-while
//                tempCol = tempCol.down;
//                System.out.println();
//            } // end while loop
//        } // if-else evaluation
//    } // display Function defined

//    public static int FindNextBestPossibleSeats(Scanner input, Auditorium A, int row, char Seat, int l, int r, int total_tickets,
//                                                int adult_tickets, int child_tickets, int senior_tickets)
//    {
//        if (r >= l) {
//            int mid = l + (r - l) / 2;
//            char seat = convert_to_seatLetter(mid);
//            System.out.println("HOLAAAAAAA THIS IS WHAT MID IS: " + seat);
//            char seatlabel = 0;
//            // Find the node in the row with the seat/column letter
//            TheatreSeat temp = A.SearchIfReserved(row, seat);
//            if(temp != null) {
//                seatlabel = temp.getTicket_type(); // get the ticket
//            }
//            // If the element is present at the
//            // middle itself
//            if (seatlabel == '.') // if the seat is empty, check if consecutive seats are available
//            {
//                if(CheckConsequtiveAvailability(A,row, seat, total_tickets) == total_tickets)
//                {
//                    // if consequtive seats have been found on the first try reserve them
//                    char yes_or_no = 0;
//                    boolean gooddata = false;
//                    System.out.println("Next Best Seats have been found, Would you like to reserve them (Enter 'Y' for Yes or 'N' for No): ");
//                    while (!gooddata) {
//                        try {
//                            yes_or_no = input.next().charAt(0);
//                            gooddata = true;
//                        } catch (InputMismatchException ex) {
//                            System.out.println("Please make sure to enter an integer number to represent your row number: ");
//                            String flush = input.next();
//                        }
//                    }
//                    if(yes_or_no == 'Y') {
//                        A = ReserveSeats(A, row, seat, adult_tickets,child_tickets, senior_tickets);
//                    }
//                    return mid; // from this seat on is where the tickets have been reserved
//                }
//            }
//            // If element is smaller than mid, then
//            // it can only be present in left subarray
//            if (seat > Seat) {
//                return FindNextBestPossibleSeats(input, A, row, Seat, l, mid-1, total_tickets, adult_tickets,child_tickets,senior_tickets);
//            }
//            // Else the element can only be present
//            // in right subarray
//            return FindNextBestPossibleSeats(input, A, row, Seat, mid+l, r, total_tickets, adult_tickets,child_tickets,senior_tickets);
//
//            //return binarySearch(arr, mid + 1, r, x);
//        }
//        return -1;
//    }

 // IN MAIN:
////        newAuditorium.addNode(1,'A', true, 'S', 5);
////        newAuditorium.addNode(1,'B', true, 'S', 5);
////        newAuditorium.addNode(1,'C', true, 'C', 5);
////        newAuditorium.addNode(1,'D', true, 'C', 5);
////        newAuditorium.addNode(1,'E', false,'.', 5);
////        newAuditorium.addNode(2,'A', true, 'A', 5);
////        newAuditorium.addNode(2,'B', true, '.', 5);
////        newAuditorium.addNode(2,'C', true, 'A', 5);
////        newAuditorium.display();
//}

//                    mid_number = FindNextBestPossibleSeats(input, newAuditorium, row_num, seat_letter, l, r, total_tickets, adult_tickets,child_tickets,senior_tickets);
//                    if(mid_number != -1 ) {
//                        newAuditorium.display();
//
//                    }