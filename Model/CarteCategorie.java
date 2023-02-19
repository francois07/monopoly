package Model;

public enum CarteCategorie {
  CARTE_PROXIMITE("Carte Proximité"),
  CARTE_TELEPORTATION("Carte Téléportation"),
  CARTE_SORTIE_PRISON("Carte Sortie Prison"),
  CARTE_MOUVEMENT("Carte Mouvement"),
  CARTE_ARGENT("Carte Argent");

  private String nom;

  CarteCategorie(String nom) {
    this.nom = nom;
  }

  public String toString() {
    return this.nom;
  }
}
