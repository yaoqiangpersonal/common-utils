package com.yq.blueray.utils;

import net.coobird.thumbnailator.Thumbnails;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yq
 * @Date: 2018-10-15 12:24
 * @Description:
 */
public class ImageUtil {

    public static void to(File file,int width,int heigth,String format,File toFile) throws Exception{

        if (file.isDirectory() && toFile.isDirectory()) {
            batch(file,width,heigth,format,toFile);
        }else{
            single(file,width,heigth,format,toFile);
        }
    }

    private static void batch(File file,int width,int heigth,String format,File toFile) throws Exception{
        List<File> sourceList = Arrays.asList(file.listFiles());
        List<File> destList = new ArrayList<>();
        sourceList.forEach(f->destList.add(new File(toFile,f.getName().substring(0,f.getName().lastIndexOf(".")))));
        Thumbnails.fromFiles(sourceList)
                .size(width, heigth)
                .outputFormat(format)
                .toFiles(destList);
    }

    private static void single(File file,int width,int heigth,String format,File toFile)throws Exception{
        Thumbnails.of(file).size(width,heigth).outputFormat(format).toFile(toFile);
    }
}
