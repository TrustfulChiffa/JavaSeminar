package ru.gb.OOP_HW;

import java.util.ArrayList;
import java.util.List;

// Класс, представляющий товар
class Product {
    private String name; // Имя товара
    private double price; // Цена товара
    private int rating; // Рейтинг товара

    // Конструктор класса
    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    // Геттеры для получения значений переменных товара
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

// Интерфейс, определяющий контейнер для товаров
interface ProductContainer {
    void addProduct(Product product); // Метод для добавления товара в контейнер
    void removeProduct(Product product); // Метод для удаления товара из контейнера
}

// Класс, представляющий категорию товаров
class Category implements ProductContainer {
    private String name; // Имя категории
    private List<Product> products; // Массив товаров в категории

    // Конструктор класса
    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>(); // Инициализация массива товаров
    }

    // Геттер для получения имени категории
    public String getName() {
        return name;
    }

    // Геттер для получения списка товаров в категории
    public List<Product> getProducts() {
        return products;
    }

    // Реализация метода добавления товара в контейнер
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    // Реализация метода удаления товара из контейнера
    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}

// Класс, представляющий корзину с товарами
class Basket implements ProductContainer {
    private List<Product> purchasedProducts; // Массив купленных товаров

    // Конструктор класса
    public Basket() {
        this.purchasedProducts = new ArrayList<>(); // Инициализация массива купленных товаров
    }

    // Геттер для получения списка купленных товаров
    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    // Реализация метода добавления товара в контейнер
    @Override
    public void addProduct(Product product) {
        purchasedProducts.add(product);
    }

    // Реализация метода удаления товара из контейнера
    @Override
    public void removeProduct(Product product) {
        purchasedProducts.remove(product);
    }
}

// Класс, представляющий пользователя
class User {
    private String login; // Логин пользователя
    private String password; // Пароль пользователя
    private Basket basket; // Корзина пользователя

    // Конструктор класса
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket(); // Инициализация корзины пользователя
    }

    // Геттеры для получения значений переменных пользователя
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

// Главный класс приложения
public class Lesson1Ex1 {
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
