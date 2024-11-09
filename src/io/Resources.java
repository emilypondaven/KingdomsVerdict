package io;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Resources {
    private static HashMap<String,BufferedImage> imageResources = new HashMap<String,BufferedImage>();

    public static void loadImage(String imageName) {
        try {
            File file = new File(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "images" + File.separator + imageName);
            BufferedImage image = ImageIO.read(file);
            imageResources.put(imageName, image);
            System.out.println(imageName + " loaded");
        } catch (IOException e) {
            System.out.println(imageName + " failed to load");
        }
        catch(NullPointerException e){
            System.out.println("Error processing " + imageName);
        }
    }

    public static void loadImage(String imageName, int width, int height){
        loadImage(imageName);
        imageResources.put(imageName, convertToBufferedImage(imageResources.get(imageName).getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }

    //Temporary. WIll change if specifics are needed.
    public static void loadAllSprites() {
        File imageDir = new File(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "images");
        imageDir.mkdir();
        for (File file : imageDir.listFiles()) {
            loadImage(file.getName());
        }
    }

    public static BufferedImage getImage(String imageName) {
        return imageResources.get(imageName);
    }

    public static BufferedImage convertToBufferedImage(Image image) {
        // Create a BufferedImage with the same dimensions as the original image
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }
}
