package edu.badpals.domain;

import jakarta.persistence.*;
    @Entity
    @Table(name="t_wizards")
    public class Wizard {
    
        @Id 
        @Column(name="wizard_name")
        private String name;
    
        @Column(name="wizard_dexterity")
        private int dexterity;

        @Column(name="wizard_person")
        @Enumerated(EnumType.STRING)
        private WizardType person;
        

        public String getName(){
            return name;
        }
        public WizardType getPerson(){
            return person;
            }

        public int getDexterity(){
            return dexterity;
            }

        public WizardType setPerson(WizardType person){
            return this.person = person;
        }

        public int setDexterity(int dexterity){
            return this.dexterity = dexterity;
        }

        public Wizard(){
        }

        @Override
        public String toString(){
        return this.getName() + " " + this.getDexterity() + " " + this.getPerson();
        }
    }

