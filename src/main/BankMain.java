package main;

import java.util.Scanner;
import model.Account;
import service.Service;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        while (true) {
            System.out.println("\n----- Bank Management Menu -----");
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    Account newAcc = new Account(accNum, name, balance);
                    service.saveAccountRecords(newAcc);
                    break;

                case 2:
                    System.out.print("Enter Account Number to search: ");
                    String searchAcc = sc.nextLine();
                    service.searchRecord(searchAcc);
                    break;

                case 3:
                    System.out.print("Enter Account Number to update: ");
                    String updateAcc = sc.nextLine();
                    System.out.print("Enter New Customer Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Balance: ");
                    double newBal = sc.nextDouble();

                    Account updatedAcc = new Account(updateAcc, newName, newBal);
                    service.updateRecord(updatedAcc);
                    break;

                case 4:
                    System.out.print("Enter Account Number to delete: ");
                    String deleteAcc = sc.nextLine();
                    service.deleteRecord(deleteAcc);
                    break;

                case 5:
                    service.getAllRecords(); 
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank App!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
