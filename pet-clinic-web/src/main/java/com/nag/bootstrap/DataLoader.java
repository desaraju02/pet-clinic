package com.nag.bootstrap;

import com.nag.model.*;
import com.nag.services.OwnerService;
import com.nag.services.PetTypeService;
import com.nag.services.SpecialityService;
import com.nag.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0)
         loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog 1");

        PetType dog2 = new PetType();
        dog2.setName("Dog 2");

        PetType savedDogType = petTypeService.save(dog);
        PetType save2ndDogType = petTypeService.save(dog2);


        Speciality radiology = new Speciality();
        radiology.setDescription("This is Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("This is Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        System.out.println("PetTypes loaded: ");
        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Naren");
        owner1.setLastName("Narendra");
        owner1.setAddress("ABCD Road");
        owner1.setCity("New Delhi");
        owner1.setTelephone("1234567890");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setName("uffff");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);

        owner1.getPets().add(pet1);


        ownerService.save(owner1);

        System.out.println("Loaded - Owners");
        Owner owner11 = new Owner();
        //owner11.setId(2L);
        owner11.setFirstName("Naren11");
        owner11.setLastName("Narendra11");
        owner11.setAddress("ASDF Road");
        owner11.setCity("New Delhi");
        owner11.setTelephone("1234567890");


        Pet pet11 = new Pet();
        pet11.setPetType(save2ndDogType);
        pet11.setName("uffff 11");
        pet11.setBirthDate(LocalDate.now());
        pet11.setOwner(owner11);
        owner11.getPets().add(pet11);

        ownerService.save(owner11);

        System.out.println("Loaded - Owners - 11");

        Vet vet1 = new Vet();
        // vet1.setId(1L);
        vet1.setFirstName("Naren - Vet1");
        vet1.setLastName("Narendra - Vet1");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet11 = new Vet();
        // vet11.setId(2L);
        vet11.setFirstName("Naren - Vet11");
        vet11.setLastName("Narendra - Vet11");
        vet11.getSpecialities().add(surgery);
        vet11.getSpecialities().add(radiology);
        vetService.save(vet11);
        System.out.println("Loaded - Vets");
    }
}
