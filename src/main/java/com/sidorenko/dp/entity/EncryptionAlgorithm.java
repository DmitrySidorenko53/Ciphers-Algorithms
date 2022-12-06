package com.sidorenko.dp.entity;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public abstract class EncryptionAlgorithm {
    private Cipher cipher;
    private AlgorithmTitle algorithmTitle;
    private Integer keySize;
    private IvParameterSpec ivParameterSpec;


    public EncryptionAlgorithm(String algorithmTitle, Integer keySize) {
        this.algorithmTitle = AlgorithmTitle.valueOf(algorithmTitle);
        this.keySize = keySize;
    }

    public IvParameterSpec getIvParameterSpec() {
        return ivParameterSpec;
    }

    public void setIvParameterSpec(IvParameterSpec ivParameterSpec) {
        this.ivParameterSpec = ivParameterSpec;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String getAlgorithmTitle() {
        return algorithmTitle.name();
    }

    public void setAlgorithmTitle(String algorithmTitle) {
        this.algorithmTitle = AlgorithmTitle.valueOf(algorithmTitle);
    }

    public Integer getKeySize() {
        return keySize;
    }

    public abstract String executeEncryption(Object message) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException;

    public abstract String executeDecryption(Object encryptedMessage) throws
            InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException;
}
