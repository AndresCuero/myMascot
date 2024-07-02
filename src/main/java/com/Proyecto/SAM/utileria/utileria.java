
package com.Proyecto.SAM.utileria;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import java.util.Random;


public class utileria {
    
           public static String guardarArchivo(MultipartFile multiPart, String ruta) {
// Obtenemos el nombre original del archivo.
            String nombreOriginal = multiPart.getOriginalFilename();
            nombreOriginal = nombreOriginal.replace(" ", "-"); 
            String nombreImgRandom = palabraRandom8Caracteres()+nombreOriginal;
      

           

            try {
// Formamos el nombre del archivo para guardarlo en el disco duro.
                File imageFile = new File(ruta + nombreImgRandom);
                System.out.println("Archivo: " + imageFile.getAbsolutePath());
//Guardamos fisicamente el archivo en HD.
                multiPart.transferTo(imageFile);
                return nombreImgRandom;
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
                return null;
            }
        }
  
      // Este metodo me retorna un palabra comformada por 8 carateres random
 public static String palabraRandom8Caracteres() {
        String caracteres = "123456789abcdefghijklmnñopqrstuvwxyz";
        String palabraRandom="";
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            palabraRandom += caracteres.charAt(index);
        }

        return palabraRandom;
    }      
           
           
    
}


