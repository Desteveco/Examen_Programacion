package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


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



}
