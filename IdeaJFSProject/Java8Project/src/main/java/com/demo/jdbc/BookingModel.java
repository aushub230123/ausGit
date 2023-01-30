package com.demo.jdbc;

public class BookingModel {
    private int bookingId;
    private String source;
    private String destination;

    public BookingModel() {
    }

    public BookingModel(int bookingId, String source, String destination) {
        this.bookingId = bookingId;
        this.source = source;
        this.destination = destination;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "bookingId=" + bookingId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}