package MyClass;

import Entity.Buyer;
import Entity.Product;
import Entity.History;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    private Product[] products;
    private Buyer[] buyers;
    private History[] histories;
    private History history;


    public App() {
    }

    public void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        histories = new History[0];

        do {
            System.out.println(" ");
            System.out.println("Программа магизина");
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить товар");
            System.out.println("2. Добавить покупателя");
            System.out.println("3. Выдать товар");
            System.out.println("4. Вывод всех товаров");
            System.out.println("5. Вывод всех покупателей");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            int numberBuyer = 0;
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавление товара");
                    System.out.println("Введите название товара: ");
                    String productName = scanner.nextLine();
                    System.out.println("Введите колл-во товара: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите название производителя");
                    String manufacturerName = scanner.nextLine();
                    Product product = createProduct(productName, quantity, manufacturerName);
                    Product[] newProducts = new Product[products.length + 1];
                    newProducts[newProducts.length - 1] = product;
                    this.products = newProducts;
                    break;

                case 2:
                    System.out.println("Добваление покупателя");
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите фамилию: ");
                    String lastname = scanner.nextLine();
                    System.out.println("Введите номер телефона: ");
                    int phone = scanner.nextInt();
                    Buyer buyer = createBuyer(name, lastname, String.valueOf(phone));
                    Buyer[] newBuyer = new Buyer[buyers.length + 1];
                    newBuyer[newBuyer.length - 1] = buyer;
                    this.buyers = newBuyer;
                    break;
                case 3:
                    System.out.println("Выдать товар");
                    for (int i = 0; i < buyers.length; i++) {
                        System.out.printf(i + 1 + ". " + buyers[i].getFirstname() + ". " + buyers[i].getLastname() + ". ");
                    }
                    System.out.print("Выбери покупателя: ");
                    numberBuyer = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Список товаров: ");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println(i + 1 + ". " + products[i].productName() + ". " + products[i] + ". " + ". " + products[i].manufacturer());
                    }
                    System.out.println();
            }
            System.out.print("Выберите номер книги: ");
            int numberProducts = scanner.nextInt();
            scanner.nextLine();
            history = new History();
            history.setProduct(products[numberProducts - 1]);
            history.setBuyer(buyers[numberBuyer - 1]);
            history.setTakeOnBook(new GregorianCalendar().getTime());
            History[] newHistories = new History[this.histories.length + 1];
            newHistories[newHistories.length - 1] = history;
            this.histories = newHistories;
            System.out.println(history);
            break;

        } while (repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    public Product createProduct(String productName, int quantity, String manufacturerName){
        Product product = new Product();
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setManufacturer(manufacturerName);
        return product;
    }
    public Buyer createBuyer(String name, String lastname, String phone){
        Buyer buyer = new Buyer();
        buyer.setFirstname(name);
        buyer.setLastname(lastname);
        buyer.setPhone(Integer.parseInt(phone));
        return buyer;
    }
}