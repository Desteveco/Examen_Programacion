package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name="t_items")
public class MagicalItem {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="item_id")
    private int ID;

    @Column(name="item_name")
    private String name;

    @Column(name="item_quality")
    private int quality;

    @Column(name="item_type")
    private String type;

    public MagicalItem(){}

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

    public  MagicalItem(String name, int quality, String type){
        this.name = name;
        this.quality = quality;
        this.type = type;
    }
    
    public int getIdFromName(String name){
        return ID;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getQuality() + " " + this.getType();
    }
}
