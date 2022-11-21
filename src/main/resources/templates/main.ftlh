<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a> </span>
</div>
<div>
    <form method="post">
        <input type="text" name="fromCity" placeholder="Enter departure city" />
        <input type="text" name="toCity" placeholder="Enter arrival city" />
        <input type="text" name="airplane" placeholder="Enter airplane name" />
        <input type="number" name="price" placeholder="Enter price of the flight">
        <input type="date" name="departureDate">
        <input type="time" name="departureTime">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</div>
<div>Fill out this form to find an airline ticket for you</div>
<form method="post" action="filter">
    <input type="text" name="fromCity" placeholder="Departure city">
    <input type="text" name="toCity" placeholder="Arrival city">
    <input type="date" name="searchFlightDate">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Find</button>
</form>
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