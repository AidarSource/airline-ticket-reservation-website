<#import "parts/common.ftlh" as c>

<@c.page>
<h5>Осы формада керек әуе билеттерін іздей аласыз</h5>
<form method="get" action="filter">
    <input type="text" name="fromCity" placeholder="Departure city">
    <input type="text" name="toCity" placeholder="Arrival city">
    <input type="date" name="searchFlightDate">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Іздеу</button>
</form>

<h5 class="mt-3">${message}</h5>




<#list flights as flight>

<div class="col">
    <div class="card mt-4">
        <div class="card-header">
            <h5 class="card-title"><b>${flight.fromCity}</b> -> <b>${flight.toCity}</b>.
                <br>Шығуы: <b>${flight.formattedDepartureDate}</b>
                <br>Келуі: <b>${flight.formattedArrivalDate}</b>
            </h5>
        </div>
        <div class="card-body">
        <br>Рейс номері: <b>${flight.id}</b>,
        Ұшақ: <b>${flight.airplane}</b>,
        Бағасы: <b>${flight.price}</b> tenge.<br>
        <a href="/purchase?id=${flight.id}" class="btn btn-outline-success btn-lg mt-3">Сатып алу</a>
    </div>
</div>


</#list>
</@c.page>