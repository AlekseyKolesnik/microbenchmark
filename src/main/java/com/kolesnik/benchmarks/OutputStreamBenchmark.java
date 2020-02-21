package com.kolesnik.benchmarks;

import static com.kolesnik.constants.GeneratingConstants.HEIGHT;
import static com.kolesnik.constants.GeneratingConstants.URL;
import static com.kolesnik.constants.GeneratingConstants.WIDTH;

import com.google.zxing.WriterException;
import com.kolesnik.generators.QRCodeGenerator;
import com.kolesnik.generators.QRGen;
import com.kolesnik.generators.Zxing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class OutputStreamBenchmark {

    @Benchmark
    public void zxingGenStreamTest(Blackhole blackhole) throws IOException, WriterException {
        ByteArrayOutputStream pngOutputStream = Zxing.generateQRCodeStream(URL, 120, 120);
        blackhole.consume(pngOutputStream);
    }

    @Benchmark
    public void QRGenTest(Blackhole blackhole) {
        ByteArrayOutputStream pngOutputStream = QRGen.generateQRCodeImage(URL, WIDTH, HEIGHT);
        blackhole.consume(pngOutputStream);
    }

    @Benchmark
    public void QRCodeGeneratorStreamTest(Blackhole blackhole) throws IOException {
        ByteArrayOutputStream pngOutputStream = QRCodeGenerator.generateQRCodeStream(URL);
        blackhole.consume(pngOutputStream);
    }
}
