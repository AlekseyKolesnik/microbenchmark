package com.kolesnik.generators;

import static com.kolesnik.constants.GeneratingConstants.HEIGHT;
import static com.kolesnik.constants.GeneratingConstants.URL;
import static com.kolesnik.constants.GeneratingConstants.WIDTH;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Zxing {

    public static BufferedImage generateQRCodeImage(String text, int width, int height)
        throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public static ByteArrayOutputStream generateQRCodeStream(String text, int width, int height)
        throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream;
    }

    public static void main(String[] args) throws IOException, WriterException {
        ByteArrayOutputStream pngOutputStream = generateQRCodeStream(URL, WIDTH, HEIGHT);
        try (OutputStream outputStream = new FileOutputStream("QRGen.png")) {
            pngOutputStream.writeTo(outputStream);
        }
    }
}
