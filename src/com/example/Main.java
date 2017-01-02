package com.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    static Queue<Ticket> ticketQueue = new LinkedList<>();
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        //addTickets();
        //System.out.println(ticketQueue);
        //removeTicket();
        //System.out.println(ticketQueue);

        while (true) {
            addTickets();
            System.out.println("New Tickets" + ticketQueue);
            Thread.sleep(900l);
            removeTicket();
            System.out.println(ticketQueue);
            Thread.sleep(900l);
        }
    }

    private static void addTickets() {
        int count = random.nextInt(10);

        for (int i = 1; i < count; i++) {
            Ticket ticket = new Ticket();
            ticket.setName("" + System.currentTimeMillis());
            ticket.setPriority(random.nextInt(10));
            ticketQueue.add(ticket);

        }

    }

    private static void removeTicket() {
        if (ticketQueue.peek() != null) {
            int count = random.nextInt(10);
            Iterator<Ticket> iterator = ticketQueue.iterator();
            for (int i = 1; i < count; i++) {
                if (iterator.hasNext()) {
                    Ticket next = iterator.next();
                    iterator.remove();
                    System.out.println("removed " + next);
                }
            }
        }
    }
}
