package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="t_orders")
public class Order {

    @Id @GeneratedValue 
    @Column(name="order_id")
    private int ID;

    @OneToOne
    @JoinColumn(name="ord_wizard")
    private Wizard wizard;

    @OneToOne
    @JoinColumn(name="ord_item")
    private MagicalItem item;

    public int getId() {
        return ID;
    }   

    public Wizard getWizard(){
        return wizard;
    }
    public MagicalItem getItem(){
        return item;
    }
    public Order(){
    }

    public Order( Wizard wizard, MagicalItem item){
        this.wizard = wizard;
        this.item = item;
    }
    @Override 
    public String toString(){
        return this.getWizard().getName() + " " + this.getItem().getName();
    }
}
