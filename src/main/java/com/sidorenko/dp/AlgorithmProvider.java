package com.sidorenko.dp;

import com.sidorenko.dp.entity.AlgorithmTitle;
import com.sidorenko.dp.entity.EncryptionAlgorithm;
import com.sidorenko.dp.entity.SymmetryAlgorithm;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.sidorenko.dp.entity.AlgorithmTitle.*;

public final class AlgorithmProvider {
    private final Map<AlgorithmTitle, EncryptionAlgorithm> algorithms = new LinkedHashMap<>();
    private static final AlgorithmProvider instance;

    static {
        try {
            instance = new AlgorithmProvider();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private AlgorithmProvider() throws NoSuchAlgorithmException {
        algorithms.put(DES, new SymmetryAlgorithm(DES.name(), 56));
        algorithms.put(AES, new SymmetryAlgorithm(AES.name(), 256));
        algorithms.put(TripleDES, new SymmetryAlgorithm(TripleDES.name(), 168));
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
