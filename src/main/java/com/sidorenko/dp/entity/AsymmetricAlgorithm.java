package com.sidorenko.dp.entity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;
import java.util.Base64;

public class AsymmetricAlgorithm extends EncryptionAlgorithm {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private final static String NULL_INPUT_MESSAGE = "PASSED STRING IS EMPTY";

    public AsymmetricAlgorithm(String algorithmTitle, Integer keySize) {
        super(algorithmTitle, keySize);
    }

    @Override
    public void initData() throws NoSuchAlgorithmException, NoSuchPaddingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
                String.valueOf(super.getAlgorithmTitle())
        );
        keyPairGenerator.initialize(super.getKeySize());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
        super.setCipher(Cipher.getInstance(super.getAlgorithmTitle()));

    }

    @Override
    public String executeEncryption(Object message) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (message == null || message.toString().isEmpty()) return NULL_INPUT_MESSAGE;
        super.getCipher().init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptedBytes = super.getCipher().doFinal(
                String.valueOf(message).getBytes()
        );
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String executeDecryption(Object encryptedMessage) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (encryptedMessage == null || encryptedMessage.toString().isEmpty()) return NULL_INPUT_MESSAGE;
        super.getCipher().init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedBytes = super.getCipher().doFinal(
                Base64.getDecoder().decode(encryptedMessage.toString())
        );
        return new String(decryptedBytes);
    }
}
