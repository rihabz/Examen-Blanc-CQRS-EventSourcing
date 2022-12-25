package ma.enset.commonapi.events;

import lombok.Getter;

@Getter
public class VehiculeCreatedEvent extends BaseEvent<String> {
    private String marque;
    private String modele;
    private String matricule;
    private String puissanceFiscale;
    private String proprietaireId;

    public VehiculeCreatedEvent(String id, String marque, String modele, String matricule, String puissanceFiscale, String proprietaireId) {
        super(id);
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.puissanceFiscale = puissanceFiscale;
        this.proprietaireId = proprietaireId;
    }
}
