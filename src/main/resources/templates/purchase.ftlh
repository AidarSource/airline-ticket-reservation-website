<#include "parts/security.ftlh">

<!--Bootstrap CSS -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="styles/login.css" />
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div class="myform form ">
                <div class="logo mb-3">
                    <div class="col-md-12 text-center">
                        <h1>Purchase process id ${flight.id}: ${flight.fromCity} -> ${flight.toCity}</h1>
                        <h1 class="text-success">${flight.price} KZT</h1>
                    </div>
                </div>
                <form method="post">
                    <label>Card number</label>
                    <label id="error1" class="text-danger"></label>
                    <input type="text" class="form-control" name="cardNumber" id="cr_no" placeholder="1234 1234 1234 1234" size="1" min="19" minlength="19" maxlength="19" required>
                    <label>Security code (CVV/CVC)</label>
                    <label id="error2"  class="text-danger"></label>
                    <input type="password" class="form-control" name="securityCode" id="cvv" size="1" minlength="3" maxlength="3" placeholder="Example: 792" required />
                    <label>Expiry Date</label>
                    <label id="error3" class="text-danger"></label>
                    <input type="text" class="form-control" name="expiryDate" id="exp" size="1" minlength="5" maxlength="5" placeholder="Example: 07/25" required />
                    <input type="hidden" class="form-control" name="username" value="${user.username}">
                    <input type="hidden" name="flightId" value="${flight.id}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" id="buy" class="btn btn-block btn-outline-success mybtn btn-primary tx-tfm mt-4" disabled>Сатып алу</button>
                    <a href="/main" class="btn btn-block mybtn btn-primary tx-tfm mt-2">Оралу</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script type='text/javascript'>$(document).ready(function(){

var input1 = false;
var input2 = false;
var input3 = false;

//For Card Number formatted input
var cardNum = document.getElementById('cr_no');
cardNum.onkeyup = function (e) {
    if (this.value == this.lastValue) return;
    var caretPosition = this.selectionStart;
    var sanitizedValue = this.value.replace(/[^0-9]/gi, '');
    var parts = [];

    for (var i = 0, len = sanitizedValue.length; i < len; i += 4) {
        parts.push(sanitizedValue.substring(i, i + 4));
    }

    for (var i = caretPosition - 1; i >= 0; i--) {
        var c = this.value[i];
        if (c < '0' || c > '9') {
            caretPosition--;
        }
    }
    caretPosition += Math.floor(caretPosition / 4);

    this.value = this.lastValue = parts.join(' ');
    this.selectionStart = this.selectionEnd = caretPosition;

    if(cardNum.value.length === 19) {
        input1 = true;
        document.getElementById("error1").innerHTML = "";
        if(input1 && input2 && input3) {
            document.getElementById('buy').disabled = false;
        }
    } else {
        document.getElementById("error1").innerHTML = " * Please fill this section";
    }
}

cardNum.onkeydown = function(e) {
    if(e.keyCode === 8 || e.keyCode === 46) {
        document.getElementById("error1").innerHTML = " * Please fill this section";
        input1 = false;
        document.getElementById('buy').disabled = true;
    }
}

// cvv fullfilment checker
var cvv = document.getElementById('cvv');
cvv.onkeyup = function(e) {
    if(cvv.value.length === 3) {
        input2 = true;
        document.getElementById("error2").innerHTML = "";
        if(input1 && input2 && input3) {
            document.getElementById("error").style.display = 'none';
            document.getElementById('buy').disabled = false;
        }
    } else {
        document.getElementById("error2").innerHTML = " * Please fill this section";
    }
}
cvv.onkeydown = function(e) {
    if(e.keyCode === 8 || e.keyCode === 46) {
        document.getElementById("error2").innerHTML = " * Please fill this section";
        input2 = false;
        document.getElementById('buy').disabled = true;
    }
}

//For Date formatted input
var expDate = document.getElementById('exp');
expDate.onkeyup = function (e) {
    if (this.value == this.lastValue) return;
    var caretPosition = this.selectionStart;
    var sanitizedValue = this.value.replace(/[^0-9]/gi, '');
    var parts = [];

    for (var i = 0, len = sanitizedValue.length; i < len; i += 2) {
        parts.push(sanitizedValue.substring(i, i + 2));
    }

    for (var i = caretPosition - 1; i >= 0; i--) {
        var c = this.value[i];
        if (c < '0' || c > '9') {
            caretPosition--;
        }
    }
    caretPosition += Math.floor(caretPosition / 2);

    this.value = this.lastValue = parts.join('/');
    this.selectionStart = this.selectionEnd = caretPosition;

    if(expDate.value.length === 5) {
        input3 = true;
        document.getElementById("error3").innerHTML = "";
        if(input1 && input2 && input3) {
            document.getElementById('buy').disabled = false;
        }
    } else {
        document.getElementById("error3").innerHTML = " * Please fill this section";
    }
}

expDate.onkeydown = function(e) {
    if(e.keyCode === 8 || e.keyCode === 46) {
        document.getElementById("error3").innerHTML = " * Please fill this section";
        input3 = false;
        document.getElementById('buy').disabled = true;
    }
}

});</script>