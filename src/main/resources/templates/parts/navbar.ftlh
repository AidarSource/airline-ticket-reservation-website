<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd">
    <div class="container-fluid">
        <a class="navbar-brand h1" href="/">Air Booking</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item h5">
                    <a class="nav-link" href="/">Басты бет</a>
                </li>
                <li class="nav-item h5">
                    <a class="nav-link" href="/main">Билеттер</a>
                </li>
                <#if isAdmin>
                <li class="nav-item h5">
                    <a class="nav-link" href="/flights">Билеттермен басқару</a>
                </li>
                <li class="nav-item h5">
                    <a class="nav-link" href="/user">Админ мәзірі</a>
                </li>
            </#if>
            </ul>
        <a class="nav-link h5" href="/profile/${name}">${name} (Жеке кабинет)</a>
        </form>
        <@l.logout />
    </div>
    </div>
</nav>
