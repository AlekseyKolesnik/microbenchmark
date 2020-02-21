package com.kolesnik.generators;

import static com.kolesnik.constants.GeneratingConstants.HEIGHT;
import static com.kolesnik.constants.GeneratingConstants.URL;
import static com.kolesnik.constants.GeneratingConstants.WIDTH;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.glxn.qrgen.javase.QRCode;

public class QRGen {


    public static ByteArrayOutputStream generateQRCodeImage(String text, int width, int height) {
        return QRCode.from(text).withSize(width, height).stream();
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream pngOutputStream = generateQRCodeImage(URL, WIDTH, HEIGHT);
        try (OutputStream outputStream = new FileOutputStream("QRGen.png")) {
            pngOutputStream.writeTo(outputStream);
        }
    }
}
