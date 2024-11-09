package io;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Resources {
    private static final String[] EXPECTED_IMAGES = {"sprite.png"};
    private static HashMap<String,Image> imageResources = new HashMap<String,Image>();

    public static void loadImage(String imageName) {
        try {
            File file = new File(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "images" + File.separator + imageName);
            BufferedImage image = ImageIO.read(file);
            imageResources.put(imageName, image);
        } catch (IOException e) {
            System.out.println(imageName + " failed to load");
        }
        catch(NullPointerException e){
            System.out.println("Error processing " + imageName);
        }
    }

    public static void loadImage(String imageName, int width, int height){
        loadImage(imageName);
        imageResources.put(imageName, imageResources.get(imageName).getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    //Temporary. WIll change if specifics are needed.
    public static void loadAllImages() {
        for (String string : EXPECTED_IMAGES) {
            loadImage(string,100,100);
        }
    }

    public static Image getImage(String imageName) {
        return imageResources.get(imageName);
    }
}
