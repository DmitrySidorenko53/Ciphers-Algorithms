<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.11.2022
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Cipher</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css"
    />
</head>
<body class="bg-black bg-opacity-75 text-white">
<div class="container-lg mt-5 w-75">
    <div class="row justify-content-center">
        <div class="col-lg-5 bg-dark bg-opacity-50 p-3">
            <form action="sidorenko.com" method="post">
                <div class="row mt-3">
                    <div class="col-8">
                        <h3 class="text-start">Cipher Helper</h3>
                    </div>
                    <div class="col-4 align-self-center text-end">
                        <button
                                type="reset"
                                class="btn btn-dark me-2"
                                data-mdb-toggle="tooltip"
                                data-mdb-placement="bottom"
                                title="Cancel"
                        >
                            <i class="fi fi-rr-cross-circle"></i>
                        </button>
                    </div>
                </div>
                <div class="form-floating mb-3 mt-4">
                    <input type="text" name="inputdata" class="form-control bg-dark text-white"
                           id="floatingInputValue" required>
                    <label for="floatingInputValue">Enter</label>
                </div>
                <div class="form-floating mb-3">
                    <select class="form-select bg-dark text-white" required
                            id="floatingSelect" name="title">
                        <option selected></option>
                        <option value="DES">DES</option>
                        <option value="AES">AES</option>
                        <option value="RC4">RC4</option>
                        <option value="Blowfish">Blowfish</option>
                        <option value="RSA">RSA</option>
                        <option value="TripleDES">TripleDes</option>
                    </select>
                    <label for="floatingSelect">Choose algorithm</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" readonly class="form-control-plaintext bg-dark text-white" id="floatingPlaintextInput"
                              placeholder="Last result" value="${result}">
                    <label for="floatingPlaintextInput">Last Result</label>
                </div>
                <div class="row">
                    <div class="col-12 col-sm-6 mb-2">
                        <button
                                type="submit"
                                class="btn btn-dark w-100"
                                data-mdb-toggle="tooltip"
                                data-mdb-placement="bottom"
                                name="command"
                                value="Encrypt"
                        >
                            <i class="fi fi-rr-lock"></i>
                        </button>
                    </div>
                    <div class="col-12 col-sm-6 mb-2">
                        <button
                                type="submit"
                                class="btn btn-dark w-100 me-2"
                                data-mdb-toggle="tooltip"
                                data-mdb-placement="bottom"
                                name="command"
                                value="Decrypt"
                        >
                            <i class="fi fi-rr-unlock"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"
></script>
</body>
</html>
