package com.kolesnik.benchmarks;

import static com.kolesnik.constants.GeneratingConstants.URL;

import com.google.zxing.WriterException;
import com.kolesnik.generators.QRCodeGenerator;
import com.kolesnik.generators.Zxing;
import java.awt.image.BufferedImage;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class BufferedImageBenchmark {

    @Benchmark
    public void zxingGenImageTest(Blackhole blackhole) throws WriterException {
        BufferedImage bufferedImage = Zxing.generateQRCodeImage(URL, 120, 120);
        blackhole.consume(bufferedImage);
    }

    @Benchmark
    public void QRCodeGeneratorImageTest(Blackhole blackhole) {
        BufferedImage bufferedImage = QRCodeGenerator.generateQRCodeImage(URL);
        blackhole.consume(bufferedImage);
    }
}
