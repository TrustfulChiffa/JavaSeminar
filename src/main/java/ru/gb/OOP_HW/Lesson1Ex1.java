package ru.gb.OOP_HW;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int rating;

    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}

interface ProductContainer {
    void addProduct(Product product);
    void removeProduct(Product product);
}

class Category implements ProductContainer {
    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}

class Basket implements ProductContainer {
    private List<Product> purchasedProducts;

    public Basket() {
        this.purchasedProducts = new ArrayList<>();
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    @Override
    public void addProduct(Product product) {
        purchasedProducts.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        purchasedProducts.remove(product);
    }
}

class User {
    private String login;
    private String password;
    private Basket basket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }
}

class Lesson1Ex1 {
    public static void main(String[] args) {
        // Создание продуктов
        Product product1 = new Product("Product 1", 10.0, 5);
        Product product2 = new Product("Product 2", 20.0, 4);
        Product product3 = new Product("Product 3", 30.0, 3);

        // Создание категорий
        Category category1 = new Category("Category 1");
        category1.addProduct(product1);
        category1.addProduct(product2);

        Category category2 = new Category("Category 2");
        category2.addProduct(product3);

        // Создание пользователей
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Добавление продуктов в корзину пользователей
        user1.getBasket().addProduct(product1);
        user2.getBasket().addProduct(product2);

        // Вывод каталога продуктов
        System.out.println("Каталог продуктов:");
        System.out.println("---------------");
        System.out.println("Категория: " + category1.getName());
        for (Product product : category1.getProducts()) {
            System.out.println("Название: " + product.getName());
            System.out.println("Цена: " + product.getPrice());
            System.out.println("Рейтинг: " + product.getRating());
            System.out.println("---------------");
        }

        System.out.println("Категория: " + category2.getName());
        for (Product product : category2.getProducts()) {
            System.out.println("Название: " + product.getName());
            System.out.println("Цена: " + product.getPrice());
            System.out.println("Рейтинг: " + product.getRating());
            System.out.println("---------------");
        }

        // Вывод покупок пользователей
        System.out.println("Покупки пользователей:");
        System.out.println("---------------");
        System.out.println("Пользователь: " + user1.getLogin());
        for (Product product : user1.getBasket().getPurchasedProducts()) {
            System.out.println("Название: " + product.getName());
            System.out.println("Цена: " + product.getPrice());
            System.out.println("Рейтинг: " + product.getRating());
            System.out.println("---------------");
        }

        System.out.println("Пользователь: " + user2.getLogin());
        for (Product product : user2.getBasket().getPurchasedProducts()) {
            System.out.println("Название: " + product.getName());
            System.out.println("Цена: " + product.getPrice());
            System.out.println("Рейтинг: " + product.getRating());
            System.out.println("---------------");
        }
    }
}
