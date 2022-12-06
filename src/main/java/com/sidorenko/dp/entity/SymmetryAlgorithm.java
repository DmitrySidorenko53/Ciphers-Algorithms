package com.sidorenko.dp.entity;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SymmetryAlgorithm extends EncryptionAlgorithm {
    private SecretKey key;
    private final static String NULL_INPUT_MESSAGE = "PASSED STRING IS EMPTY";

    public SymmetryAlgorithm(String algorithmTitle, Integer keySize) {
        super(algorithmTitle, keySize);
    }

    @Override
    public void initData() throws NoSuchAlgorithmException, NoSuchPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(
                String.valueOf(super.getAlgorithmTitle())
        );
        keyGenerator.init(super.getKeySize());
        key = keyGenerator.generateKey();
    }

    @Override
    public String executeEncryption(Object message) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (message == null || message.toString().isEmpty()) return NULL_INPUT_MESSAGE;
        super.setCipher(Cipher.getInstance(super.getAlgorithmTitle()));
        super.getCipher().init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = super.getCipher().doFinal(
                String.valueOf(message).getBytes()
        );
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String executeDecryption(Object encryptedMessage) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (encryptedMessage == null || encryptedMessage.toString().isEmpty()) return NULL_INPUT_MESSAGE;
        super.setCipher(Cipher.getInstance(super.getAlgorithmTitle() + "/ECB/NoPadding"));
        super.getCipher().init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = super.getCipher().doFinal(
                Base64.getDecoder().decode(encryptedMessage.toString())
        );
        return new String(decryptedBytes);
    }
}
