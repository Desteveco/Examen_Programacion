package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.domain.WizardType;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class Repositorio {


        @Inject
        WizardRepository wizardRepo;

        @Inject
        MagicalItemRepository magicalItemRepo;

        @Inject
        OrderRepository orderRepo;

        public Repositorio(){}

        public Optional<Wizard> loadWizard(String name) {
                Optional<Wizard> wizard = wizardRepo.findByIdOptional(name);
                return Optional.ofNullable(wizard.isPresent() ? wizard.get() : null);
        }

        public Optional<MagicalItem> loadItem(String name) {
                Optional<MagicalItem> item = magicalItemRepo.findByUserName(name);
                return Optional.ofNullable(item.isPresent() ? item.get() : null);
        }

        public Optional<MagicalItem> loadItem(MagicalItem MagicItem) {
                List <MagicalItem> items = loadItems(MagicItem.getName());
                for (MagicalItem item : items){
                        if (item.getName().equals(MagicItem.getName())
                                && item.getQuality() == MagicItem.getQuality()
                                && item.getType().equals(MagicItem.getType())){
                                return Optional.ofNullable(item);
                        }
                }
                return Optional.ofNullable(null);
        }

        public List<MagicalItem> loadItems(String name) {
                return this.magicalItemRepo.list("name", name);
        }
        @Transactional
        public Optional<Order> placeOrder(String wizardname, String itemname){
                Optional<Wizard> wizard = loadWizard(wizardname);
                Optional<MagicalItem> item = loadItem(itemname);
                if (wizard.isPresent() && item.isPresent() && !wizard.get().getPerson().equals(WizardType.MUDBLOOD) ){
                        Order order = new Order(wizard.get(), item.get());
                        orderRepo.persist(order);
                        return Optional.ofNullable(order);
                }
                return Optional.ofNullable(null);
        }

        @Transactional
        public void createItem(String name, int quality, String type){
                MagicalItem item = new MagicalItem(name, quality, type);
                magicalItemRepo.persist(item);
        }

        @Transactional
        public void createItems(List<MagicalItem> items){
                for (MagicalItem item: items ){
                        createItem(item.getName(), item.getQuality(),item.getType());
                }
        }

        @Transactional
        public void deleteItem(MagicalItem item){
                Optional<MagicalItem> itemToDelete = loadItem(item);
                if (itemToDelete.isPresent()){
                        this.magicalItemRepo.delete(itemToDelete.get());
                }
        }
}
