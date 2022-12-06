package com.sidorenko.dp;

import com.sidorenko.dp.entity.AlgorithmTitle;
import com.sidorenko.dp.entity.AsymmetricAlgorithm;
import com.sidorenko.dp.entity.EncryptionAlgorithm;
import com.sidorenko.dp.entity.SymmetryAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.sidorenko.dp.entity.AlgorithmTitle.*;

public final class AlgorithmProvider {
    private final Map<AlgorithmTitle, EncryptionAlgorithm> algorithms = new LinkedHashMap<>();
    private static final AlgorithmProvider instance = new AlgorithmProvider();

    private AlgorithmProvider() {
        algorithms.put(DES, new SymmetryAlgorithm(DES.name(), 56));
        algorithms.put(AES, new SymmetryAlgorithm(AES.name(), 256));
        algorithms.put(TripleDES, new SymmetryAlgorithm(TripleDES.name(), 168));
        algorithms.put(RSA, new AsymmetricAlgorithm(RSA.name(), 2048));
        algorithms.put(Blowfish, new SymmetryAlgorithm(Blowfish.name(), 448));
        algorithms.put(RC4, new SymmetryAlgorithm(RC4.name(), 1024));
    }

    //TODO
    public EncryptionAlgorithm getAlgorithm(String title) {
        return algorithms.get(AlgorithmTitle.valueOf(title));
    }

    public static AlgorithmProvider getInstance() {
        return instance;
    }
}
