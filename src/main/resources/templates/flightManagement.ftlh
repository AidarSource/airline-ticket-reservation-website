<#import "parts/common.ftlh" as c>

<@c.page>
<div class="form-group">
    <form method="post">
        <input type="text" name="fromCity" placeholder="Enter departure city" />
        <input type="text" name="toCity" placeholder="Enter arrival city" />
        <input type="text" name="airplane" placeholder="Enter airplane name" />
        <input type="number" name="price" placeholder="Enter price of the flight">
        <input type="date" name="departureDate">
        <input type="time" name="departureTime">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>
<#list flights as flight>
<br>Flight id: <b>${flight.id}</b>,
From city: <b>${flight.fromCity}</b>,
To city: <b>${flight.toCity}</b>,
Airplane: <b>${flight.airplane}</b>,
Departure date: <b>${flight.departureDate}</b>,
Departure time: <b>${flight.departureTime}</b>,
Price: <b>${flight.price}</b> tenge.
<a href="/purchase?id=${flight.id}">Buy ticket</a>
<#else>
None of the flights available right now
</#list>
</@c.page>