public class Exemplaire {

  private int id;
  private int idLivre;
  private int idUtilisateur;
  private String date;
  private String titre;
  private String auteur;
  private String editeur;
  private String pseudo;
  private String type;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdLivre() {
    return idLivre;
  }

  public void setIdLivre(int idLivre) {
    this.idLivre = idLivre;
  }

  public int getIdUtilisateur() {
    return idUtilisateur;
  }

  public void setIdUtilisateur(int idUtilisateur) {
    this.idUtilisateur = idUtilisateur;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getAuteur() {
    return auteur;
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }

  public String getEditeur() {
    return editeur;
  }

  public void setEditeur(String editeur) {
    this.editeur = editeur;
  }

  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
