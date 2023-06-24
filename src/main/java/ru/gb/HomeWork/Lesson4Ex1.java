package ru.gb.HomeWork;

import java.util.Scanner;

public class Lesson4Ex1 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите элементы списка через символ '->': ");
        String input = scanner.nextLine();

        Node head = buildList(input);
        Node reversedHead = reverseList(head);
        printList(reversedHead);
    }

    public static Node buildList(String input) {
        String[] elements = input.split("->");
        Node head = null;
        Node current = null;

        for (String element : elements) {
            int value = Integer.parseInt(element.trim());
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        return head;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
    }
}
