package com.bonsai_gardener.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class ImageUtil {

    /**
     * Extracts the file name from a Part header.
     */
    public String getImageNameFromPart(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String s : contentDisp.split(";")) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "default.png";
    }

    /**
     * Uploads the image to a specific permanent location.
     * 
     * @param part       - the image file part from form
     * @param saveFolder - sub-folder name (e.g., "products")
     * @return image name if upload is successful, null otherwise
     */
    public String uploadImage(Part part, String folder, HttpServletRequest request) {
        String imageName = UUID.randomUUID().toString() + "_" + getImageNameFromPart(part);
        String saveDirectory = request.getServletContext().getRealPath("/images/" + folder);

        File dir = new File(saveDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            String filePath = saveDirectory + File.separator + imageName;
            part.write(filePath);  // Save image
            System.out.println("✅ Saved image at: " + filePath);
            return "/images/" + folder + "/" + imageName; // ✅ Save this in DB
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the absolute path to save the file permanently.
     * Example:  "C:/Users/prati/git/bonsaigardener/bonsai_gardener/webapp/images"
     */
    public String getSavePath(String saveFolder) {
        return  "C:/Users/prati/git/bonsaigardener/bonsai_gardener_main/webapp/images" + saveFolder;
        
    }
}
