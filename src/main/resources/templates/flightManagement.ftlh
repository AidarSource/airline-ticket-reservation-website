<#import "parts/common.ftlh" as c>

<@c.page>
<div class="card col-md-8 mx-auto" style="width: 50rem;">
    <div class="card-header">
        <div class="d-flex justify-content-center flex-nowrap">
            <h3>Жаңа билетті қосу</h3>
        </div>
    </div>
    <ul class="list-group list-group-flush">
    <form method="post" action="add">
        <li class="list-group-item">
            <label>Шығуы (қала):</label>
            <input type="text" name="fromCity" placeholder="Шығу қаласын енгізіңіз" />
            <label>Келуі (қала):</label>
            <input type="text" name="toCity" placeholder="Келу қаласын енгізіңіз" />
        </li>
        <li class="list-group-item">
            <label>Ұшақ:</label>
            <input type="text" name="airplane" placeholder="Ұшақ атың енгізіңіз" />
            <br><label class="mt-3">Бағасы:</label>
            <input type="number" name="price" placeholder="Билет бағасын енгізіңіз">
        </li>
        <li class="list-group-item">
            <label>Шығу күні:</label>
            <input type="datetime-local" name="departureDate">
        </li>
        <li class="list-group-item">
            <label>Келу күні:</label>
            <input type="datetime-local" name="arrivalDate">
        </li>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-3" style="width: 50rem;">Еңгізу</button>
    </form>
    </ul>
</div>
<#list flights as flight>

<div class="card mt-5">
    <form method="post" action="/save">
    <div class="card-header">
        <h5 class="card-title">
            From: <input type="text" name="fromCity" value="${flight.fromCity}"> -> <input type="text" name="toCity" value="${flight.toCity}">
            <br>Қазіргі шығу уақыты: ${flight.formattedDepartureDate} <input type="datetime-local" name="departureDate" value="${flight.departureDate}">
            <br>Қазіргі келу уақыты: ${flight.formattedArrivalDate} <input type="datetime-local" name="arrivalDate" value="${flight.arrivalDate}">
        </h5>
    </div>
    <div class="card-body">
        <h5>
            <br>Рейс номері: <b>${flight.id}</b>,
            <input type="hidden" name="flightId" value="${flight.id}">
            Ұшақ: <input type="text" name="airplane" value="${flight.airplane}">
            Бағасы: <input type="text" name="price" value="${flight.price}" >
        </h5>
        <div class="mt-5 me-5" style="width:400px;">
            <div style="float: left; width: 130px">

                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit" class="btn btn-outline-success btn-lg">Сақтау</button>
                </form>
            </div>
            <div style="float: right; width: 225px">
                <form method="post" action="/delete">
                    <input type="hidden" name="ticketId" value="${flight.id}"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-outline-danger btn-lg">Өшіру</button>
                </form>
            </div>
        </div>
</div>
<br>
</div>
<#else>
<br><br><br>
None of the flights available right now
</#list>
</@c.page>

<br><br><br><br>