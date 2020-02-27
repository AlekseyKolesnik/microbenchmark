package com.kolesnik.generators;

import static com.kolesnik.constants.GeneratingConstants.URL;

import io.nayuki.qrcodegen.QrCode;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QRCodeGenerator {

    public static BufferedImage generateQRCodeImage(String text) {
        QrCode qrCode = QrCode.encodeText(text, QrCode.Ecc.LOW);
        return  qrCode.toImage(9, 5);
    }


    public static ByteArrayOutputStream generateQRCodeStream(String text) throws IOException {
        QrCode qrCode = QrCode.encodeText(text, QrCode.Ecc.LOW);
        BufferedImage img = qrCode.toImage(9, 5);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "PNG", outputStream);
        return outputStream;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = generateQRCodeImage(URL);
        ImageIO.write(img, "png", new File("QRCodeGenerator.png"));
    }
}
