// Classe qui vérifie la validité d'une entrée dans la base
public class StringValidation {

  // Méthode qui double les appostrophes et vérifie si la taille est inferieur à
  // la taille limite, retourne null dans le cas d'une chaine invalide
  public String valider(String chaine, int charMin, int charMax) {
    chaine = chaine.replace("'", "''");

    if (chaine .length() < charMin || chaine.length() >= charMax) {
      chaine = null;
    }
    return chaine;
  }
}
