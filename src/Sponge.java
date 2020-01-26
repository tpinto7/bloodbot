public class Sponge {
  private double saturation;
  private static double volume=0; //total blood volume
  private static int sponges=0; //keep track of sponge count

  public static String getVolume() {
	  return ""+(int)volume;
  }
  
  public static String getSponges() {
	  return ""+sponges;
  }
  
  public Sponge(double sat) {
    this.saturation = sat; //passed using pixel analyzer class
    sponges++;
  }

  public void addVolume(){
    //volume capacity data from NCBI journal article study https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5003499/

    volume += 100*saturation; //for a 30 by 30 cm sponge
    //volume += 160*saturation; //for a 45 by 45 cm sponge
    //volume += 12*saturation; //for a 10 by 10 cm sponge
  }
}