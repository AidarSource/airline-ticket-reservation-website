<#import "parts/common.ftlh" as c>

<@c.page>
<div>Fill out this form to find an airline ticket for you</div>
<form method="post" action="filter">
    <input type="text" name="fromCity" placeholder="Departure city">
    <input type="text" name="toCity" placeholder="Arrival city">
    <input type="date" name="searchFlightDate">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Find</button>
</form>
<#list flights as flight>

<div class="card mt-4">
    <div class="card-header">
        <h5 class="card-title">From: <b>${flight.fromCity}</b> to <b>${flight.toCity}</b>.
            <br>Departure: <b>${flight.departureTime}</b>, <b>${flight.departureDate}</b>
            <br>Arrival: <b>${flight.arrivalTime}</b>, <b>${flight.arrivalDate}</b>
        </h5>
    </div>
    <div class="card-body"
    <br>Flight id: <b>${flight.id}</b>,
    Airplane: <b>${flight.airplane}</b>,
    Price: <b>${flight.price}</b> tenge.<br>
    <a href="/purchase?id=${flight.id}" class="btn btn-outline-success btn-lg mt-3">Buy</a>
</div>

<#else>
None of the flights available right now
</#list>
</@c.page>