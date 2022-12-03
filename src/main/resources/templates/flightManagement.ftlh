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
            <input type="datetime-local" name="departureDate">
        </li>
        <li class="list-group-item">
            <label>Arrival date:</label>
            <input type="datetime-local" name="arrivalDate">
        </li>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-3" style="width: 50rem;">Add</button>
    </form>
    </ul>
</div>
<#list flights as flight>

<div class="card mt-5">
    <form method="post" action="/save">
    <div class="card-header">
        <h5 class="card-title">
            From: <input type="text" name="fromCity" value="${flight.fromCity}"> to <input type="text" name="toCity" value="${flight.toCity}">
            <br>Current departure date: ${flight.departureDate} <input type="datetime-local" name="departureDate" value="${flight.departureDate}">
            <br>Current arrival date: ${flight.arrivalDate} <input type="datetime-local" name="arrivalDate" value="${flight.arrivalDate}">
        </h5>
    </div>
    <div class="card-body">
        <h5>
            <br>Flight id: <b>${flight.id}</b>,
            <input type="hidden" name="flightId" value="${flight.id}">
            Airplane: <input type="text" name="airplane" value="${flight.airplane}">
            Price: <input type="text" name="price" value="${flight.price}" >
        </h5>
        <div class="mt-5 me-5" style="width:400px;">
            <div style="float: left; width: 130px">

                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit" class="btn btn-outline-success btn-lg">Save</button>
                </form>
            </div>
            <div style="float: right; width: 225px">
                <form method="post" action="/delete">
                    <input type="hidden" name="ticketId" value="${flight.id}"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-outline-danger btn-lg">Delete</button>
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