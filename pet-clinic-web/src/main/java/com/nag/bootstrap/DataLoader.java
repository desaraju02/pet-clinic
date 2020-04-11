package com.nag.bootstrap;

import com.nag.model.Owner;
import com.nag.model.Vet;
import com.nag.services.OwnerService;
import com.nag.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Naren");
        owner1.setLastName("Narendra");

        ownerService.save(owner1);

        System.out.println("Loaded - Owners");
        Owner owner11 = new Owner();
        //owner11.setId(2L);
        owner11.setFirstName("Naren11");
        owner11.setLastName("Narendra11");

        ownerService.save(owner11);

        System.out.println("Loaded - Owners - 11");

        Vet vet1 = new Vet();
       // vet1.setId(1L);
        vet1.setFirstName("Naren - Vet1");
        vet1.setLastName("Narendra - Vet1");

        vetService.save(vet1);

        Vet vet11 = new Vet();
       // vet11.setId(2L);
        vet11.setFirstName("Naren - Vet11");
        vet11.setLastName("Narendra - Vet11");

        vetService.save(vet11);
        System.out.println("Loaded - Vets");
    }
}
