package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="t_items")
public class MagicalItem {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="item_id")
    private int ID;

    @Column(name="item_name")
    private String name;

    @Column(name="item_quality")
    private int quality;

    @Column(name="item_type")
    private String type;

    public int getId() {
        return ID;
    }

    public String getName(){
        return name;
    }
    public int getQuality(){
        return quality;
    }
    public String getType(){
        return type;
    }

    public int getIdFromName(String name){
        return ID;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getQuality() + " " + this.getType();
    }
}
