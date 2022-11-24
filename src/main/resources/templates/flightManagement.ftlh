<#import "parts/common.ftlh" as c>

<@c.page>
<div class="card col-md-8 mx-auto" style="width: 50rem;">
    <div class="card-header">
        <div class="d-flex justify-content-center flex-nowrap">
            <h3>Add new flight form</h3>
        </div>
    </div>
    <ul class="list-group list-group-flush">
    <form method="post" action="add">
        <li class="list-group-item">
            <label>Departure city:</label>
            <input type="text" name="fromCity" placeholder="Enter departure city" />
            <label>Arrival city:</label>
            <input type="text" name="toCity" placeholder="Enter arrival city" />
        </li>
        <li class="list-group-item">
            <label>Airplane:</label>
            <input type="text" name="airplane" placeholder="Enter airplane name" />
            <br><label class="mt-3">Price:</label>
            <input type="number" name="price" placeholder="Enter price of the flight">
        </li>
        <li class="list-group-item">
            <label>Departure date:</label>
            <input type="date" name="departureDate">
            <label>Departure time:</label>
            <input type="time" name="departureTime">
        </li>
        <li class="list-group-item">
            <label>Arrival date:</label>
            <input type="date" name="arrivalDate">
            <label>Arrival time:</label>
            <input type="time" name="arrivalTime">
        </li>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-3" style="width: 50rem;">Add</button>
    </form>
    </ul>
</div>
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
    <form method="post" action="/delete">
        <input type="hidden" name="ticketId" value="${flight.id}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-danger mt-3">Delete</button>
    </form>
</div>

<#else>
<br><br><br>
None of the flights available right now
</#list>
</@c.page>