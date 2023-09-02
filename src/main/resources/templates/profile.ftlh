<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

<h5>Сатып алынған билеттер</h5>

<#list tickets as ticket>

<div class="col">
    <div class="card mt-4">
        <div class="card-header">
            <h5 class="card-title"><b>${ticket.getFlight().fromCity}</b> -> <b>${ticket.getFlight().toCity}</b>.
                <br>Шығуы: <b>${ticket.getFlight().departureDate}</b>
                <br>Келуі: <b>${ticket.getFlight().arrivalDate}</b>
            </h5>
        </div>
        <div class="card-body">
        <br>Рейс нөмері: <b>${ticket.getFlight().id}</b>,
        Ұшақ: <b>${ticket.getFlight().airplane}</b>,
        Бағасы: <b>${ticket.getFlight().price}</b> tenge.<br>
        <form method="post" action="/refund">
            <input type="hidden" name="username" value="${name}"/>
            <input type="hidden" name="ticketId" value="${ticket.id}"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-block btn-primary mt-4">Билетті қайтару</button>
        </form>
    </div>
</div>
<#else>
Сізде сатып алынған билеттер жоқ
</#list>
</@c.page>