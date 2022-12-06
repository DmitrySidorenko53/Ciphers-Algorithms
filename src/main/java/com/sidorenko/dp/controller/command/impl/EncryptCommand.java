package com.sidorenko.dp.controller.command.impl;

import com.sidorenko.dp.AlgorithmProvider;
import com.sidorenko.dp.controller.command.Command;
import com.sidorenko.dp.entity.EncryptionAlgorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptCommand implements Command {
    private final AlgorithmProvider algorithmProvider = AlgorithmProvider.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IllegalBlockSizeException,
            NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        EncryptionAlgorithm algorithm = algorithmProvider.getAlgorithm(request.getParameter("title"));
        String dataToEncrypt = request.getParameter("inputdata");
        return algorithm.executeEncryption(dataToEncrypt);
    }
}
