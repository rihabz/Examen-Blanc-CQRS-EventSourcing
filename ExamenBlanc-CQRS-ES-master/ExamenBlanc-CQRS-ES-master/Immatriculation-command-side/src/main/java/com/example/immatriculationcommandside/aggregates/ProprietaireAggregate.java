package com.example.immatriculationcommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateProprietaireCommand;
import org.sid.coreapi.commands.CreateRadarCommand;
import org.sid.coreapi.commands.UpdateProprietaireCommand;
import org.sid.coreapi.events.CreatedProprietaireEvent;
import org.sid.coreapi.events.RadarCreatedEvent;
import org.sid.coreapi.events.UpdatedProprietaireEvent;

import java.util.Date;

@Slf4j
@Aggregate
public class ProprietaireAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private Date dateNaissance;
    private String email;

    public ProprietaireAggregate(){}

    @CommandHandler
    public ProprietaireAggregate(CreateProprietaireCommand createProprietaireCommand){
        log.info("creat radar command ***********");

        AggregateLifecycle.apply(new CreatedProprietaireEvent(
                createProprietaireCommand.getId(),
                createProprietaireCommand.getNom(),
                createProprietaireCommand.getDateNaissance(),
                createProprietaireCommand.getEmail()
        ));
    }


    @EventSourcingHandler
    public void on(CreatedProprietaireEvent createdProprietaireEvent){
        log.info("creat createdProprietaireEvent event ***********");
        this.id=createdProprietaireEvent.getId();
        this.dateNaissance=createdProprietaireEvent.getDateNaissance();
        this.nom=createdProprietaireEvent.getNom();
        this.email=createdProprietaireEvent.getEmail();
    }



    @CommandHandler
    public ProprietaireAggregate(UpdateProprietaireCommand updateProprietaireCommand){
        log.info("creat radar command ***********");
        AggregateLifecycle.apply(new UpdatedProprietaireEvent(
                updateProprietaireCommand.getId(),
                updateProprietaireCommand.getNom(),
                updateProprietaireCommand.getDateNaissance(),
                updateProprietaireCommand.getEmail()
        ));
    }


    @EventSourcingHandler
    public void on(UpdatedProprietaireEvent updatedProprietaireEvent){
        this.id=updatedProprietaireEvent.getId();
        this.dateNaissance=updatedProprietaireEvent.getDateNaissance();
        this.nom=updatedProprietaireEvent.getNom();
        this.email=updatedProprietaireEvent.getEmail();
    }



}
