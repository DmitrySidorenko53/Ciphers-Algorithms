package com.sidorenko.dp.controller;

import com.sidorenko.dp.AlgorithmProvider;
import com.sidorenko.dp.controller.command.Command;
import com.sidorenko.dp.controller.command.CommandProvider;
import com.sidorenko.dp.entity.EncryptionAlgorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@WebServlet(displayName = "controller", urlPatterns = {"/sidorenko.com"})
public class CommandController extends HttpServlet {
    private final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException | NoSuchAlgorithmException |
                 InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            processRequest(req, resp);
        } catch (IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException | NoSuchAlgorithmException |
                 InvalidKeyException | ServletException | IOException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IllegalBlockSizeException,
            NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException, ServletException, IOException, InvalidAlgorithmParameterException {
        String commandName = req.getParameter("command");
        Command command = commandProvider.getCommand(commandName.toUpperCase());
        String response = command.execute(req, resp);
        req.setAttribute("result", response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index");
        dispatcher.forward(req, resp);
    }
}
