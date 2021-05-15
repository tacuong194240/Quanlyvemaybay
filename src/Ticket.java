
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Ticket {
    int id;
    private String type;
    private String landPlace;
    private String flyPlace;
    private int price;
    private Date soldTime;
    private Date flyTime;
    private Date landTime;
    private String ticketID;

    public Ticket(int id, String type, String landPlace, String flyPlace, int price, Date soldTime, Date flyTime, Date landTime, String ticketID) {
        this.id = id;
        this.type = type;
        this.landPlace = landPlace;
        this.flyPlace = flyPlace;
        this.price = price;
        this.soldTime = soldTime;
        this.flyTime = flyTime;
        this.landTime = landTime;
        this.ticketID = ticketID;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLandPlace() {
        return landPlace;
    }

    public void setLandPlace(String landPlace) {
        this.landPlace = landPlace;
    }

    public String getFlyPlace() {
        return flyPlace;
    }

    public void setFlyPlace(String flyPlace) {
        this.flyPlace = flyPlace;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Date soldTime) {
        this.soldTime = soldTime;
    }

    public Date getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(Date flyTime) {
        this.flyTime = flyTime;
    }

    public Date getLandTime() {
        return landTime;
    }

    public void setLandTime(Date landTime) {
        this.landTime = landTime;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
   
}
