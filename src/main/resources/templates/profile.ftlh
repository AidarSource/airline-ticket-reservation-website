<#import "parts/common.ftlh" as c>

<@c.page>

<h5>Your tickets</h5>

<#list tickets as ticket>

<br>Flight id: <b>${ticket.id}</b>,
From city: <b>${ticket.fromCity}</b>,
To city: <b>${ticket.toCity}</b>,
Airplane: <b>${ticket.airplane}</b>,
Departure date: <b>${ticket.departureDate}</b>,
Departure time: <b>${ticket.departureTime}</b>,
Price: <b>${ticket.price}</b> tenge.

</#list>
</@c.page>