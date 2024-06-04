package edu.badpals.domain;

import jakarta.persistence.*;
    @Entity
    @Table(name="t_wizards")
    public class Wizard {
    
        @Id 
        @Column(name="wiz_name")
        private String name;
    
        @Column(name="wiz_dexterity")
        private int dexterity;

        @Column(name="wiz_person")
        private String person;
        

        public String getName(){
            return name;
        }
        public String getPerson(){
            return person;
            }

        public int getDexterity(){
            return dexterity;
            }

        public String setPerson(String person){
            return this.person = person;
        }

        public int setDexterity(int dexterity){
            return this.dexterity = dexterity;
        }

        public Wizard(){
        }

        @Override
        public String toString(){
        return this.getName() + " " + this.getDexterity();
        }
    }

