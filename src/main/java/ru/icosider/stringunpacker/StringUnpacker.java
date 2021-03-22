package ru.icosider.stringunpacker;

import ru.icosider.stringunpacker.service.UnpackService;

import java.util.Scanner;

public class StringUnpacker {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.println("Write a text for unpack:");
            final UnpackService service = new UnpackService(scanner.nextLine()).validate();
            System.out.println(service.parse());
        } catch (Throwable e) {
            System.err.println(e.getMessage());
        }
    }
}