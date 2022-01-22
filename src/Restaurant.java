import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*
            EXPLICATION ABOUT PROGRAM
        The program is from a restaurant, to use it correctly you must first reserve/occupy a table,
        after that you can access the menu, and the closing of hours.
        */

        //MENU
        Products[] product = new Products[10];
        product[0] = new Products("Shrimp sequence", "100g of prawns on the breath," +
                "200g breaded shrimp, 100g garlic and oil shrimp, 5 crab cakes, mayonnaise, " +
                "rice and fish sauce.", 59);
        product[1] = new Products("Seafood Pizza M", "mozzarella, palm oil, " +
                "shrimp, squid rings and clams", 30);
        product[2] = new Products("Crab pastry", "Crab and cheese", 10);
        product[3] = new Products("Oyster Gratin (un.)", "Oyster stuffed with mozzarella and partablen",
                5);
        product[4] = new Products("Squid tentacles", "500g of squid tentacles served with rice, fish sauce and " +
                "mayonnaise salad", 199);
        product[5] = new Products("Soda 390ml", "", 2);
        product[6] = new Products("Wine 2l", "", 90);
        product[7] = new Products("Juice Jug", "", 8);
        product[8] = new Products("Beer 500ml", "", 3);
        product[9] = new Products("Water 500ml", "", 0.99);

        int j;
        int k;
        int m;
        int z;
        double totalproduct = 0;
        double invoiceTotal = 0;

        //A = AVAILABLE, R = RESERVED, B = BUSY


        String[] table = new String[10];
        String[][] client = new String[10][2]; //Reserved customer list
        double[] tableproducts = new double[10]; //total list;
        Products[][] consumedProducts = new Products[100][10]; //relation products/tables
        //To the tableproducts
        
        double totalWork = 0;

        int count = 0;

        //inicilizacao de consumedProducts

        //inicializaçao da tableproducts
        for(m=0; m<10; m++){
            tableproducts[m] = 0.0;
        }

        System.out.println();

        System.out.println("Tables Currently: ");
        for (j = 0; j < 10; j++) {
            table[j] = "A";
            System.out.print("[" + table[j] + "]" + " ");
        }
        System.out.println();

        int choice;
        do{
                System.out.println("\nHi, welcome to the Oceanic Menu. Tell us what you want to do: ");
            System.out.println("1- Choose Table\n2- See Menu\n3- Close Account\n4- Close Program");
            choice = input.nextInt();

            switch(choice) {
                case 1:
                    for (j = 0; j < 10; j++) {
                        System.out.print("[" + table[j] + "]" + " ");
                    }

                    System.out.println("\n1- Reserve a table\n2-Take a table");
                    int choice2 = input.nextInt();
                    if (choice2 == 1) {
                        System.out.println("Choose fom the available ones (0 to 9)");
                        int choice3 = input.nextInt();
                        for (j = 0; j < 10; j++) {
                            String checkTable = table[choice3];
                        }
                        if (table[choice3].equals("A")) {
                            table[choice3] = "R";
                            System.out.println("Type your name: ");
                            String name = input.next();
                            name = name.toUpperCase();
                            String reservedTable = table[choice3];
                            client[choice3][0] = reservedTable;
                            client[choice3][1] = name;

                            for (k = 0; k < 10; k++) {
                                System.out.print("\n[" + client[k][0] + "]" + " " + "[" + client[k][1] + "]");
                            }
                            System.out.println("\n");
                            for (j = 0; j < 10; j++) {
                                System.out.print("[" + table[j] + "]" + " ");
                            }
                            System.out.println();
                            System.out.println("\nReserved table successfully, " + name + "!");

                        }else if(table[choice3].equals("R") || table[choice3].equals("B")) {
                            System.out.println("Sorry, this table is already occupied/reserved");
                        }
                        if (choice3 < 0 || choice3 > 9) {
                            System.out.println("Please enter a valid table!");
                        }
                    }
                    if (choice2 == 2) {
                        System.out.println("Choose fom the available ones (0 to 9)");
                        int choice3 = input.nextInt();
                        for (j = 0; j < 10; j++) {
                            String checkTable = table[choice3];
                        }
                        if (table[choice3].equals("A")) {
                            System.out.println("Table successfully occupied!");
                            table[choice3] = "B";
                            System.out.println("\n");
                            for (j = 0; j < 10; j++) {
                                System.out.print("[" + table[j] + "]" + " ");
                            }
                        }else if (table[choice3].equals("B")) {
                            System.out.println("Sorry, this table is already busy at the moment!");
                        } else if (table[choice3].equals("R")) {
                            System.out.println("Have you booked a table? y/n");
                            String reservedTableAnswer = input.next();
                            reservedTableAnswer = reservedTableAnswer.toUpperCase();
                            if (reservedTableAnswer.equals("Y")) {
                                System.out.println("Okay, tell us your name to confirm the reservation!");
                                String nameReserved = input.next();
                                nameReserved = nameReserved.toUpperCase();
                                if (client[choice3][1].equals(nameReserved)) {
                                    System.out.println("Reservation confirmed, welcome, " + nameReserved + "!");
                                    table[choice3] = "B";
                                    System.out.println("\n");
                                    for (j = 0; j < 10; j++) {
                                        System.out.print("[" + table[j] + "]" + " ");
                                    }
                                    client[choice3][0] = " ";
                                    client[choice3][1] = " ";
                                }else if (!client[choice3][1].equals(nameReserved)) {
                                    System.out.println("Your name is not in the booking system!");
                                }
                            } else if (reservedTableAnswer.equals("N")) {
                                System.out.println("This table is currently reserved");
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("MENU");
                    for (int i = 0; i < 10; i++) {
                        System.out.println(product[i].toString());
                    }
                    System.out.println("Want to choose something now? y/n");
                    String menuAnswer = input.next();
                    menuAnswer = menuAnswer.toUpperCase();
                    if (menuAnswer.equals("Y")) {
                        System.out.println("Enter your table");
                        int chosenTable = input.nextInt();
                        if (table[chosenTable].equals("B")) {
                            String orderEnd;
                             do{
                                System.out.println("Enter the product number from 0 to 9");
                                int chosenProduct = input.nextInt();
                                double productPrice = product[chosenProduct].getPrice();
                                totalproduct+=productPrice;
                                consumedProducts[count++][chosenTable] = product[chosenProduct];
                                System.out.println("Choose one more product? y/n");
                                orderEnd = input.next();
                                orderEnd = orderEnd.toUpperCase();
                                 if(orderEnd.equals("N")){
                                     tableproducts[chosenTable] = totalproduct; //tudo certo
                                     System.out.println("Products successfully added!");
                                 }
                            }while (orderEnd.equals("Y"));
                        } else if (table[chosenTable].equals("A") || table[chosenTable].equals("R")) {
                            System.out.println("Sorry, but this table is currently free or reserved!");
                        }
                    } else if (menuAnswer.equals("N")) {
                        System.out.println("Okay, feel free to ask for something!");
                    }
                    break;
                case 3:
                    System.out.println("Please enter your table!");
                    int chosenTable = input.nextInt();
                    if (table[chosenTable].equals("A") || table[chosenTable].equals("R")) {
                        System.out.println("This table is currently free/reserved");
                    } else if (table[chosenTable].equals("B")) {
                        if (tableproducts[chosenTable] == 0.0) {
                            System.out.println("You don't have any consumption, do you want to vacate the place anyway? y/n");
                            String vacateAnswer = input.next();
                            vacateAnswer = vacateAnswer.toUpperCase();
                            if (vacateAnswer.equals("Y")) {
                                table[chosenTable] = "A";
                                System.out.println("\n");
                                for (j = 0; j < 10; j++) {
                                    System.out.print("[" + table[j] + "]" + " ");
                                }
                            } else if (vacateAnswer.equals("N")) {
                                System.out.println("Consume more products and try again later!");
                            }
                        }
                        System.out.println("Account Total: " + tableproducts[chosenTable]);
                        System.out.println("Do you want to pay the 10% fee to the waiter?");
                        String rateAnswer10 = input.next();
                        rateAnswer10 = rateAnswer10.toUpperCase();
                        if (rateAnswer10.equals("Y")) {
                            double total = tableproducts[chosenTable];
                            double rate = 10.0 / 100.0;
                            double rateTotal = total + (rate * total);
                            System.out.println("Total with the rate of 10%: " + rateTotal);
                            System.out.println("Amount paid: ");
                            double amountPaid = input.nextDouble();
                             while(amountPaid < rateTotal){
                                 amountPaid = input.nextDouble();
                                System.out.println("Amount paid less than total!");
                            }
                            double thing = amountPaid - rateTotal;
                            System.out.println("Thing: " + thing);
                            System.out.println();
                            System.out.println("INVOICE\nTable: " + chosenTable);
                            for(z=0; z<count; z++){
                                System.out.print(consumedProducts[z][chosenTable] + "\n");
                            }
                            Invoice invoice = new Invoice(rateTotal, amountPaid, thing);
                            System.out.println(invoice);
                            totalWork += rateTotal;
                        } else if(rateAnswer10.equals("N")) {
                            System.out.println("Ok!");
                            double total = tableproducts[chosenTable];
                            double amountPaid = 0.0;
                            System.out.println("Amount paid: ");
                            amountPaid = input.nextDouble();
                            while (amountPaid < total){
                                amountPaid = input.nextDouble();
                                System.out.println("Amount paid less than total!");
                            };
                            double thing = amountPaid - total;
                            System.out.println("Thing: " + thing);
                            System.out.println();
                            System.out.println("INVOICE\nTable: " + chosenTable);
                            for(z=0; z<count; z++){
                                System.out.print(consumedProducts[z][chosenTable] + "\n");
                            }
                            Invoice invoice = new Invoice(total, amountPaid, thing);
                            System.out.println(invoice);
                            totalWork += total;
                            
                        }
                        System.out.println("\nThank you, and come back often!");
                        table[chosenTable] = "A";
                        System.out.println("\n");
                        for (j = 0; j < 10; j++) {
                            System.out.print("[" + table[j] + "]" + " ");
                        }
                        if (!(rateAnswer10.equals("Y") || rateAnswer10.equals("N"))) {
                            System.out.println("Invalid Answer!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("End of Work!");
                    System.out.println("Total Gain: " + totalWork);
            }
        }while(choice<4);
    }
}
