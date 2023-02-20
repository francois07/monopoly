package Model;

import java.util.List;

public class Gare extends Propriete {
  public Gare(final String nom, final int prix, final int loyer[]) {
    super(nom, new int[] { prix }, loyer);
  }

  @Override
  public int getLoyer() {
    List<Propriete> proprietes = this.getProprietaire().getProprietes();
    int count = (int) proprietes.stream().filter(c -> (c instanceof Gare)).count();
    return this.loyer[count - 1];
  }
}
