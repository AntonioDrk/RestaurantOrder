package com.bigrestaurant.fmi.services;

import com.bigrestaurant.fmi.model.Item;
import com.bigrestaurant.fmi.model.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class InterogationService {

    private static InterogationService myInstance = new InterogationService();

    public static InterogationService getInstance() {
        return myInstance;
    }

    private InterogationService(){}

    public void startUserInterface(){


        Boolean exit = false;
        String options = "[1] Display menu items\n" +
                         "[2] Display orders\n" +
                         "[3] Display price of orders\n" +
                         "[4] Place order\n" +
                         "[5] Exit\n";

        while(!exit){
            System.out.println(options);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your option: ");
            Integer choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    // Display all the menu items
                    AuditService.getInstance().logAction("Display menu items");
                    Menu.getInstance().displayItems();
                    break;
                case 2:
                    // Display all the orders
                    AuditService.getInstance().logAction("Display orders");
                    OrderService.getInstance().displayOrders();
                    break;
                case 3:
                    // Cost of a specific order
                    AuditService.getInstance().logAction("Display price of orders");
                    System.out.print("Number of the order to check price: ");
                    Integer noOrder = Integer.parseInt(scanner.nextLine());
                    OrderService.getInstance().displayCostOfOrder(noOrder);
                    break;
                case 4:
                    // Place an order
                    AuditService.getInstance().logAction("Place order");
                    ArrayList<Item> itemsToOrder = new ArrayList<>();
                    Boolean exitOrder = false;
                    while (!exitOrder){
                        System.out.println("[1] Add an item to the current order\n" +
                                "[2] Remove an item from the current order\n" +
                                "[3] Finish order");
                        Integer optionsOrder = Integer.parseInt(scanner.nextLine());
                        switch (optionsOrder){
                            case 1:
                                System.out.println("Type the number of the item from the menu you want to order: ");
                                Integer itemIndex = Integer.parseInt(scanner.nextLine());
                                if(itemIndex - 1 < Menu.getInstance().getMenuList().size()){
                                    itemsToOrder.add(Menu.getInstance().getMenuList().get(itemIndex - 1));
                                }else{
                                    System.out.println("The index you entered is out of bounds, try again.");
                                }
                                break;
                            case 2:
                                System.out.println("Type in the index of the item you want to" +
                                        " be removed, range is 1 - " + (itemsToOrder.size()));
                                Integer indexToRemove = Integer.parseInt(scanner.nextLine());
                                indexToRemove -= 1;
                                if(indexToRemove >= itemsToOrder.size() || indexToRemove < 0){
                                    System.out.println("Index out of bounds, try again.");
                                }
                                itemsToOrder.remove(indexToRemove);
                                break;
                            case 3:
                                if(itemsToOrder.size() > 0)
                                    OrderService.getInstance().placeOrder(itemsToOrder);
                                exitOrder = true;
                                break;
                        }
                    }
                    break;
                case 5:
                    AuditService.getInstance().logAction("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println("Option doesn't exist, please try again");
                    break;
            }
        }
    }
}
