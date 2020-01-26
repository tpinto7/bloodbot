import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Pic
{
  BufferedImage image;

  public Pic(String pic_name) throws IOException { //constructor
    File file = new File(pic_name);
    image = ImageIO.read(file); //picture passed as parameter and stored
  }

  public double getSaturation(){
    int rgb=0, r=0,g=0,b=0;
    double white=0.0, red=0.0; //counters to keep track of red pixels and white pixels
    float hsb[], deg;

    for(int x=0; x<image.getWidth(); x++){ //nested for loop loops through every pixel
      for(int y=0; y<image.getHeight(); y++){
        rgb =  image.getRGB(x,y); //get current RGB level at specific position
        hsb = new float[3]; //will contain the hue, saturation, and brightness values
        r = (rgb >> 16) & 0xFF;
        g = (rgb >>  8) & 0xFF;
        b = (rgb      ) & 0xFF;
        Color.RGBtoHSB(r, g, b, hsb); //converts to a hue instead of RGB value

        if(hsb[1] < 0.1 && hsb[2]>0.9) { white++; } //saturation & brightness can detect pixels that are nearly white
        else{
          deg = hsb[0]*360; //hue multiplied by 360 gives the tone of the colour
          if((deg>=0 && deg<30) || (deg>=330 && deg<=360)) { //counts red pixels on the hue scale
            //red++;
            if(hsb[2]>0.5) { red++; } //for high saturation level
            else { red += 0.5; white += 0.5; } //doesn't add as much if the hue has a lower saturation level - not as soaked
          }
        }
      }
    }
    return red/(red+white); //outputs proportion of red pixels compared to total pixels of sponge
  }
}
