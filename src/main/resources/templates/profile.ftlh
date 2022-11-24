<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

<h5>Your tickets</h5>

<#list tickets as ticket>

<div class="card mt-4">
    <div class="card-header">
        <h5 class="card-title">From: <b>${ticket.fromCity}</b> to <b>${ticket.toCity}</b>.
            <br>Departure: <b>${ticket.departureTime}</b>, <b>${ticket.departureDate}</b>
            <br>Arrival: <b>${ticket.arrivalTime}</b>, <b>${ticket.arrivalDate}</b>
        </h5>
    </div>
    <div class="card-body"
    <br>Flight id: <b>${ticket.id}</b>,
    Airplane: <b>${ticket.airplane}</b>,
    Price: <b>${ticket.price}</b> tenge.<br>
    <form method="post" action="/refund">
        <input type="hidden" name="username" value="${name}"/>
        <input type="hidden" name="ticketId" value="${ticket.id}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-block btn-primary mt-2">Refund</button>
    </form>
</div>

<#else>
You don't have any active tickets
</#list>
</@c.page>