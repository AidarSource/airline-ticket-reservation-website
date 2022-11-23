<#include "parts/security.ftlh">

<!--Bootstrap CSS -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="styles/login.css" />


<div class="container mt-5">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div class="myform form ">
                <div class="logo mb-3">
                    <div class="col-md-12 text-center">
                        <h1>Purchase process id ${flight.id}: ${flight.fromCity} -> ${flight.toCity}</h1>
                    </div>
                </div>
                <form method="post">
                    <label>Card number</label>
                    <input type="number" class="form-control" name="cardNumber" placeholder="16 digit card number" />
                    <label>Security code (CVV/CVC)</label>
                    <input type="number" class="form-control" name="securityCode" placeholder="Example: 792" />
                    <label>Expiry Date</label>
                    <input type="text" class="form-control" name="expiryDate" placeholder="Example: 07/25" />
                    <input type="hidden" class="form-control" name="username" value="${user.username}">
                    <input type="hidden" name="flightId" value="${flight.id}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-block btn-outline-success mybtn btn-primary tx-tfm mt-4">Buy</button>
                    <a href="/main" class="btn btn-block mybtn btn-primary tx-tfm mt-2">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>

